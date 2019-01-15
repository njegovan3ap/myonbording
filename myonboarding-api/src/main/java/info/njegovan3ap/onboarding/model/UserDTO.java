package info.njegovan3ap.onboarding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String uuid, firstName, lastName, email;
    private List<RepoDTO> repositories;
    private List<OrganizationDTO> organizations;
}
