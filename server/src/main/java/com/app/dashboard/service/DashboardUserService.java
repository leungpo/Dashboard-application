package com.app.dashboard.service;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.exception.UserNotFoundException;
import com.app.dashboard.repository.DashboardUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardUserService {

    @Autowired
    DashboardUserRepository dashboardUserRepository;

    public DashboardUserPo getDashboardUser(String userId) {
        return dashboardUserRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
