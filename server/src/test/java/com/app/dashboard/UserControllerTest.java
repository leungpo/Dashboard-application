package com.app.dashboard;

import com.app.dashboard.entity.User;
import com.app.dashboard.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc client;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void clearDB() {
        userRepository.deleteAll();
    }

    public static final String NAME = "abd";
    public static final String EMAIL = "asd@gmail.com";
    public static final String PASSWORD = "pwd";
    public static final String CITY_ID = "city_id";
    public static final Boolean STATE = null;
    public static final String ID = "ID";
    public static final String OCCUPATION = "dev";
    public static final String PHONE_NUMBER = "12345678";
    public static final ArrayList<String> TRANSACTIONS = new ArrayList<>();
    public static final String ADMIN = "admin";


    @Test
    void should_get_user_when_perform_get_by_id_given_a_id() throws Exception {
        //given
        User user = new User( new ObjectId().toString(), NAME, EMAIL, PASSWORD, CITY_ID, STATE,
                ID, OCCUPATION, PHONE_NUMBER, TRANSACTIONS, ADMIN);
        userRepository.save(user);
        //when & then
        client.perform(MockMvcRequestBuilders.get("/users/{id}",user.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(NAME));
    }
}
