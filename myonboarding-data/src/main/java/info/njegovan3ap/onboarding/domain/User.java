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
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName, lastName, email;

    @ManyToMany
    @JoinTable(
            name = "user_repositories",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "repo_id")
    )
    private Set<Repo> repositories;

    @ManyToMany(mappedBy = "users")
    private Set<Organization>  organizations;
}
