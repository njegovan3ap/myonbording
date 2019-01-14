package info.njegovan3ap.onboarding.services;

import info.njegovan3ap.onboarding.model.UserDTO;
import info.njegovan3ap.onboarding.model.UserListDTO;

public interface UserService {
    UserListDTO getAllUsers();
    UserDTO getUserByUuid(String uuid);
    UserDTO createNewUser(UserDTO userDTO);
    UserDTO updateUser(String uuid, UserDTO userDTO);
    void deleteUserByUuid(String uuid);
}
