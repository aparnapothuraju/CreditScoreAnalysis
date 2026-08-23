package com.example.ReportGeneration.Controller;

import com.example.ReportGeneration.Model.GeneratedReport;
import com.example.ReportGeneration.Service.ReportAccess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenerateAndDeliverReportTest {

    @Mock
    private ReportAccess reportAccess;

    @InjectMocks
    private GenerateandDeliverReport generateAndDeliverReport;

    @Test
    @DisplayName("Should return HTTP 200 and report details when given a valid report ID")
    void testGetReportStatus() {
        // 1. Given (Arrange)
        String reportId = "fe5dc999-b3b9-49e6-9bb6-27bd88c203f2";
        GeneratedReport mockReport = new GeneratedReport(
                reportId, 0, 754, "LOW",
                LocalDateTime.parse("2026-08-18T22:50:00"),
                "Score: 754 (LOW risk). Key factors: 3 late payment(s)...",
                "APPROVE"
        );

        // Stub the mock dependency (reportAccess), NOT the class under test
        when(reportAccess.getreport(reportId)).thenReturn(mockReport);

        // 2. When (Act)
        ResponseEntity<GeneratedReport> response = generateAndDeliverReport.getreportstatus(reportId);

        // 3. Then (Assert)
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getRequestId()).isEqualTo(reportId);
    }
}