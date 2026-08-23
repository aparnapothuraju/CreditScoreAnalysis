package com.example.DatacollectionProcessing.Service;

import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.BankTransactionDTO;
import com.example.DatacollectionProcessing.DTO.ProcessedData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessedBankImp implements ProcessedBank
{
       RestTemplate restTemplate;

       public ProcessedBankImp(RestTemplate restTemplate)
       {
           this.restTemplate = restTemplate;
       }

       public List<BankTransactionDTO> getProcessedData(int id)
       {
           ResponseEntity<List<BankTransactionDTO>> response =
                   restTemplate.exchange(
                           "http://localhost:9097/api/transactions/user/" + id,
                           HttpMethod.GET,
                           null,
                           new ParameterizedTypeReference<List<BankTransactionDTO>>() {}
                   );

           return response.getBody();
       }

}
