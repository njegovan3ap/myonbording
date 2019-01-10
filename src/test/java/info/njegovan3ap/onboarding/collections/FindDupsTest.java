package info.njegovan3ap.onboarding.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDupsTest {
    private final String[] arr = {"asdfok", "erowe", "qoiqwAjosdosm", "wqowjqwdn", "asdasd"};
    private final FindDups findDups = new FindDups();

    @Test
    void testFive() {
        assertEquals(5, findDups.findDubs(arr));
    }
    @Test
    void testFour() {
        arr[2] = "Erowe";
        assertEquals(4, findDups.findDubs(arr));
    }
}