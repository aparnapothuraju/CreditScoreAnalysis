package com.example.mockcreditbureau.data;

import com.example.mockcreditbureau.model.CreditBureauReport;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// Simple in-memory "external system" — no DB needed. Mirrors the
// credit_bureau_data table from the SQL seed file so both sources agree.
@Component
public class CreditBureauDataStore {

    private final Map<Integer, CreditBureauReport> reports = new HashMap<>();

    public CreditBureauDataStore() {
        LocalDate reportDate = LocalDate.of(2026, 5, 1);

        reports.put(1, CreditBureauReport.builder().user_id(1).bureau_score(740)
                .existing_loans_count(1).existing_loans_total(120000.00).credit_utilization_pct(22.50)
                .late_payments_last_year(0).defaults_count(0).credit_history_years(12)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(2, CreditBureauReport.builder().user_id(2).bureau_score(690)
                .existing_loans_count(2).existing_loans_total(85000.00).credit_utilization_pct(38.00)
                .late_payments_last_year(1).defaults_count(0).credit_history_years(6)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(3, CreditBureauReport.builder().user_id(3).bureau_score(810)
                .existing_loans_count(1).existing_loans_total(200000.00).credit_utilization_pct(15.00)
                .late_payments_last_year(0).defaults_count(0).credit_history_years(20)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(4, CreditBureauReport.builder().user_id(4).bureau_score(580)
                .existing_loans_count(3).existing_loans_total(150000.00).credit_utilization_pct(78.00)
                .late_payments_last_year(4).defaults_count(1).credit_history_years(4)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(5, CreditBureauReport.builder().user_id(5).bureau_score(760)
                .existing_loans_count(0).existing_loans_total(0.00).credit_utilization_pct(5.00)
                .late_payments_last_year(0).defaults_count(0).credit_history_years(15)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(6, CreditBureauReport.builder().user_id(6).bureau_score(650)
                .existing_loans_count(1).existing_loans_total(30000.00).credit_utilization_pct(45.00)
                .late_payments_last_year(1).defaults_count(0).credit_history_years(3)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(7, CreditBureauReport.builder().user_id(7).bureau_score(520)
                .existing_loans_count(4).existing_loans_total(180000.00).credit_utilization_pct(92.00)
                .late_payments_last_year(6).defaults_count(2).credit_history_years(8)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(8, CreditBureauReport.builder().user_id(8).bureau_score(700)
                .existing_loans_count(1).existing_loans_total(60000.00).credit_utilization_pct(28.00)
                .late_payments_last_year(0).defaults_count(0).credit_history_years(9)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(9, CreditBureauReport.builder().user_id(9).bureau_score(780)
                .existing_loans_count(1).existing_loans_total(90000.00).credit_utilization_pct(18.00)
                .late_payments_last_year(0).defaults_count(0).credit_history_years(14)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());

        reports.put(10, CreditBureauReport.builder().user_id(10).bureau_score(610)
                .existing_loans_count(2).existing_loans_total(40000.00).credit_utilization_pct(55.00)
                .late_payments_last_year(2).defaults_count(0).credit_history_years(2)
                .report_date(reportDate).bureauName("FakeBureau Sweden AB").build());
    }

    public CreditBureauReport findByUserId(int userId) {
        return reports.get(userId);
    }

    public boolean exists(int userId) {
        return reports.containsKey(userId);
    }
}
