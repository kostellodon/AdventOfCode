package year2023.day2;

import java.util.List;
import util.ReadFile;

public class Cubes2 {
    public static void main(String[] args) {
        Cubes2 cubes = new Cubes2();
        System.out.println(cubes.getTotal("src/main/resources/Cubes.txt"));
    }

    public int getTotal(String filename) {
        List<String> inputLines = ReadFile.readLines(filename);
        int total = 0;
        for (String inputLine : inputLines) {
            String[] parts = inputLine.split(": ");
            String[] pulls = parts[1].split("; ");
            CubeTotals minNeeded = new CubeTotals(0, 0, 0);
            for (String pull : pulls) {
                CubeTotals pullTotal = new CubeTotals(pull);
                minNeeded.updateValuesToMax(pullTotal);
            }
            total += minNeeded.getPower();
        }
        return total;
    }
}