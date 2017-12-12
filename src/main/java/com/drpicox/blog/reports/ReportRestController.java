package com.drpicox.blog.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/reports")
public class ReportRestController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    public ReportRestController() {}

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Report createReport(@RequestBody Report report) {
        reportRepository.save(report);
        return report;
    }

    @GetMapping()
    public Collection<Report> getReports() { return reportRepository.findAllByOrderByIdDesc(); }

}
