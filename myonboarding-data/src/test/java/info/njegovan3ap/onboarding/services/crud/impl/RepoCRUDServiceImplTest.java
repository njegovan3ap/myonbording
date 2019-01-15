package info.njegovan3ap.onboarding.services.crud.impl;

import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.repositories.RepoRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepoCRUDServiceImplTest {
    private static final String REPOSITORY_TITLE = "MyOnboarding";

    @Mock
    private RepoRepository repoRepository;

    @InjectMocks
    private RepoCRUDServiceImpl repoService;

    private Repo returnRepo;

    @BeforeEach
    void setUp() {
        returnRepo = Repo.builder().title(REPOSITORY_TITLE).build();
    }

    @Test
    void findAll() {
        List<Repo> repoSet = new ArrayList<>();
        repoSet.add(Repo.builder().build());
        repoSet.add(Repo.builder().build());

        when(repoRepository.findAll()).thenReturn(repoSet);

        List<Repo> repos = repoService.findAll();

        assertNotNull(repos);
        assertEquals(2, repos.size());
    }

    @Test
    void findById() {
        when(repoRepository.findById(anyLong())).thenReturn(Optional.of(returnRepo));

        Repo repo = repoService.findById(1L);

        assertNotNull(repo);
    }

    @Test
    void save() {
        when(repoRepository.save(any())).thenReturn(returnRepo);

        Repo savedRepo = repoService.save(new Repo());

        assertNotNull(savedRepo);
        verify(repoRepository).save(any());
    }

    @Test
    void delete() {
        repoService.delete(returnRepo);

        verify(repoRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        repoService.deleteById(1L);

        verify(repoRepository).deleteById(anyLong());
    }
}