package com.app.dashboard;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.repository.DashboardUserRepository;
import com.app.dashboard.service.DashboardUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class DashboardUserServiceTest {
    @Mock
    DashboardUserRepository dashboardUserRepository;

    @InjectMocks
    DashboardUserService dashboardUserService;

    @Test
    void should_return_user_when_find_id_given_userid() {
        //given
        String userId = "userId";
        DashboardUserPo dashBoardUser = DashboardUserPo.builder()
                .userId(userId)
                .name("name")
                .email("email")
                .password("password")
                .cityId("cityId")
                .state(true)
                .countryId("countryId")
                .occupation("occupation")
                .phoneNumber("phoneNumber")
                .role("role")
                .build();
        doReturn(dashBoardUser).when(dashboardUserRepository).findUserByUserId(userId);

        //when
        DashboardUserPo result = dashboardUserService.getDashboardUser(userId);

        //then
        verify(dashboardUserRepository,times(1)).findUserByUserId(userId);
        assertEquals(result, dashBoardUser);
    }
}