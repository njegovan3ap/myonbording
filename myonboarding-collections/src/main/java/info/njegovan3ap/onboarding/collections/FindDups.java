package info.njegovan3ap.onboarding.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Take the FindDups example and modify it to use a SortedSet instead of a Set.
 * Specify a Comparator so that case is ignored when sorting and identifying set elements.
 */
class FindDups {
    int findDubs(String[] arr) {
        Set<String> s = new TreeSet<>(String::compareToIgnoreCase);
        s.addAll(Arrays.asList(arr));
        System.out.println(s.size() + " distinct words: " + s);
        return s.size();
    }
}
