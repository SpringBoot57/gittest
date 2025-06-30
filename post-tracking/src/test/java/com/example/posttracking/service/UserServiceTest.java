package com.example.posttracking.service;

import com.example.posttracking.entity.User;
import com.example.posttracking.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserService.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void findAllReturnsUsers() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(new User()));
        List<User> users = userService.findAll();
        assertThat(users).hasSize(1);
    }
}
