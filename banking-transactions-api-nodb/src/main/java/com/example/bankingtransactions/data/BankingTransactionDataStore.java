package com.example.bankingtransactions.data;

import com.example.bankingtransactions.model.BankingTransaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// No database at all -- everything lives in memory, built fresh on every
// app startup. Mirrors credit_score_dummy_data.sql's banking_transactions
// table exactly, so results match what you'd get from the DB-backed version.
@Component
public class BankingTransactionDataStore {

    private final List<BankingTransaction> transactions = new ArrayList<>();
    private int nextId = 1;

    public BankingTransactionDataStore() {
        add(1, "2026-06-01T09:00:00", "32000.00", "CREDIT", "SALARY", "45230.50");
        add(1, "2026-06-03T14:20:00", "9500.00", "DEBIT", "RENT", "35730.50");
        add(1, "2026-06-10T11:00:00", "2200.00", "DEBIT", "LOAN_PAYMENT", "33530.50");

        add(2, "2026-06-01T09:05:00", "28000.00", "CREDIT", "SALARY", "31200.00");
        add(2, "2026-06-04T10:00:00", "8000.00", "DEBIT", "RENT", "23200.00");
        add(2, "2026-06-15T18:30:00", "1200.00", "DEBIT", "UTILITY", "22000.00");

        add(3, "2026-06-02T09:00:00", "41000.00", "CREDIT", "SALARY", "52000.00");
        add(3, "2026-06-05T12:00:00", "15000.00", "DEBIT", "LOAN_PAYMENT", "37000.00");
        add(3, "2026-06-20T17:00:00", "3000.00", "DEBIT", "GROCERY", "34000.00");

        add(4, "2026-06-01T09:00:00", "19000.00", "CREDIT", "SALARY", "4500.00");
        add(4, "2026-06-08T13:00:00", "12000.00", "DEBIT", "LOAN_PAYMENT", "-7500.00");

        add(5, "2026-06-01T09:10:00", "55000.00", "CREDIT", "SALARY", "61000.00");
        add(5, "2026-06-06T11:30:00", "10000.00", "DEBIT", "RENT", "51000.00");

        add(6, "2026-06-01T09:15:00", "24000.00", "CREDIT", "SALARY", "26500.00");
        add(6, "2026-06-12T15:00:00", "3000.00", "DEBIT", "UTILITY", "23500.00");

        add(7, "2026-06-01T09:20:00", "15000.00", "CREDIT", "SALARY", "2000.00");
        add(7, "2026-06-09T10:00:00", "8000.00", "DEBIT", "LOAN_PAYMENT", "-6000.00");

        add(8, "2026-06-01T09:25:00", "33000.00", "CREDIT", "SALARY", "40200.00");
        add(8, "2026-06-07T09:40:00", "9000.00", "DEBIT", "RENT", "31200.00");

        add(9, "2026-06-01T09:30:00", "47000.00", "CREDIT", "SALARY", "58000.00");
        add(9, "2026-06-11T16:00:00", "5000.00", "DEBIT", "GROCERY", "53000.00");

        add(10, "2026-06-01T09:35:00", "21000.00", "CREDIT", "SALARY", "23800.00");
        add(10, "2026-06-14T12:00:00", "2500.00", "DEBIT", "UTILITY", "21300.00");
    }

    private void add(int userId, String date, String amount, String type, String category, String balance) {
        transactions.add(BankingTransaction.builder()
                .transactionId(nextId++)
                .user_id(userId)
                .transaction_date(LocalDateTime.parse(date))
                .amount(new BigDecimal(amount))
                .transaction_type(type)
                .category(category)
                .balance_after(new BigDecimal(balance))
                .build());
    }

    public List<BankingTransaction> findByUserId(int userId) {
        return transactions.stream()
                .filter(t -> t.getUser_id() == userId)
                .sorted((a, b) -> b.getTransaction_date().compareTo(a.getTransaction_date())) // most recent first
                .collect(Collectors.toList());
    }

    public List<BankingTransaction> findByUserIdAndType(int userId, String transactionType) {
        return findByUserId(userId).stream()
                .filter(t -> t.getTransaction_type().equalsIgnoreCase(transactionType))
                .collect(Collectors.toList());
    }

    public boolean userExists(int userId) {
        return transactions.stream().anyMatch(t -> t.getUser_id() == userId);
    }
}
