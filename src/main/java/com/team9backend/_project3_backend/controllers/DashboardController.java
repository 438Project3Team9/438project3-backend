package com.team9backend._project3_backend.controllers;

import com.team9backend._project3_backend.dto.DashboardResponseDto;
import com.team9backend._project3_backend.services.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public ResponseEntity<DashboardResponseDto> getDashboard() {
        String email = "test@example.com";
        return ResponseEntity.ok(dashboardService.getDashboard(email));
    }
}