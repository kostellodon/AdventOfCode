package model;

public class StringIntegerPart {
    private final String valueAsString;
    private final int startIndex;
    private final int endIndex;

    public StringIntegerPart(String valueAsString, int startIndex, int endIndex) {
        this.valueAsString = valueAsString;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public String getValueAsString() {
        return valueAsString;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getValue() {
        return Integer.parseInt(valueAsString);
    }

    @Override
    public String toString() {
        return "Value: " + valueAsString +  " Start: " + startIndex + " End: " + endIndex;
    }
}