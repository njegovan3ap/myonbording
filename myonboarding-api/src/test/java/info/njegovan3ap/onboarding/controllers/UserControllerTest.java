package info.njegovan3ap.onboarding.controllers;

import info.njegovan3ap.onboarding.model.UserDTO;
import info.njegovan3ap.onboarding.model.UserListDTO;
import info.njegovan3ap.onboarding.services.UserService;
import info.njegovan3ap.onboarding.services.crud.UserCRUDService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {UserController.class})
class UserControllerTest {
    @MockBean
    UserService userService;

    @MockBean
    UserCRUDService userCRUDService;

    @Autowired
    MockMvc mockMvc;

    UserDTO u1;
    UserDTO u2;

    @BeforeEach
    void setUp() {
        u1 = UserDTO.builder().firstName("firstname1").lastName("lastname1").email("email1").build();
        u2 = UserDTO.builder().firstName("firstname2").lastName("lastname2").email("email2").build();
    }

    @Test
    void getListOfUsers() throws Exception {
        UserListDTO userListDTO = new UserListDTO(asList(u1, u2));

        when(userService.getAllUsers()).thenReturn(userListDTO);

        mockMvc.perform(get(UserController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users", hasSize(2)));
    }

    @Test
    public void getUserByUuid() throws Exception {
        u1.setUuid("some-uuid");

        when(userService.getUserByUuid(anyString())).thenReturn(u1);

        mockMvc.perform(get(UserController.BASE_URL + "/some-uuid")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(u1.getFirstName())));
    }
}