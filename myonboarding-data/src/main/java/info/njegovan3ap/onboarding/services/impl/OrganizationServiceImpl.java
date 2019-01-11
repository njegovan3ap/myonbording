package info.njegovan3ap.onboarding.services.impl;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.repositories.OrganizationRepository;
import info.njegovan3ap.onboarding.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Set<Organization> findAll() {
        Set<Organization> organizations = new HashSet<>();
        organizationRepository.findAll().forEach(organizations::add);
        return organizations;
    }

    @Override
    public Organization findById(Long aLong) {
        return organizationRepository.findById(aLong).orElse(null);
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
