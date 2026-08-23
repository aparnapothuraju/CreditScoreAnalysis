package com.example.mockcreditbureau.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// Deliberately shaped a bit "external-system-ish" (different field names /
// nesting than your internal DB) so your Data Collection Service actually
// has real normalization work to do — same as a real bureau feed would.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditBureauReport {

    private int user_id;
    private int bureau_score;              // raw external score, 300-850 scale
    private int existing_loans_count;
    private double existing_loans_total;
    private double credit_utilization_pct;
    private int late_payments_last_year;
    private int defaults_count;
    private int credit_history_years;
    private LocalDate report_date;
    private String bureauName;             // e.g. "FakeBureau Sweden AB"
}
