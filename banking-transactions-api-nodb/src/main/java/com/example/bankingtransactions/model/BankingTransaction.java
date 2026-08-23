package com.example.bankingtransactions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Plain POJO -- no @Entity, no @Table, no @Column. This is exactly the
// contract your Data Collection Service's "raw" DTO should mirror,
// per the earlier discussion on knowing the response shape upfront.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankingTransaction {
    private int transactionId;
    private int user_id;
    private LocalDateTime transaction_date;
    private BigDecimal amount;
    private String transaction_type;   // CREDIT, DEBIT
    private String category;          // SALARY, RENT, LOAN_PAYMENT, GROCERY, UTILITY, TRANSFER
    private BigDecimal balance_after;
}
