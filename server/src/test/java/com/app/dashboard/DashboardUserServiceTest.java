package com.app.dashboard;

import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.exception.UserNotFoundException;
import com.app.dashboard.repository.DashboardUserRepository;
import com.app.dashboard.service.DashboardUserService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        String id = new ObjectId().toString();
        DashboardUserPo dashBoardUser = DashboardUserPo.builder()
                .id(id)
                .name("name")
                .email("email")
                .password("password")
                .cityId("cityId")
                .state(true)
                .countryId("countryId")
                .occupation("occupation")
                .phoneNumber("phoneNumber")
                .transactions(new ArrayList<>())
                .role("role")
                .build();
        doReturn(Optional.of(dashBoardUser)).when(dashboardUserRepository).findById(id);

        //when
        DashboardUserPo result = dashboardUserService.getDashboardUser(id);

        //then
        verify(dashboardUserRepository,times(1)).findById(id);
        assertEquals(result, dashBoardUser);
    }

    /**
     * should: return user
     * when: having userid
     * given: user in mongodb
     */
    @Test
    void should_return_user_when_having_userid_given_user_in_mongodb() {
        //given
        String id = new ObjectId().toString();
        doThrow(new UserNotFoundException()).when(dashboardUserRepository).findById(id);

        //when
        //then
        assertThrows(UserNotFoundException.class, () -> dashboardUserService.getDashboardUser(id));
    }
}