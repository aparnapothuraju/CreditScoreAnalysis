package com.example.DatacollectionProcessing.DTO;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProcessedDataDTO
{
    public BigDecimal averageMonthlyIncome;
    public BigDecimal averageMonthlyExpenses;
    public BigDecimal currentBalance;          // <-- most recent, and it's negative!
    public int monthsOfNegativeBalance;
    public int totalLoanPaymentsMade;

    public int bureauScore;
    public int existingLoansCount;
    public BigDecimal existingLoansTotal;
    public BigDecimal creditUtilizationPct;       // <-- high
    public int defaultsCount;              // <-- has a default
    public int creditHistoryYears;
}
