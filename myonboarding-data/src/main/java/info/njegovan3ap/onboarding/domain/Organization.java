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
@Table(name = "organizations")
public class Organization extends BaseEntity {
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "organization_users",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "organization")
    private Set<Repo> repositories;
}
