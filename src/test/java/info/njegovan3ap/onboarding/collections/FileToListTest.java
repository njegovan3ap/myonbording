package info.njegovan3ap.onboarding.collections;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FileToListTest {

    @Test
    void execute() {
        assertTrue(FileToList.execute(new ClassPathResource("collections-test-file.txt"), 3));
    }
}