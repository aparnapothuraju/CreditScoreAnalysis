package com.example.ReportGeneration.Repository;

import com.example.ReportGeneration.Model.GeneratedReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedReportRepository extends JpaRepository<GeneratedReport, Long>
{
    public GeneratedReport save(GeneratedReport generatedReport);
    public GeneratedReport getGeneratedReportByRequestId(String id);
}
