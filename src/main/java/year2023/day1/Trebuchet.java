package year2023.day1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The newly-improved calibration document consists of lines of text; each line originally contained a specific
 * calibration value that the Elves now need to recover. On each line, the calibration value can be found by
 * combining the first digit and the last digit (in that order) to form a single two-digit number.
 * <p>
 * For example:
 * <p>
 * 1abc2
 * pqr3stu8vwx
 * a1b2c3d4e5f
 * treb7uchet
 * In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces
 * 142.
 * <p>
 * Consider your entire calibration document. What is the sum of all of the calibration values?
 */
public class Trebuchet {
    public static void main(String[] args) {
        try {
            // Shouldn't need the full path, not sure why
            Path path = Paths.get("src/main/resources/Trebuchet.txt");
            Scanner scanner = new Scanner(path);
            int total = 0;
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                String number = "";
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        number += line.charAt(i);
                        break;
                    }
                }
                for (int i = line.length() - 1; i >= 0; i--) {
                    if (Character.isDigit(line.charAt(i))) {
                        number += line.charAt(i);
                        break;
                    }
                }
                total += Integer.parseInt(number);
                System.out.println(line + " - " + number);
            }
            scanner.close();
            System.out.println("Total - " + total);
        } catch (IOException e) {
            System.out.println("Caught exception - " + e);
        }
    }
}