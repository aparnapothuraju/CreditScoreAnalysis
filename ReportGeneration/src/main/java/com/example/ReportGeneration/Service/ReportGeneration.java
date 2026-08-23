package com.example.ReportGeneration.Service;


import com.example.ReportGeneration.DTO.ScoreResult;
import com.example.ReportGeneration.Model.GeneratedReport;
import com.example.ReportGeneration.Repository.GeneratedReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ReportGeneration
{
    GeneratedReportRepository generatedReportRepository;

    public ReportGeneration(GeneratedReportRepository
                            generatedReportRepository)
    {
        this.generatedReportRepository = generatedReportRepository;
    }
     @KafkaListener(topics = "creditscore",groupId = "reportgeneration")
     public void GenerateReport(ScoreResult scoreResult)
    {
        log.info("*****Score Result recived***");

        String recommendedAction = switch (scoreResult.getRiskLevel()) {
            case "LOW" -> "APPROVE";
            case "MEDIUM" -> "REVIEW";
            default -> "DECLINE";
        };

        log.info("** Creating Summary ***");

        String summary = buildSummary(scoreResult, recommendedAction);

        log.info("***Summary created***");

        GeneratedReport gr= GeneratedReport.builder()
                .userId(scoreResult.getUserId())
                .computedScore(scoreResult.getComputedScore())
                .riskLevel(scoreResult.getRiskLevel())
                .recommendedAction(recommendedAction)
                .summary(summary)
                .generatedAt(LocalDateTime.now()).requestId(scoreResult.getRequestId())
                .build();
         log.info("*Report Generated***");
        GeneratedReport gp= generatedReportRepository.save(gr);

        log.info("Report Saved to DB sucessfully");

    }

    private String buildSummary(ScoreResult scoreResult, String action) {
        String factorsList = String.join(", ", scoreResult.getKeyFactors());
        return String.format("Score: %d (%s risk). Key factors: %s. Recommended action: %s.",
                scoreResult.getComputedScore(), scoreResult.getRiskLevel(), factorsList, action);
    }

}
