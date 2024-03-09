package com.app.dashboard;

import com.app.dashboard.controller.DashboardUserController;
import com.app.dashboard.entity.DashboardUserPo;
import com.app.dashboard.exception.UserNotFoundException;
import com.app.dashboard.service.DashboardUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(DashboardUserController.class)
public class DashboardUserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    DashboardUserService dashboardUserService;

    public static final String ID = "ID";

    @Test
    void should_get_user_when_perform_get_by_id_given_a_id() throws Exception {
        //given
        DashboardUserPo dashBoardUser = DashboardUserPo.builder()
                .id(ID)
                .build();
        doReturn(dashBoardUser).when(dashboardUserService).getDashboardUser(ID);

        //when
        mockMvc.perform(get("/users/{userId}", dashBoardUser.getId())
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(dashBoardUser)));

        //then
        verify(dashboardUserService, times(1)).getDashboardUser(dashBoardUser.getId());
    }

    /**
     * should: return 404
     * when: cannot find user
     * given: no user information
     */
    @Test
    void should_return_404_when_cannot_find_user_given_no_user_information() throws Exception {
        //given
        DashboardUserPo dashBoardUser = DashboardUserPo.builder()
                .id(ID)
                .build();
        doThrow(new UserNotFoundException()).when(dashboardUserService).getDashboardUser(ID);

        //when
        mockMvc.perform(get("/users/{userId}", dashBoardUser.getId())
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        //then
        verify(dashboardUserService, times(1)).getDashboardUser(dashBoardUser.getId());
    }
}