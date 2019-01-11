package info.njegovan3ap.onboarding.repositories;

import info.njegovan3ap.onboarding.domain.Repo;
import org.springframework.data.repository.CrudRepository;

public interface RepoRepository extends CrudRepository<Repo, Long> {
}
