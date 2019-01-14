package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.model.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {
    private static String FIRST_NAME = "Jenna";
    private static String LAST_NAME = "Jameson";
    private static String EMAIL_ADDRESS = "contactme@jennajameson.info";

    private UserMapper userMapper = UserMapper.INSTANCE;

    @Test
    void userToUserDTO() {
        User user = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();

        UserDTO userDTO = userMapper.userToUserDTO(user);

        assertEquals(FIRST_NAME, userDTO.getFirstName());
        assertEquals(LAST_NAME, userDTO.getLastName());
        assertEquals(EMAIL_ADDRESS, userDTO.getEmail());
    }

    @Test
    void userDTOToUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(FIRST_NAME);
        userDTO.setLastName(LAST_NAME);
        userDTO.setEmail(EMAIL_ADDRESS);

        User user = userMapper.userDTOToUser(userDTO);

        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(EMAIL_ADDRESS, user.getEmail());
    }
}