package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessDataImp
{

    ProcessBankTransactionData processBankTransactionData;

    public ProcessDataImp(ProcessBankTransactionData processBankTransactionData)
    {
        this.processBankTransactionData = processBankTransactionData;
    }

    public ProcessedDataDTO getProcessData(List<BankTransactionDTO> bankTransaction, CreditBureauDTO creditBureau, int userid)
    {
        ProcessedDataDTO processedDataDTO = new ProcessedDataDTO();

        processedDataDTO.setAverageMonthlyExpenses(processBankTransactionData.averageMonthlyExpenses(bankTransaction,userid));
        processedDataDTO.setCurrentBalance(processBankTransactionData.currentBalance(bankTransaction,userid));
        processedDataDTO.setAverageMonthlyIncome(processBankTransactionData.averageMonthlyIncome(bankTransaction,userid));
        processedDataDTO.setTotalLoanPaymentsMade(processBankTransactionData.totalLoanPaymentsMade(bankTransaction,userid));
        processedDataDTO.setMonthsOfNegativeBalance(processBankTransactionData.monthsOfNegativeBalance(bankTransaction,userid));
        processedDataDTO.setBureauScore(creditBureau.getBureau_score());
        processedDataDTO.setExistingLoansCount(creditBureau.getExisting_loans_count());
        processedDataDTO.setExistingLoansTotal(creditBureau.getExisting_loans_total());
        processedDataDTO.setCreditUtilizationPct(creditBureau.getCredit_utilization_pct());
        processedDataDTO.setDefaultsCount(creditBureau.getDefaults_count());
        processedDataDTO.setCreditHistoryYears(creditBureau.getCredit_history_years());

        return processedDataDTO;
    }


}
