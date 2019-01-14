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
public class RepoDTO {
    private String uuid, title;
    private OrganizationDTO organization;
    private List<UserDTO> users;
}
