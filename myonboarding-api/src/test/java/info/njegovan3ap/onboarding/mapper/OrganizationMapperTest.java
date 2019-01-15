package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.model.OrganizationDTO;
import info.njegovan3ap.onboarding.model.RepoDTO;
import info.njegovan3ap.onboarding.model.UserDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrganizationMapperTest {
    private static final String NAME = "3AP-AG";

    private OrganizationMapper organizationMapper = OrganizationMapper.INSTANCE;

    @Test
    void organizationToOrganizationDTO() {
        Set<User> users = new HashSet<>();
        users.add(User.builder().build());
        users.add(User.builder().build());
        users.add(User.builder().build());

        Set<Repo> repos = new HashSet<>();
        repos.add(Repo.builder().build());
        repos.add(Repo.builder().build());
        repos.add(Repo.builder().build());

        Organization organization = Organization.builder().name(NAME).users(users).repositories(repos).build();

        OrganizationDTO organizationDTO = organizationMapper.organizationToOrganizationDTO(organization);

        assertEquals(NAME, organizationDTO.getName());
        assertEquals(3, organizationDTO.getRepositories().size());
        assertEquals(3, organizationDTO.getUsers().size());
    }

    @Test
    void organizationDTOToOrganization() {
        List<UserDTO> users = new ArrayList<>();
        users.add(UserDTO.builder().uuid("First").firstName("First").build());
        users.add(UserDTO.builder().uuid("Second").firstName("Second").build());
        users.add(UserDTO.builder().uuid("Third").firstName("Third").build());

        List<RepoDTO> repos = new ArrayList<>();
        repos.add(RepoDTO.builder().uuid("First").title("First").build());
        repos.add(RepoDTO.builder().uuid("Second").title("Second").build());
        repos.add(RepoDTO.builder().uuid("Third").title("Third").build());

        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setName(NAME);
        organizationDTO.setRepositories(repos);
        organizationDTO.setUsers(users);


        Organization organization = organizationMapper.organizationDTOToOrganization(organizationDTO);

        assertEquals(NAME, organization.getName());
        assertEquals(3, organization.getRepositories().size());
        assertEquals(3, organization.getUsers().size());
    }
}