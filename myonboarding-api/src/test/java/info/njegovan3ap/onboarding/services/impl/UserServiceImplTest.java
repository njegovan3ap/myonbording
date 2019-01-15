package info.njegovan3ap.onboarding.services.impl;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.mapper.UserMapper;
import info.njegovan3ap.onboarding.model.UserDTO;
import info.njegovan3ap.onboarding.model.UserListDTO;
import info.njegovan3ap.onboarding.services.UserService;
import info.njegovan3ap.onboarding.services.crud.UserCRUDService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    private static String FIRST_NAME = "Jenna";
    private static String LAST_NAME = "Jameson";
    private static String EMAIL_ADDRESS = "contactme@jennajameson.info";
    private static String EMAIL_ADDRESS_1 = "testme@jennajameson.info";
    private static String _UUID = UUID.randomUUID().toString();

    @Mock
    private UserCRUDService userCRUDService;

    private UserService userService;

    private UserDTO returnUserDTO;
    private User returnUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(UserMapper.INSTANCE, userCRUDService);
        returnUserDTO = UserDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();
        returnUser = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();
    }

    @Test
    void getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        users.add(new User());

        when(userCRUDService.findAll()).thenReturn(users);

        UserListDTO userListDTO = userService.getAllUsers();

        then(userCRUDService).should(times(1)).findAll();
        assertEquals(4, userListDTO.getUsers().size());
    }

    @Test
    void getUserByUuid() {
        returnUser.setUuid(_UUID);

        when(userCRUDService.findByUuid(_UUID)).thenReturn(Optional.of(returnUser));

        UserDTO userDTO = userService.getUserByUuid(_UUID);

        assertEquals(returnUser.getUuid(), userDTO.getUuid());
    }

    @Test
    void createNewUser() {
        when(userCRUDService.save(any())).thenReturn(returnUser);

        UserDTO userDTO = userService.createNewUser(returnUserDTO);

        assertEquals(EMAIL_ADDRESS, userDTO.getEmail());
    }

    @Test
    void updateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(EMAIL_ADDRESS_1);

        User user = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();
        user.setUuid(_UUID);

        given(userCRUDService.findByUuid(any())).willReturn(Optional.of(user));
        given(userCRUDService.save(any(User.class))).willReturn(user);

        UserDTO savedUserDTO = userService.updateUser(_UUID, userDTO);

        then(userCRUDService).should().save(any(User.class));
        then(userCRUDService).should(times(1)).findByUuid(any());
        assertEquals(savedUserDTO.getEmail(), EMAIL_ADDRESS_1);
    }

    @Test
    void deleteUserByUuid() {
        returnUser.setUuid(_UUID);
        given(userCRUDService.findByUuid(any())).willReturn(Optional.of(returnUser));
        userService.deleteUserByUuid(_UUID);

        then(userCRUDService).should().delete(any());
    }
}