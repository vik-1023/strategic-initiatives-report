package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.demo.projection.ReportProjection;
import com.demo.repository.ReportRepository;

@Service
public class ReportService {
    private final ReportRepository repo;

    public ReportService(ReportRepository repo) {
        this.repo = repo;
    }

    public List<ReportProjection> getReport() {
        List<ReportProjection> resp = repo.fetchReport();
        for (ReportProjection ent : resp) {
            System.out.println(ent);
        }
        return resp;
    }
}
