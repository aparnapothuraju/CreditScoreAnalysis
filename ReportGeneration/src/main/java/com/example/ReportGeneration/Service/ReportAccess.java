package com.example.ReportGeneration.Service;

import com.example.ReportGeneration.Model.GeneratedReport;
import com.example.ReportGeneration.Repository.GeneratedReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReportAccess
{
    GeneratedReportRepository generatedReportRepository;

    public ReportAccess(GeneratedReportRepository generatedReportRepository)
    {
        this.generatedReportRepository = generatedReportRepository;
    }
    public GeneratedReport getreport(String id)
    {
        log.info("*** Saving to DB** ");
        return generatedReportRepository.getGeneratedReportByRequestId(id);

    }
}
