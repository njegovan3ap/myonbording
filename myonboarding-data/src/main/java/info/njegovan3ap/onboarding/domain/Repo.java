package info.njegovan3ap.onboarding.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "repositories")
public class Repo extends BaseEntity {
    private String title;
}
