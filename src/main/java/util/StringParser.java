package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.StringIntegerPart;

public class StringParser {
    private static final Pattern integerPattern = Pattern.compile("\\d+");

    public static List<StringIntegerPart> getIntegerParts(String stringToSearch) {
        List<StringIntegerPart> parts = new ArrayList<>();
        Matcher matcher = integerPattern.matcher(stringToSearch);
        int startingIndex = 0;
        while (matcher.find()) {
            String integerAsString = matcher.group();
            int start = stringToSearch.indexOf(integerAsString, startingIndex);
            int end = start + integerAsString.length();
            parts.add(new StringIntegerPart(integerAsString, start, end));
            // If we have repeated values, we don't want the same starting index each time
            startingIndex = end + 1;
        }
        return parts;
    }
}