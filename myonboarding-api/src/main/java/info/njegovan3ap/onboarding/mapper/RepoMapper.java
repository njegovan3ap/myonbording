package info.njegovan3ap.onboarding.mapper;

import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.model.RepoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class)
public interface RepoMapper {
    RepoMapper INSTANCE = Mappers.getMapper(RepoMapper.class);

    RepoDTO repoToRepoDTO(Repo repo);
    Repo repoDTOToRepo(RepoDTO repoDTO);
}
