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
public class OrganizationDTO {
    private String uuid, name;
    @JsonIgnore
    private List<UserDTO> users;
    @JsonIgnore
    private List<RepoDTO> repositories;
}
