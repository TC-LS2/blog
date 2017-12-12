package com.drpicox.blog.reports;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReportRepository extends JpaRepository<Report, Long> {

    public Collection<Report> findAllByOrderByIdDesc();

}
