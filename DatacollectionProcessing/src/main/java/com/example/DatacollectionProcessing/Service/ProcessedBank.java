package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.BankTransactionDTO;

import java.util.List;


public interface ProcessedBank
{
    public List<BankTransactionDTO> getProcessedData(int id);
}
