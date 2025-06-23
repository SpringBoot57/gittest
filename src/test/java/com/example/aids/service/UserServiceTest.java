package com.example.aids.service;

import com.example.aids.entity.User;
import com.example.aids.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void register_shouldCreateUser() {
        UserRepository repository = Mockito.mock(UserRepository.class);
        Mockito.when(repository.save(Mockito.any())).thenAnswer(i -> i.getArguments()[0]);
        UserService service = new UserService(repository);
        User user = service.register("test","pass");
        assertEquals("test", user.getUsername());
        assertNotNull(user.getPassword());
    }
}
