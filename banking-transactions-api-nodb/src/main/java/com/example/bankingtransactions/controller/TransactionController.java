package com.example.bankingtransactions.controller;

import com.example.bankingtransactions.data.BankingTransactionDataStore;
import com.example.bankingtransactions.model.BankingTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final BankingTransactionDataStore dataStore;

    public TransactionController(BankingTransactionDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getTransactionsByUser(@PathVariable int userId) {

        if (!dataStore.userExists(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No transactions found for userId " + userId));
        }

        List<BankingTransaction> transactions = dataStore.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/user/{userId}/type/{transactionType}")
    public ResponseEntity<List<BankingTransaction>> getByType(
            @PathVariable int userId,
            @PathVariable String transactionType) {

        return ResponseEntity.ok(dataStore.findByUserIdAndType(userId, transactionType));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "banking-transactions-api-nodb"));
    }
}
