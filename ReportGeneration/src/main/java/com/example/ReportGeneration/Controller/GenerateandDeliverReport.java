package com.example.ReportGeneration.Controller;

import com.example.ReportGeneration.Model.GeneratedReport;
import com.example.ReportGeneration.Service.ReportAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ReportGeneration")
public class GenerateandDeliverReport
{
    ReportAccess reportAccess;
    public GenerateandDeliverReport(ReportAccess reportAccess)
    {
        this.reportAccess = reportAccess;
    }
    @GetMapping("/{id}")
    public ResponseEntity<GeneratedReport> getreportstatus(@PathVariable String id)
    {
        GeneratedReport report = new GeneratedReport();
        report= reportAccess.getreport(id);

        if(report==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.OK).body(report);
    }
}
