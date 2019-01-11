package info.njegovan3ap.onboarding.collections;

import org.springframework.core.io.Resource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Write a program that reads a text file, specified by the first command line argument, into a List.
 * The program should then print random lines from the file, the number of lines printed to be
 * specified by the second command line argument.
 * Write the program so that a correctly-sized collection is allocated all at once, instead of being gradually expanded
 * as the file is read in.
 * <p>
 * Hint: To determine the number of lines in the file, use java.io.File.length to obtain
 * the size of the file, then divide by an assumed size of an average line.
 */
class FileToList {
    static boolean execute(Resource resource, int repeats) {
        try {
            List<String> fileList = Files
                    .readAllLines(Paths.get(resource.getFile().getPath()))
                    .stream()
                    .filter(l -> !l.isBlank())
                    .collect(Collectors.toList());
            int count = fileList.size();

            Random random = new Random();
            for (int i = 0; i < repeats; i++) {
                System.out.format("%d: %s%n", i, fileList.get(random.nextInt(count - 1)));
            }

            return true;
        }
        catch (Exception e) {
            System.err.format("Could not read %s: %s%n", resource.getFilename(), e);
            System.exit(1);
        }
        return false;
    }
}
