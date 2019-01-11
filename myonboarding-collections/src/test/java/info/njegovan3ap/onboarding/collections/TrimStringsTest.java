package info.njegovan3ap.onboarding.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrimStringsTest {
    private final TrimStrings trimStrings = new TrimStrings();

    @Test
    void trimStrings() {
        List<String> original = new ArrayList<>();
        original.add(" a sdsd ");
        original.add(" b sdsd ");
        original.add(" c sdsd ");
        original.add(" d sdsd ");
        original.add(" e sdsd ");

        assertEquals(0, trimStrings.trimStrings(original).stream().filter(e -> e.startsWith(" ") || e.endsWith(" ")).collect(Collectors.toList()).size());
    }
}