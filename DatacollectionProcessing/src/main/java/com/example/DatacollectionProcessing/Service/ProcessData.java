package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.*;

import java.util.List;

public interface ProcessData
{
    ProcessedDataDTO getProcessData(List<BankTransactionDTO> bankTransactiondto, CreditBureauDTO creditBureau, int userid);
}
