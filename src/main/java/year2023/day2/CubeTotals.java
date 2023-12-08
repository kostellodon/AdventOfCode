package year2023.day2;

public class CubeTotals {
    public int getNumberRed() {
        return numberRed;
    }

    public int getNumberGreen() {
        return numberGreen;
    }

    public int getNumberBlue() {
        return numberBlue;
    }

    private int numberRed = 0;
    private int numberGreen = 0;
    private int numberBlue = 0;

    public CubeTotals(int numberRed, int numberGreen, int numberBlue) {
        this.numberRed = numberRed;
        this.numberGreen = numberGreen;
        this.numberBlue = numberBlue;
    }

    /**
     * Create the object given a string of format X blue, Y green, Z red
     *
     * @param values String containing input values
     */
    public CubeTotals(String values) {
        String[] parts = values.split(", ");
        for (String part: parts) {
            String[] subparts = part.split(" ");
            if (subparts[1].contains("blue")) {
                this.numberBlue = Integer.parseInt(subparts[0]);
            } else if (subparts[1].contains("red")) {
                this.numberRed = Integer.parseInt(subparts[0]);
            } else if (subparts[1].contains("green")) {
                this.numberGreen = Integer.parseInt(subparts[0]);
            }
        }
    }
    public boolean canCover(CubeTotals otherCubeTotals) {
        return this.numberRed >= otherCubeTotals.getNumberRed() &&
            this.numberGreen >= otherCubeTotals.getNumberGreen() &&
            this.numberBlue >= otherCubeTotals.getNumberBlue();
    }

    /**
     * Update the totals to reflect the max of current vs other values
     *
     * @param otherCubeTotals other values to compare to
     */
    public void updateValuesToMax(CubeTotals otherCubeTotals) {
        if (otherCubeTotals.getNumberBlue() > this.getNumberBlue()) {
            this.numberBlue = otherCubeTotals.getNumberBlue();
        }
        if (otherCubeTotals.getNumberRed() > this.getNumberRed()) {
            this.numberRed = otherCubeTotals.getNumberRed();
        }
        if (otherCubeTotals.getNumberGreen() > this.getNumberGreen()) {
            this.numberGreen = otherCubeTotals.getNumberGreen();
        }
    }

    public int getPower() {
        return this.numberRed * this.numberGreen * this.numberBlue;
    }

    @Override
    public String toString() {
        return String.format("Red: %d, Green: %d, Blue: %d", this.numberRed, this.numberGreen, this.numberBlue);
    }
}