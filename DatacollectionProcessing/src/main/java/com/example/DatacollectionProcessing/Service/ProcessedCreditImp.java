package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.CreditBureau;
import com.example.DatacollectionProcessing.DTO.CreditBureauDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProcessedCreditImp implements ProcessedCredit
{
    RestTemplate restTemplate;

    public ProcessedCreditImp(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public CreditBureauDTO getdata(int id)
    {

       CreditBureauDTO transaction=restTemplate.getForObject("http://localhost:9096/v1/credit-report/"+id, CreditBureauDTO.class);
        return transaction;

    }
}
