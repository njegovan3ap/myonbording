package info.njegovan3ap.onboarding;

import info.njegovan3ap.onboarding.services.crud.OrganizationCRUDService;
import info.njegovan3ap.onboarding.services.crud.RepoCRUDService;
import info.njegovan3ap.onboarding.services.crud.UserCRUDService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OnboardingApplicationTest {
    @Autowired
    private RepoCRUDService repoCRUDService;
    @Autowired
    private UserCRUDService userCRUDService;
    @Autowired
    private OrganizationCRUDService organizationCRUDService;

    @Test
    public void contextLoads() {
        System.out.println("Started with Spring application...");
        System.out.println("Branch sync...");
    }

}

