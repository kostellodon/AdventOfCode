package year2023.day1;

import java.util.List;
import util.ReadFile;

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
public class TrebuchetImproved {
    public static void main(String[] args) {
        TrebuchetImproved trebuchetImproved = new TrebuchetImproved();
        System.out.println(trebuchetImproved.getTotal("src/main/resources/Trebuchet.txt"));
    }

    public int getTotal(String fileName) {
        int total = 0;
        List<String> inputLines = ReadFile.readLines(fileName);
        for (String input : inputLines) {
            String numbersOnly = getNumerics(input);
            String firstAndLast = "" + numbersOnly.charAt(0) + numbersOnly.charAt(numbersOnly.length() - 1);
            total += Integer.parseInt(firstAndLast);
        }
        return total;
    }

    /**
     * Given an input string, get all the integers (chars 0-9)
     *
     * @param input - String to analyze
     * @return String with only numbers
     */
    public String getNumerics(String input) {
        return input.replaceAll("\\D+", "");
    }
}