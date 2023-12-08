package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    /**
     * Read in all the lines from a file. If there is a problem with a file return an empty list
     *
     * @param fileName full path to file to read
     * @return list of strings, 1 per line in the file
     */
    public static List<String> readLines(String fileName) {
        try {
            Path path = Paths.get(fileName);
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Caught exception reading input - - " + e);
        }
        return new ArrayList<>();
    }
}