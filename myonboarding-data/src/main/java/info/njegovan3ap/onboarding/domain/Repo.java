package info.njegovan3ap.onboarding.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "repositories")
public class Repo extends BaseEntity {
    private String title;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @ManyToMany(mappedBy = "repositories")
    private Set<User> users;
}
