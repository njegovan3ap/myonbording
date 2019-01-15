package info.njegovan3ap.onboarding.services.crud.impl;

import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.repositories.RepoRepository;
import info.njegovan3ap.onboarding.services.crud.RepoCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepoCRUDServiceImpl implements RepoCRUDService {
    private final RepoRepository repoRepository;

    @Autowired
    public RepoCRUDServiceImpl(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public List<Repo> findAll() {
        return repoRepository.findAll();
    }

    @Override
    public Repo findById(Long aLong) {
        return repoRepository.findById(aLong).orElse(null);
    }

    @Override
    public Optional<Repo> findByUuid(String uuid) {
        return repoRepository.findByUuid(uuid);
    }

    @Override
    public Repo save(Repo object) {
        return repoRepository.save(object);
    }

    @Override
    public void delete(Repo object) {
        repoRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repoRepository.deleteById(aLong);
    }
}
