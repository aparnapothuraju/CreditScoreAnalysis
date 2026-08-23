package com.example.DatacollectionProcessing.Controller;


import com.example.DatacollectionProcessing.DTO.BankTransaction;
import com.example.DatacollectionProcessing.DTO.CreditBureau;
import com.example.DatacollectionProcessing.DTO.ProcessedData;
import com.example.DatacollectionProcessing.Service.Datacollection;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RequestMapping("DatacollectionProcessing")
public class DataCollectionProcess
{
    Datacollection datacollection;

    public DataCollectionProcess(Datacollection datacollection)
    {
        this.datacollection = datacollection;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<HashMap<String,ProcessedData>> getprocessedscoreresult(@PathVariable int id)
    {
        String requestId = UUID.randomUUID().toString();
        ProcessedData p= datacollection.CollectandPublish(id,requestId);
        HashMap<String,ProcessedData> result=new HashMap<>();
        result.put(requestId,p);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
