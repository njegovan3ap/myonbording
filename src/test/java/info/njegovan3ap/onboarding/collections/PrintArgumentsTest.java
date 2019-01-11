package info.njegovan3ap.onboarding.collections;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PrintArgumentsTest {
    private  PrintArguments printArguments;

    @BeforeEach
    void setUp() {
        List<String> collection = new ArrayList<>();
        collection.add("Foo");
        collection.add("Bar");
        printArguments = new PrintArguments(collection);

    }

    @Test
    void printing() {
        printArguments.printing();
    }

    @Test
    void printingWithStream() {
        printArguments.printingWithStream();
    }
}