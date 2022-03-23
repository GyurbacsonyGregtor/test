import java.util.Scanner;

public class blank {

    public static void main(String[] args) {

//        for (int n = 8, a = 0, c = 0, r = 0; a < n * n; a++, r = a % n, c = a / n)
//
//System.out.print
//((c==r&r==n/2-(n+1)%2?"G":c+r==0|c+r==2*n-2?"/":c==n-1&r==0|c==0&r==n-1?"\\":r==0|r==n-1?"|":c==0|c==n-1?"-":" ")+(r==n-1?"\n":""));
//
//        System.out.println();
//
//        int n = 8;
//        for (int r = 1; r <= n; r++)
//            for (int c = 1; c <= n; c++)
//                System.out.print((r == 1 & c == 1 | r == n & c == n ? "/" : r == 1 && c == n || r == n && c == 1 ? "\\" : r == 1 || r == n ? "-" : c == 1 || c == n ? "|" : c == n / 2 && r == n / 2 ? "G" : " ") + (c == n ? "\n" : ""));

//        GoldBarPrinter goldBarPrinter = new GoldBarPrinter();
//        String goldBarMark = "G";
//        int length = goldBarPrinter.askGoldBarLength();
//        goldBarPrinter.setGoldBarMark(goldBarMark);
//        goldBarPrinter.setGoldBarLength(length);
//        String[][] goldBarArray = goldBarPrinter.goldBarArray();
//        goldBarPrinter.printGoldBar(goldBarArray);

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Kérem a számot: ");
//        int number = scanner.nextInt();
//        scanner.close();
//
//        printFormation2(number);
//
//
//        exercise(1000);
    }

    static void exercise(int number) {

        int result = 0;

        if (number == 0) return;
        exercise(number - 1);

        result = getResult(number, result);
        if (result == number) System.out.println(result);
    }

    private static int getResult(int number, int result) {
        while (number != 0) {
            result += Math.pow(number % 10, 3);
            number /= 10;
        }
        return result;
    }


    private static void printFormation(int number) {


        for (int column = 0; column < number; column++) {
            for (int row = 0; row < number; row++) {

                if (number % 2 != 0 && column == number / 2 && row == number / 2) {
                    System.out.print("G");
                } else if (number % 2 == 0 && column == number / 2 - 1 && row == number / 2 - 1) {
                    System.out.print("G");
                } else if ((column == 0 && row == 0) || (column == number - 1 && row == number - 1)) {
                    System.out.print("/");
                } else if ((column == number - 1 && row == 0) || (column == 0 && row == number - 1)) {
                    System.out.print("\\");
                } else if (row == 0 || row == number - 1) {
                    System.out.print("|");
                } else if (column == 0 || column == number - 1) {
                    System.out.print("-");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printFormation2(int number) {

        number = number * 2 + 1;
        for (int row = 1; row < number; row++) {
            for (int column = 1; column <= number; column++) {

                if ((row == column || column == number - row + 1) && row <= number / 2) {
                    if (column <= number / 2) {
                        System.out.print("\\");
                    } else {
                        System.out.print("/");
                    }

                } else if (column == number / 2 + 1) {
                    System.out.print("|");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}