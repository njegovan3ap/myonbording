package info.njegovan3ap.onboarding.services.crud;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    Optional<T> findByUuid(String uuid);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
