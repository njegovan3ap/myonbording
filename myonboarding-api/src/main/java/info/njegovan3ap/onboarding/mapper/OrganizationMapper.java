package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.model.OrganizationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface OrganizationMapper {
    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDTO organizationToOrganizationDTO(Organization organization);
    Organization organizationDTOToOrganization(OrganizationDTO organizationDTO);
}
