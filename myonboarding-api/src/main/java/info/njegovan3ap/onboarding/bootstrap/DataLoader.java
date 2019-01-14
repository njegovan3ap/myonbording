package info.njegovan3ap.onboarding.bootstrap;

import info.njegovan3ap.onboarding.domain.Organization;
import info.njegovan3ap.onboarding.domain.Repo;
import info.njegovan3ap.onboarding.domain.User;
import info.njegovan3ap.onboarding.services.crud.OrganizationCRUDService;
import info.njegovan3ap.onboarding.services.crud.RepoCRUDService;
import info.njegovan3ap.onboarding.services.crud.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private static final String ORGANIZATION_NAME = "3AP-AG";
    private static final String REPOSITORY_TITLE = "MyOnboarding";
    private static final String FIRST_NAME = "Njegovan";
    private static final String LAST_NAME = "Obradovic";
    private static final String EMAIL_ADDRESS = "njegovan@3ap.ch";

    private final OrganizationCRUDService organizationCRUDService;
    private final UserCRUDService userCRUDService;
    private final RepoCRUDService repoCRUDService;

    @Autowired
    public DataLoader(OrganizationCRUDService organizationCRUDService, UserCRUDService userCRUDService, RepoCRUDService repoCRUDService) {
        this.organizationCRUDService = organizationCRUDService;
        this.userCRUDService = userCRUDService;
        this.repoCRUDService = repoCRUDService;
    }

    @Override
    public void run(String... args) {
        int count = organizationCRUDService.findAll().size();

        if (count == 0 ){
            initDummyData();
        }
    }

    void initDummyData() {
        Repo repo = Repo.builder().title(REPOSITORY_TITLE).build();
        User user = User.builder().firstName(FIRST_NAME).lastName(LAST_NAME).email(EMAIL_ADDRESS).build();
        Organization organization = Organization.builder().name(ORGANIZATION_NAME).build();

        repo.setOrganization(organization);

        Set<Repo> repos = new HashSet<>();
        repos.add(repo);
        user.setRepositories(repos);

        Set<User> users = new HashSet<>();
        users.add(user);

        organization.setRepositories(repos);
        organization.setUsers(users);

        organizationCRUDService.save(organization);

    }
}
