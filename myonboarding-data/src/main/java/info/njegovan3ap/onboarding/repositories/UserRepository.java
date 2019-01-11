package info.njegovan3ap.onboarding.repositories;

import info.njegovan3ap.onboarding.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
