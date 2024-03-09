package com.app.dashboard.controller;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.service.DashboardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class DashboardUserController {
    @Autowired
    DashboardUserService dashboardUserService;

    @GetMapping("/{userId}")
    public ResponseEntity<DashboardUserPo> getDashboardUser(@PathVariable String userId) {
        DashboardUserPo dashboardUser = dashboardUserService.getDashboardUser(userId);
        return dashboardUser != null ? ResponseEntity.ok(dashboardUser): ResponseEntity.noContent().build();
    }

    @PostMapping("/input")
    public ResponseEntity<DashboardUserPo> inputDashboardUser() {
        DashboardUserPo newDashboardUser = dashboardUserService.inputDashboardUser();
        return ResponseEntity.ok(newDashboardUser);
    }
}
