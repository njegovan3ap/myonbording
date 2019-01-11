package info.njegovan3ap.onboarding;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OnboardingApplicationTest {

    @Test
    public void contextLoads() {
        System.out.println("Started with Spring application...");
        System.out.println("Branch sync...");
    }

}

