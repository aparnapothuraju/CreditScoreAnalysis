package com.example.DatacollectionProcessing.DTO;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreditBureauDTO
{
    public int user_id;
    public int bureau_score;
    public int existing_loans_count;
    public BigDecimal existing_loans_total;
    public BigDecimal credit_utilization_pct;
    public int late_payments_last_year;
    public int defaults_count;
    public int credit_history_years;
    public LocalDate report_date;
}
