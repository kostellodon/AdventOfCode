package year2023.day2;

import java.util.List;
import util.ReadFile;

public class Cubes {
    public static void main(String[] args) {
        Cubes cubes = new Cubes();
        System.out.println(cubes.getTotal("src/main/resources/Cubes.txt"));
    }

    public int getTotal(String filename) {
        CubeTotals maximumCubes = new CubeTotals(12, 13, 14);
        List<String> inputLines = ReadFile.readLines(filename);
        int total = 0;
        for (String inputLine : inputLines) {
            String[] parts = inputLine.split(": ");
            String[] gameNumbers = parts[0].split(" ");
            int gameNumber = Integer.parseInt(gameNumbers[1]);
            String[] pulls = parts[1].split("; ");
            boolean canFit = true;
            for (String pull : pulls) {
                CubeTotals pullTotal = new CubeTotals(pull);
                canFit &= maximumCubes.canCover(pullTotal);
            }
            if (canFit) {
                total += gameNumber;
            }
        }
        return total;
    }
}