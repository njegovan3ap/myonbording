package info.njegovan3ap.onboarding.services.crud.impl;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.repositories.OrganizationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrganizationCRUDServiceImplTest {
    private static final String ORGANIZATION_NAME = "3AP-AG";

    @Mock
    OrganizationRepository organizationRepository;

    @InjectMocks
    OrganizationCRUDServiceImpl organizationService;

    Organization returnOrg;

    @BeforeEach
    void setUp() {
        returnOrg = Organization.builder().name(ORGANIZATION_NAME).build();
    }

    @Test
    void findAll() {
        List<Organization> organizationSet = new ArrayList<>();
        organizationSet.add(Organization.builder().name("first").build());
        organizationSet.add(Organization.builder().name("second").build());

        when(organizationRepository.findAll()).thenReturn(organizationSet);

        List<Organization> organizations = organizationService.findAll();

        assertNotNull(organizations);
        assertEquals(2, organizations.size());
    }

    @Test
    void findById() {
        when(organizationRepository.findById(anyLong())).thenReturn(Optional.of(returnOrg));

        Organization organization = organizationService.findById(1L);

        assertNotNull(organization);
    }

    @Test
    void save() {
        when(organizationRepository.save(any())).thenReturn(returnOrg);

        Organization savedOwner = organizationService.save(new Organization());

        assertNotNull(savedOwner);
        verify(organizationRepository).save(any());
    }

    @Test
    void delete() {
        organizationService.delete(returnOrg);

        verify(organizationRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        organizationService.deleteById(1L);

        verify(organizationRepository).deleteById(anyLong());
    }
}