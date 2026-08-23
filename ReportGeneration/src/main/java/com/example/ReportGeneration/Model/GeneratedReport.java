package com.example.ReportGeneration.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GeneratedReport
{
    @Id
    private String requestId;
    private  int userId;
    private  int computedScore;
    private  String riskLevel;
    private LocalDateTime generatedAt;
    private String summary;
    private String recommendedAction;

}
