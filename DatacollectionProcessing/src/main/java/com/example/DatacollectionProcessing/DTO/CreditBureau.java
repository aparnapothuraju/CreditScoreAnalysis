package com.example.DatacollectionProcessing.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditBureau
{
    private int user_id;
    private int bureau_score;
    private int existing_loans_count;
    private BigDecimal existing_loans_total;
    private BigDecimal credit_utilization_pct;
    private int late_payments_last_year;
    private int defaults_count;
    private int credit_history_years;
    private LocalDateTime report_date;
}
