package com.drpicox.blog.com.drpicox.blog.reports;

import com.drpicox.blog.reports.Report;
import com.drpicox.blog.reports.ReportRepository;
import com.drpicox.blog.posts.Post;
import com.drpicox.blog.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportsHelper {

    @Autowired
    private ReportRepository reportRepository;

    public void cleanup() throws Exception {
        reportRepository.deleteAllInBatch();
    }

    public Report make(String reason) { return make(reason); }

    public Report make(String reason, User user) {
        return make(reason, null, user);
    }

    public Report make(String reason, Post post) {
        return make(reason, post);
    }

    public Report make(String reason, Post post, User user) {
        Report report = new Report(null, reason, post, user);
        reportRepository.save(report);
        return report;
    }
}
