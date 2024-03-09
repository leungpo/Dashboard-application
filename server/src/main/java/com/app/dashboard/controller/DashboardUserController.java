package com.app.dashboard.controller;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.service.DashboardUserService;
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

    @GetMapping("/{userName}")
    public ResponseEntity<DashboardUserPo> getDashboardUser(@PathVariable String userName) {
        DashboardUserPo dashboardUser = dashboardUserService.getDashboardUser(userName);
        return dashboardUser != null ? ResponseEntity.ok(dashboardUser): ResponseEntity.notFound().build();
    }
}
