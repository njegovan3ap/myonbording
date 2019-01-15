package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.model.RepoDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepoMapperTest {
    private static String TITLE = "MyOnboarding";

    private RepoMapper repoMapper = RepoMapper.INSTANCE;

    @Test
    void repoToRepoDTO() {
        Repo repo = Repo.builder().title(TITLE).build();
        RepoDTO repoDTO = repoMapper.repoToRepoDTO(repo);

        assertEquals(TITLE, repoDTO.getTitle());
    }

    @Test
    void repoDTOToRepo() {
        RepoDTO repoDTO = new RepoDTO();
        repoDTO.setTitle(TITLE);

        Repo repo = repoMapper.repoDTOToRepo(repoDTO);

        assertEquals(TITLE, repo.getTitle());
    }
}