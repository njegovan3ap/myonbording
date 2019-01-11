package info.njegovan3ap.onboarding.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organizations")
public class Organization extends BaseEntity {
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "organization_users",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "organization_repositories",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "repo_id")
    )
    private Set<Repo> repositories = new HashSet<>();
}
