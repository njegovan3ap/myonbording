package info.njegovan3ap.onboarding.collections;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PrintArguments {
    private final Collection collection;

    public PrintArguments(Collection collection) {
        this.collection = collection;
    }

    void printing() {
        for (Object o: collection) {
            System.out.println(o.toString());
        }
    }

    void printingWithStream() {
        collection.stream().forEach(e -> System.out.println(e.toString()));
    }
}
