package com.app.dashboard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void should_return_user_when_find_id_given_userid() {
        //given
        String id = new ObjectId().toString();
        User user = new User(id, "abd", "asd@gmail.com","pwd","city_name",null,
                "ID", "dev", "12345678", new ArrayList<>(),"admin");
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        //when
        User result = userService.findById(id);
        //then
        verify(userRepository).findById(id);
        assertThat(result, equalTo(user));

    }

}
