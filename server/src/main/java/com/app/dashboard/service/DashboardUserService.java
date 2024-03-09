package com.app.dashboard.service;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.repository.DashboardUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardUserService {
    @Autowired
    DashboardUserRepository dashboardUserRepository;

    public DashboardUserPo getDashboardUser(String userName) {
        return dashboardUserRepository.findUserByUserId(userName);
    }
}
