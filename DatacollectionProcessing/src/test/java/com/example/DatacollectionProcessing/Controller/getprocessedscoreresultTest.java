package com.example.DatacollectionProcessing.Controller;

import com.example.DatacollectionProcessing.DTO.ProcessedData;
import com.example.DatacollectionProcessing.Service.Datacollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class getprocessedscoreresultTest
{
    @Mock
    Datacollection datacollection;

    @InjectMocks
    DataCollectionProcess dataCollectionProcess;

    @Test
    void test()
    {
        String requestid= UUID.randomUUID().toString();
        int userid=1;
        BigDecimal score= new BigDecimal(300);
        ProcessedData processedData = new ProcessedData(requestid,userid,score,score,score,2,4,45,2,score,score,0,7);

        when(datacollection.CollectandPublish(anyInt(),anyString())).thenReturn(processedData);

        ResponseEntity<HashMap<String,ProcessedData>> pd= dataCollectionProcess.getprocessedscoreresult(userid);

        assertThat(pd.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(pd).isNotNull();
        assertThat(pd.getBody().containsValue(processedData)).isTrue();

    }
}