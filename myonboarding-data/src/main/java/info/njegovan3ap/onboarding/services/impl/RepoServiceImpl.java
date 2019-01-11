package info.njegovan3ap.onboarding.services.impl;

import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.repositories.RepoRepository;
import info.njegovan3ap.onboarding.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RepoServiceImpl implements RepoService {
    private final RepoRepository repoRepository;

    @Autowired
    public RepoServiceImpl(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    @Override
    public Set<Repo> findAll() {
        Set<Repo> repos = new HashSet<>();
        repoRepository.findAll().forEach(repos::add);
        return repos;
    }

    @Override
    public Repo findById(Long aLong) {
        return repoRepository.findById(aLong).orElse(null);
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
