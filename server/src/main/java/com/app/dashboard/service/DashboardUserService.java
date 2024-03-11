package com.app.dashboard.service;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.repository.DashboardUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardUserService {
    @Autowired
    DashboardUserRepository dashboardUserRepository;

    public DashboardUserPo getDashboardUser(String userId) {
        return dashboardUserRepository.findUserByUserId(userId);
    }

    public DashboardUserPo inputDashboardUser() {
        DashboardUserPo user = DashboardUserPo.builder()
                .userId("123")
                .name("abd")
                .email("email")
                .password("password")
                .cityId("cityId")
                .state(true)
                .countryId("countryId")
                .occupation("occupation")
                .phoneNumber("phoneNumber")
                .role("role")
                .transactions(null)
                .build();
        return dashboardUserRepository.save(user);
    }
}
