import java.util.Scanner;

public class GoldBarPrinter {

    private static int goldBarLength;
    private static String goldBarMark;
    private final String CORNER1 = "/";
    private final String CORNER2 = "\\";
    private final String EDGE_UPDOWN = "-";
    private final String EDGE_RIGHTLEFT = "|";
    private final String GOLDBAR_TOFILL = " ";


    public int getGoldBarLength() {
        return goldBarLength;
    }

    public void setGoldBarLength(int goldBarLength) {
        GoldBarPrinter.goldBarLength = goldBarLength;
    }

    public String getGoldBarMark() {
        return goldBarMark;
    }

    public void setGoldBarMark(String goldBarMark) {
        GoldBarPrinter.goldBarMark = goldBarMark;
    }

    //Ha esetleg el kell menteni az eredményt, és nem csak kiiratni, ez a függvény a tömbben való tárolásra szolgál
    public String[][] goldBarArray() {

        String[][] goldBarArray = new String[goldBarLength][goldBarLength];

        for (int column = 0; column < goldBarLength; column++) {
            for (int row = 0; row < goldBarLength; row++) {
                if ((column == 0 && row == 0) || (column == goldBarLength - 1 && row == goldBarLength - 1)) {
                    goldBarArray[column][row] = CORNER1;

                } else if ((column == goldBarLength - 1 && row == 0) || (column == 0 && row == goldBarLength - 1)) {
                    goldBarArray[column][row] = CORNER2;

                } else if (column == 0 || column == goldBarLength - 1) {
                    goldBarArray[column][row] = EDGE_UPDOWN;

                } else if (row == 0 || row == goldBarLength - 1) {
                    goldBarArray[column][row] = EDGE_RIGHTLEFT;

                } else {
                    goldBarArray[column][row] = GOLDBAR_TOFILL;
                }
            }
        }
        if (goldBarLength % 2 == 0) {
            goldBarArray[goldBarLength / 2 - 1][goldBarLength / 2 - 1] = goldBarMark;
        } else {
            goldBarArray[goldBarLength / 2][goldBarLength / 2] = goldBarMark;
        }

        return goldBarArray;
    }

    public void printGoldBar(String[][] goldBarArray) {

        for (int column = 0; column < goldBarLength; column++) {
            for (int row = 0; row < goldBarLength; row++) {
                System.out.print(goldBarArray[column][row]);

            }
            System.out.println();
        }
    }

    public int askGoldBarLength() {
        Scanner scanner = new Scanner(System.in);
        int goldBarLength = 0;


        if (goldBarLength < 3) {
            System.out.println("Kérem, adja meg az aranytömb hosszát:");
        }
        if (goldBarLength < 3) {
            System.out.println("Az aranytömb mérete nem lehet 3-nál kisebb!");
        }
        return goldBarLength;
    }
}


