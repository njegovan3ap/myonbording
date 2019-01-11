package info.njegovan3ap.onboarding.bootstrap;

import info.njegovan3ap.onboarding.services.OrganizationService;
import info.njegovan3ap.onboarding.services.RepoService;
import info.njegovan3ap.onboarding.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserService userService;
    private final RepoService repoService;
    private final OrganizationService organizationService;

    @Autowired
    public DataLoader(UserService userService, RepoService repoService, OrganizationService organizationService) {
        this.userService = userService;
        this.repoService = repoService;
        this.organizationService = organizationService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
