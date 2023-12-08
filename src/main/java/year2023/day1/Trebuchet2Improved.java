package year2023.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.ReadFile;

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
public class Trebuchet2Improved {
    private static final Map<String, String> numberWords = new HashMap<>();
    static {
        numberWords.put("one", "1");
        numberWords.put("1", "1");
        numberWords.put("two", "2");
        numberWords.put("2", "2");
        numberWords.put("three", "3");
        numberWords.put("3", "3");
        numberWords.put("four", "4");
        numberWords.put("4", "4");
        numberWords.put("five", "5");
        numberWords.put("5", "5");
        numberWords.put("six", "6");
        numberWords.put("6", "6");
        numberWords.put("seven", "7");
        numberWords.put("7", "7");
        numberWords.put("eight", "8");
        numberWords.put("8", "8");
        numberWords.put("nine", "9");
        numberWords.put("9", "9");
    }

    public static void main(String[] args) {
        Trebuchet2Improved trebuchet2Improved = new Trebuchet2Improved();
        System.out.println(trebuchet2Improved.getTotal("src/main/resources/Trebuchet.txt"));
    }

    public int getTotal(String fileName) {
        int total = 0;
        List<String> inputLines = ReadFile.readLines(fileName);
        for (String input : inputLines) {
            String firstAndLast = getFirstNumber(input, Trebuchet2Improved.numberWords)
                + getLastNumber(input, Trebuchet2Improved.numberWords);
            total += Integer.parseInt(firstAndLast);
        }
        return total;
    }

    public String getFirstNumber(String input, Map<String, String> keyMap) {
        int firstIndex = Integer.MAX_VALUE;
        String returnValue = "";
        for (Map.Entry<String, String> mapEntry: keyMap.entrySet()) {
            int index = input.indexOf(mapEntry.getKey());
            if (index >= 0 && index < firstIndex) {
                firstIndex = index;
                returnValue = mapEntry.getValue();
            }
        }
        return returnValue;
    }

    // We could also just use the getFirstNumber with reversed strings, but this is more understandable
    public String getLastNumber(String input, Map<String, String> keyMap) {
        int lastIndex = -1;
        String returnValue = "";
        // Could probably do this some clever way with streams, but let's just do it straightforward
        for (Map.Entry<String, String> mapEntry: keyMap.entrySet()) {
            int index = input.lastIndexOf(mapEntry.getKey());
            if (index > lastIndex) {
                lastIndex = index;
                returnValue = mapEntry.getValue();
            }
        }
        return returnValue;
    }
}