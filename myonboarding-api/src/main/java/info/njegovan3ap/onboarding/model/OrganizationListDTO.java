package info.njegovan3ap.onboarding.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrganizationListDTO {
    private List<OrganizationDTO> organizations;
}
