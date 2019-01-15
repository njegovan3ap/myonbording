package info.njegovan3ap.onboarding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
    Optional<T> findByUuid(String uuid);
}
