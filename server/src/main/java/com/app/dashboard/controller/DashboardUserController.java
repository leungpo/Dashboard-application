package com.app.dashboard.controller;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.service.DashboardUserService;
import com.mongodb.lang.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class DashboardUserController {
    @Autowired
    DashboardUserService dashboardUserService;

    @GetMapping("/{userId}")
    public ResponseEntity<DashboardUserPo> getDashboardUser(@NonNull @PathVariable String userId) {
        DashboardUserPo dashboardUser = dashboardUserService.getDashboardUser(userId);
        return ResponseEntity.ok(dashboardUser);
    }
}
