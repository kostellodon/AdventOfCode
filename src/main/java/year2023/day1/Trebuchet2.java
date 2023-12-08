package year2023.day1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one,
 * two, three, four, five, six, seven, eight, and nine also count as valid "digits".
 * <p>
 * Equipped with this new information, you now need to find the real first and last digit on each line. For example:
 * <p>
 * two1nine
 * eightwothree
 * abcone2threexyz
 * xtwone3four
 * 4nineeightseven2
 * zoneight234
 * 7pqrstsixteen
 * In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
 * <p>
 * What is the sum of all of the calibration values?
 */
public class Trebuchet2 {
    public static void main(String[] args) {
        Map<String, String> numberWords = new HashMap<>();
        numberWords.put("one", "1");
        numberWords.put("two", "2");
        numberWords.put("three", "3");
        numberWords.put("four", "4");
        numberWords.put("five", "5");
        numberWords.put("six", "6");
        numberWords.put("seven", "7");
        numberWords.put("eight", "8");
        numberWords.put("nine", "9");
        try {
            // Shouldn't need the full path, not sure why
            Path path = Paths.get("src/main/resources/Trebuchet.txt");
            Scanner scanner = new Scanner(path);
            int total = 0;
            while (scanner.hasNextLine()) {
                //process each line
                String line = scanner.nextLine();
                String number = "";
                int numberIndex = -1;
                String numberToAdd = "";
                // Find the first digit
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        numberIndex = i;
                        numberToAdd = "" + line.charAt(i);
                        break;
                    }
                }
                // Find the first word that's a digit - use it if it's before a digit
                for (String numberString : numberWords.keySet()) {
                    int i = line.indexOf(numberString);
                    if (i >= 0 && i < numberIndex) {
                        numberIndex = i;
                        numberToAdd = numberWords.get(numberString);
                    }
                }
                number += numberToAdd;

                // Find the last digit
                for (int i = line.length() - 1; i >= 0; i--) {
                    if (Character.isDigit(line.charAt(i))) {
                        numberIndex = i;
                        numberToAdd = "" + line.charAt(i);
                        break;
                    }
                }
                // Find the first word that's a digit - use it if it's after a digit
                for (String numberString : numberWords.keySet()) {
                    int i = line.lastIndexOf(numberString);
                    if (i >= 0 && i > numberIndex) {
                        numberIndex = i;
                        numberToAdd = numberWords.get(numberString);
                    }
                }
                number += numberToAdd;
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