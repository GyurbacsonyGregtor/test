import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int[] askTheNumbers() {

        Scanner scanner = new Scanner(System.in);
        int arrayLength = 0;


        do {
            try {
                System.out.println("Adja meg, hány számot akar vizsgálni");
                String arrayLengthString = scanner.nextLine();
                arrayLength = Integer.parseInt(arrayLengthString.replaceAll("\\n", ""));
            } catch (NumberFormatException e) {
                System.out.println("Nem megfelelő adattípus! Kérem, pozitív, egész számokat tápláljon be a komputerbe!");
                scanner.next();
            }
        } while (arrayLength % arrayLength != 0);

        System.out.println("Kérem adja meg a számokat!");
        String nextNumberString = null;
        for (int counter = 0; counter < arrayLength; counter++) {
            nextNumberString += scanner.next().replaceAll("\\n", "") + ",";
        }


        String[] numbers = nextNumberString.split(",");
        int[] numberArray = new int[arrayLength];

        try {
            for (int number = 0; number < arrayLength; number++) {
                numberArray[number] = Integer.parseInt(numbers[number]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Nem megfelelő adattípus! Kérem, indítsa újra a programot, és " +
                                  "pozitív, egész számokat tápláljon be a komputerbe!");
            System.exit(0);
        }

        return numberArray;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] numberArray = main.askTheNumbers();

        Scanner sc = new Scanner(System.in);
        for (int i = sc.nextInt(); i > 0; i--){

        }

    }

}
