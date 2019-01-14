package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
