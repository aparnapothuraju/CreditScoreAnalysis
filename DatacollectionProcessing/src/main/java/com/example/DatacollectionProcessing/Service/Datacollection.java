package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Datacollection
{

    KafkaTemplate<String, ProcessedData> kafkaTemplate;
    ProcessedCreditImp processedCreditImp;
    ProcessedBankImp processedBankImp;
    ProcessDataImp processDataImp;
    ProcessBankTransactionDataImp processedProcessBankTransactionDataImp;

    public Datacollection(ProcessedCreditImp pc, ProcessedBankImp pb, ProcessDataImp pd, ProcessBankTransactionDataImp pbtr, KafkaTemplate<String, ProcessedData> kafkaTemplate)
    {
        this.processedCreditImp = pc;
        this.processedBankImp = pb;
        this.processDataImp = pd;
        this.processedProcessBankTransactionDataImp = pbtr;
        this.kafkaTemplate = kafkaTemplate;
    }

    public ProcessedData CollectandPublish(int id,String request)
    {
        List<BankTransactionDTO> bankTransactionList=processedBankImp.getProcessedData(id);
        CreditBureauDTO creditBureau=processedCreditImp.getdata(id);

       ProcessedDataDTO pd= processDataImp.getProcessData(bankTransactionList,creditBureau,id);

        ProcessedData p=ProcessedData.builder().
               averageMonthlyExpenses(pd.getAverageMonthlyExpenses())
               .averageMonthlyIncome(pd.getAverageMonthlyIncome())
               .bureauScore(pd.getBureauScore()).creditHistoryYears(pd.getCreditHistoryYears())
               .creditUtilizationPct(pd.getCreditUtilizationPct())
               .currentBalance(pd.getCurrentBalance()).monthsOfNegativeBalance(pd.getMonthsOfNegativeBalance())
               .existingLoansCount(pd.getExistingLoansCount())
               .existingLoansTotal(pd.getExistingLoansTotal())
               .id(id).requestId(request)
               .totalLoanPaymentsMade(pd.getTotalLoanPaymentsMade()).defaultsCount(pd.getDefaultsCount()).build();

        kafkaTemplate.send("processedata",p);

        return p;



    }
}
