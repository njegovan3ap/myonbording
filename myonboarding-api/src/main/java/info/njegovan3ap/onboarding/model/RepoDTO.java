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
public class RepoDTO {
    private String uuid, title;
    @JsonIgnore
    private OrganizationDTO organization;
    @JsonIgnore
    private List<UserDTO> users;
}
