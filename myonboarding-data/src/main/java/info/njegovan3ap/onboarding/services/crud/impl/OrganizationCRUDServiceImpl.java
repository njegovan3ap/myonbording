package info.njegovan3ap.onboarding.services.crud.impl;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.repositories.OrganizationRepository;
import info.njegovan3ap.onboarding.services.crud.OrganizationCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationCRUDServiceImpl implements OrganizationCRUDService {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationCRUDServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization findById(Long aLong) {
        return organizationRepository.findById(aLong).orElse(null);
    }

    @Override
    public Optional<Organization> findByUuid(String uuid) {
        return organizationRepository.findByUuid(uuid);
    }

    @Override
    public Organization save(Organization object) {
        return organizationRepository.save(object);
    }

    @Override
    public void delete(Organization object) {
        organizationRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        organizationRepository.deleteById(aLong);
    }
}
