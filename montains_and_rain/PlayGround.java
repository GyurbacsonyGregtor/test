package montains_and_rain;

import java.util.Random;

public class PlayGround {

    private int WIDTH;
    private int DEPTH;
    private Coordinates[][] playGround;
    private final int BASE_HEIGHT = 1;
    private final int MAX_HEIGHT = 20;
    private Random random;

    public PlayGround() {
    }

    public PlayGround(int width, int depth) {
        this.WIDTH = width + 1;
        this.DEPTH = depth + 1;
        initPlayGround();
    }

    public int getBASE_HEIGHT() {
        return BASE_HEIGHT;
    }

    private void initPlayGround() {
        playGround = new Coordinates[DEPTH][WIDTH];

        for (int row = 0; row < DEPTH; row++) {
            for (int column = 0; column < WIDTH; column++) {
                playGround[row][column] = new Coordinates(row, column);
            }
        }
    }

    /**
     * Ez a metódus roughness alkalommal végig iterál a pályán. Az első körben az esetek percentageOfHills százalékában növeli a koordináta
     * magasságát toRaise-zel. A többi körben ezen megnövelt magasságok 80 százalékának a magasságát tovább emeli.
     **/
    public void makeMountainsNValleys(int percentageOfHills, int roughness, int smoothness) {

        random = new Random(654465);
        int toRaise = MAX_HEIGHT / roughness - 1;
        int minHeightOfAHill = 1;
        for (int iteration = 1; iteration <= roughness; iteration++) {
            boolean needToRaise = false;
            if (iteration == 2) percentageOfHills = 70;
            for (int row = 0; row < DEPTH; row++) {
                for (int column = 0; column < WIDTH; column++) {
                    if (((random.nextInt(100) + 1) <= percentageOfHills) && (playGround[row][column].getHeight() >= minHeightOfAHill)
                            && (playGround[row][column].getHeight() <= MAX_HEIGHT - toRaise)) {
                        playGround[row][column].setHeightPlus(random.nextInt(toRaise) + 1);
                        needToRaise = true;
                    }
                }
            }
            if (needToRaise) {
                minHeightOfAHill++;
            }
        }
        for (int row = 0; row < DEPTH; row++) {
            for (int column = 0; column < WIDTH; column++) {
                if (playGround[row][column].getHeight() >= minHeightOfAHill) {
                    terrainSmoothener(row, column, smoothness);
                }
            }
        }
    }

    private void terrainSmoothener(int row, int column, int ringRadius) {
        for (int iteration = 1; iteration <= ringRadius; iteration++) {
            for (int i = row - iteration; i <= row + iteration; i++) {
                for (int j = column - iteration; j <= column + iteration; j++) {
                    if (coordinateChecker(row, column, iteration)) {
                        if ((i == row - iteration || i == row + iteration) && (j == column - iteration || j == column + iteration)) {
                            if (Math.abs(playGround[row][column].getHeight() - playGround[i][j].getHeight()) > 3 &&
                                    playGround[i][j].getHeight() + 1 < MAX_HEIGHT) {
                                playGround[i][j].setHeightPlus(1);

                            }
                        }
                    }
                }
            }
        }
    }

    public void floodWithWater(int amountOfWater, long waterFlowSpeed) throws InterruptedException {

        int startingCoordinates[] = lowestPointCoordinates();
        int startingRow = startingCoordinates[0];
        int startingColumn = startingCoordinates[1];
        playGround[startingRow][startingColumn].setHeight(-1);
        for (int iterations = 1; iterations <= amountOfWater; iterations++) {
            boolean needToRaiseLevel = true;
            printPlayGround(iterations, waterFlowSpeed);
            Thread.sleep(waterFlowSpeed);
            for (int row = 0; row < DEPTH; row++) {
                for (int column = 0; column < WIDTH; column++) {
                    if (coordinateChecker(row, column, 1) && playGround[row][column].getHeight() < 0) {
                        if (Math.abs(playGround[row - 1][column].getHeight()) < Math.abs(playGround[row][column].getHeight())) {
                            playGround[row - 1][column] = playGround[row][column];
                            needToRaiseLevel = false;
                        }
                        if (Math.abs(playGround[row][column + 1].getHeight()) < Math.abs(playGround[row][column].getHeight())) {
                            playGround[row][column + 1] = playGround[row][column];
                            needToRaiseLevel = false;
                        }
                        if (Math.abs(playGround[row + 1][column].getHeight()) < Math.abs(playGround[row][column].getHeight())) {
                            playGround[row + 1][column] = playGround[row][column];
                            needToRaiseLevel = false;
                        }
                        if (Math.abs(playGround[row][column - 1].getHeight()) < Math.abs(playGround[row][column].getHeight())) {
                            playGround[row][column - 1] = playGround[row][column];
                            needToRaiseLevel = false;
                        }

                    }
                }
            }
            if (needToRaiseLevel) {
                playGround[startingRow][startingColumn].setHeightPlus(-1);
            }
        }
    }

    //Megtalálja az első olyan pontot a térképen, ami a legalacsonyabbabn helyezkedik el, és nincs a térkép szélén
    private int[] lowestPointCoordinates() {
        int lowestDepthCoordinate = DEPTH;
        int lowestWidthCoordinate = WIDTH;
        int[] Coordinates = new int[2];
        int counter = Integer.MAX_VALUE;

        for (int row = 1; row < DEPTH - 1; row++) {
            for (int column = 1; column < WIDTH - 1; column++) {
                if (playGround[row][column].getHeight() < counter) {
                    counter = playGround[row][column].getHeight();
                }
            }
        }
        for (int row = 1; row < DEPTH - 1; row++) {
            for (int column = 1; column < WIDTH - 1; column++) {
                if (counter == playGround[row][column].getHeight()) {
                    lowestDepthCoordinate = row;
                    lowestWidthCoordinate = column;
                    break;
                }
            }
        }
        Coordinates[0] = lowestDepthCoordinate;
        Coordinates[1] = lowestWidthCoordinate;
        return Coordinates;
    }

    private boolean coordinateChecker(int row, int column, int spaceToCheck) {
        if (row - spaceToCheck < 0 || row + spaceToCheck >= DEPTH || column - spaceToCheck < 0 || column + spaceToCheck >= WIDTH)
            return false;
        return true;
    }

    // A pálya széle nem kerül kirajzolásra, mivel ott (az egyszerűség kedvéért, hogy ne kelljen mind a négy égtájat lekezelni),
    // nem működik jól a coordinateChecker algoritmus
    private void printPlayGround(int iterations, long waterFlowSpeed) {
        String formattedVolume = String.format("%.02f", iterations * waterFlowSpeed * 1.15);

        String repeat = "---".repeat(WIDTH * 3 < 64 ? 0 : WIDTH / 2 - 12);
        System.out.println(repeat
                + "  " + iterations + " ÓRA ALATT "
                + formattedVolume + " KÖBKILOMÉTER VÍZ ÁRASZTOTTA EL A FÖLDRÉSZT!  "
                + repeat);
        System.out.println("---".repeat(WIDTH - 2));
        for (int i = 1; i < DEPTH - 1; i++) {
            for (int j = 1; j < WIDTH - 1; j++) {
                if (isBetween(playGround[i][j].getHeight(), 0, 9)) {
                    System.out.print("+" + playGround[i][j].getHeight());
                } else if (playGround[i][j].getHeight() < 0) {
                    System.out.print("--");
                } else {
                    System.out.print(playGround[i][j].getHeight());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---".repeat(WIDTH - 2));
        System.out.println();
    }

    /**
     * @param value a number to inspect
     * @return is value between a & b?
     */
    private static boolean isBetween(int value, int a, int b) {
        return value >= Math.min(a, b) && value <= Math.max(a, b);
    }
}
