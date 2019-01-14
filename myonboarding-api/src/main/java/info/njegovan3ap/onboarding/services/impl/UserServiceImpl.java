package info.njegovan3ap.onboarding.services.impl;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.mapper.UserMapper;
import info.njegovan3ap.onboarding.model.UserDTO;
import info.njegovan3ap.onboarding.model.UserListDTO;
import info.njegovan3ap.onboarding.services.UserService;
import info.njegovan3ap.onboarding.services.crud.UserCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserCRUDService userCRUDService;

    public UserServiceImpl(UserMapper userMapper, UserCRUDService userCRUDService) {
        this.userMapper = userMapper;
        this.userCRUDService = userCRUDService;
    }

    @Override
    public UserListDTO getAllUsers() {
        List<UserDTO> userDTOS = userCRUDService
                .findAll()
                .stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
        return new UserListDTO(userDTOS);
    }

    @Override
    public UserDTO getUserByUuid(String uuid) {
        return userMapper.userToUserDTO(userCRUDService.findByUuid(uuid).get());
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return userMapper.userToUserDTO(userCRUDService.save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    public UserDTO updateUser(String uuid, UserDTO userDTO) {
        return userCRUDService.findByUuid(uuid).map(u -> {
            if(userDTO.getFirstName() != null){
                u.setFirstName(userDTO.getFirstName());
            }

            if(userDTO.getLastName() != null){
                u.setLastName(userDTO.getLastName());
            }

            if(userDTO.getEmail() != null){
                u.setEmail(userDTO.getEmail());
            }

            return saveAndReturnDTO(u);
        }).orElse(null);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
        Optional<User> user = userCRUDService.findByUuid(uuid);
        userCRUDService.delete(user.get());
    }

    UserDTO saveAndReturnDTO(User user) {
        return userMapper.userToUserDTO(userCRUDService.save(user));
    }
}
