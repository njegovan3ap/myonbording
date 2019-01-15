package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.model.UserDTO;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @InheritInverseConfiguration
    UserDTO userToUserDTO(User user, @Context CycleAvoidingMappingContext context);
    User userDTOToUser(UserDTO userDTO, @Context CycleAvoidingMappingContext context);
}
