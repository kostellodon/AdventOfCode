package year2023.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.StringIntegerPart;
import util.ReadFile;
import util.StringParser;

public class Parts {
    private static final Pattern symbolPattern = Pattern.compile("[^a-zA-Z0-9.]");

    public static void main(String[] args) {
        Parts parts = new Parts();
        System.out.println(parts.getTotal("src/main/resources/Parts.txt"));
    }

    public int getTotal(String filename) {
        List<String> inputLines = ReadFile.readLines(filename);
        int total = 0;
        for (int i = 0; i < inputLines.size(); i++) {
            String inputLine = inputLines.get(i);
            System.out.println("Testing " + inputLine);
            List<StringIntegerPart> integerParts = StringParser.getIntegerParts(inputLine);
            for (StringIntegerPart integerPart : integerParts) {
                System.out.println("  Found Integer " + integerPart);
                boolean boundingBoxHasSymbol = evaluateBoundingBox(i, inputLines, integerPart);
                if (boundingBoxHasSymbol) {
                    total += integerPart.getValue();
                    System.out.println("        Adding " + integerPart.getValueAsString() + " for New total: " + total);
                }
            }
        }
        return total;
    }

    private boolean evaluateBoundingBox(int stringIndex, List<String> allStrings, StringIntegerPart integerPart) {
        boolean hasSymbol = evaluateLine(stringIndex - 1, allStrings, integerPart.getStartIndex() - 1,
            integerPart.getEndIndex() + 1) ||
            evaluateLine(stringIndex, allStrings, integerPart.getStartIndex() - 1,
                integerPart.getEndIndex() + 1) ||
            evaluateLine(stringIndex + 1, allStrings, integerPart.getStartIndex() - 1,
                integerPart.getEndIndex() + 1);
        return hasSymbol;
    }

    private boolean evaluateLine(int lineIndex, List<String> allLines, int startIndex, int endIndex) {
        if (lineIndex < 0 || lineIndex >= allLines.size()) {
            return false;
        }
        String line = allLines.get(lineIndex);
        int start = Math.max(startIndex, 0);
        int end = Math.min(endIndex, line.length());
        System.out.println("    Checking against " + line + " start " + start + " end " + end);
        Matcher matcher = symbolPattern.matcher(line.substring(start, end));
        boolean found = matcher.find();
        System.out.println("      Returning " + found + " for string " + line.substring(start, end));
        return found;
    }
}