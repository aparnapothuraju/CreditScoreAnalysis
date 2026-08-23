package com.example.DatacollectionProcessing.DTO;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProcessedData
{
    private String requestId;
    private int id;
    private BigDecimal averageMonthlyIncome;
    private BigDecimal averageMonthlyExpenses;
    private BigDecimal currentBalance;          // <-- most recent, and it's negative!
    private int monthsOfNegativeBalance;
    private int totalLoanPaymentsMade;

    private int bureauScore;
    private int existingLoansCount;
    private BigDecimal existingLoansTotal;
    private BigDecimal creditUtilizationPct;       // <-- high
    private int defaultsCount;              // <-- has a default
    private int creditHistoryYears;
}
