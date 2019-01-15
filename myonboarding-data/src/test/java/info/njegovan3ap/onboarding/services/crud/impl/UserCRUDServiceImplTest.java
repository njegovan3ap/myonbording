package info.njegovan3ap.onboarding.services.crud.impl;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserCRUDServiceImplTest {
    private static final String FIRST_NAME = "Aria";
    private static final String LAST_NAME = "Giovanni";
    private static final String EMAIL_ADDRESS = "contactme@ariagiovanni.info";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserCRUDServiceImpl userService;

    private User returnUser;

    @BeforeEach
    void setUp() {
        returnUser = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();
    }

    @Test
    void findAll() {
        List<User> userSet = new ArrayList<>();
        userSet.add(User.builder().build());
        userSet.add(User.builder().build());

        when(userRepository.findAll()).thenReturn(userSet);

        List<User> users = userService.findAll();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    void findById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(returnUser));

        User user = userService.findById(1L);

        assertNotNull(user);
    }

    @Test
    void save() {
        when(userRepository.save(any())).thenReturn(returnUser);

        User savedUser = userService.save(new User());

        assertNotNull(savedUser);
        verify(userRepository).save(any());
    }

    @Test
    void delete() {
        userService.delete(returnUser);

        verify(userRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        userService.deleteById(1L);

        verify(userRepository).deleteById(anyLong());
    }
}