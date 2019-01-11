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
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName, lastName, email, address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_repositories",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "repo_id")
    )
    private Set<Repo> repositories = new HashSet<>();
}
