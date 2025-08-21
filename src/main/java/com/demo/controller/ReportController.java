package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.service.ReportService;


@Controller
public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/report")
    public String showReport(Model model) {
        model.addAttribute("report", service.getReport());
        return "report";
    }
}