package info.njegovan3ap.onboarding.collections;

import java.util.Collection;

/**
 * Write a program that prints its arguments in random order.
 * Do not make a copy of the argument array.
 * Demonstrate how to print out the elements using both streams and the traditional enhanced for statement.
 */
class PrintArguments {
    private final Collection collection;

    PrintArguments(Collection collection) {
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
