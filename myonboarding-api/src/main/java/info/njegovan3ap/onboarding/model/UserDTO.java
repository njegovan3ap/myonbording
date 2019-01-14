package info.njegovan3ap.onboarding.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<RepoDTO> repositories;
    @JsonIgnore
    private List<OrganizationDTO> organizations;
}
