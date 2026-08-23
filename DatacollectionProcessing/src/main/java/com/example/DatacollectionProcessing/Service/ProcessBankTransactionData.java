package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.BankTransactionDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProcessBankTransactionData
{
    public BigDecimal averageMonthlyIncome(List<BankTransactionDTO> banklist, int userid);
    public BigDecimal averageMonthlyExpenses(List<BankTransactionDTO> banklist,int userid);
    public BigDecimal currentBalance(List<BankTransactionDTO> banklist,int userid);          // <-- most recent, and it's negative!
    public int monthsOfNegativeBalance(List<BankTransactionDTO> banklist,int userid);
    public int totalLoanPaymentsMade(List<BankTransactionDTO> banklist,int userid);
}
