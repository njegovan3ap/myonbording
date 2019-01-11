package info.njegovan3ap.onboarding.services.impl;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.repositories.OrganizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceImplTest {
    public static final String ORGANIZATION_NAME = "3AP-AG";

    @Mock
    OrganizationRepository organizationRepository;

    @InjectMocks
    OrganizationServiceImpl organizationService;

    Organization returnOrg;

    @BeforeEach
    void setUp() {
        returnOrg = Organization.builder().name(ORGANIZATION_NAME).build();
    }

    @Test
    void findAll() {
        Set<Organization> organizationSet = new HashSet<>();
        organizationSet.add(Organization.builder().name("first").build());
        organizationSet.add(Organization.builder().name("second").build());

        when(organizationRepository.findAll()).thenReturn(organizationSet);

        Set<Organization> organizations = organizationService.findAll();

        assertNotNull(organizations);
        assertEquals(2, organizations.size());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}