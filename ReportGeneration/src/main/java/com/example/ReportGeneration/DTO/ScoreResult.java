package com.example.ReportGeneration.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreResult {
    private int userId;
    private String requestId;
    private  int computedScore;
    private  String riskLevel;
    private  List<String> keyFactors;
}
