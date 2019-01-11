package info.njegovan3ap.onboarding.collections;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a method that takes a List<String> and applies String.trim to each element.
 */
class TrimStrings {
    List<String> trimStrings(List<String> list) {
        return list.stream().map(String::trim).collect(Collectors.toList());
    }
}
