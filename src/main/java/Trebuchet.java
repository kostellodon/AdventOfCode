import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
                for (int i = line.length() -1; i >= 0; i--) {
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