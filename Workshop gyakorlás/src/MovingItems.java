public class MovingItems extends Valami {


    public static String enemyMark = "X";
    public static String playerMark = "O";

    public static int[] enemyCoordinates = new int[2];


    public static int playerColumn = 0;
    public static int playerRow = 0;

    public static int counter = 0;


    public static int[] enemyStartingCoordinates(String[][] passableGamBoard) {


        while (!passableGamBoard[enemyCoordinates[0]][enemyCoordinates[1]].equals(" ")) {
            enemyCoordinates[0] = Valami.random.nextInt(height - 1);
            enemyCoordinates[1] = Valami.random.nextInt(length - 1);
        }

        return enemyCoordinates;
    }

    public static int[] enemyMovingCoordinates(String[][] passableGamBoard, int[] playerCoordinates) {

        boolean enemyFound = false;
        String[][] passableGamBoardCopy = new String[height][length];

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                passableGamBoardCopy[column][row] = passableGamBoard[column][row];
            }
        }
        passableGamBoardCopy[playerCoordinates[0]][playerCoordinates[1]] = "*";
        do {

            if (passableGamBoardCopy[enemyCoordinates[0] - 1][enemyCoordinates[1]].equals("*")) {
                enemyCoordinates[0] -= 1;
                return enemyCoordinates;
            }
            if (passableGamBoardCopy[enemyCoordinates[0] + 1][enemyCoordinates[1]].equals("*")) {
                enemyCoordinates[0] += 1;
                return enemyCoordinates;
            }
            if (passableGamBoardCopy[enemyCoordinates[0]][enemyCoordinates[1] - 1].equals("*")) {
                enemyCoordinates[1] -= 1;
                return enemyCoordinates;
            }
            if (passableGamBoardCopy[enemyCoordinates[0]][enemyCoordinates[1] + 1].equals("*")) {
                enemyCoordinates[1] += 1;
                return enemyCoordinates;
            }
            outer:
            for (int column = 1; column < height - 1; column++) {
                for (int row = 1; row < length - 1; row++) {
                    boolean changed = false;
                    enemyFound = false;
                    if (passableGamBoardCopy[column][row].equals("*")) {

                        if (passableGamBoardCopy[column - 1][row].equals(gameBoardToFill)) {
                            passableGamBoardCopy[column - 1][row] = "*";
                            counter++;
                            break outer;
                        }
                        if (passableGamBoardCopy[column + 1][row].equals(gameBoardToFill)) {
                            passableGamBoardCopy[column + 1][row] = "*";
                            counter++;
                            break outer;
                        }
                        if (passableGamBoardCopy[column][row - 1].equals(gameBoardToFill)) {
                            passableGamBoardCopy[column][row - 1] = "*";
                            counter++;
                            break outer;
                        }
                        if (passableGamBoardCopy[column][row + 1].equals(gameBoardToFill)) {
                            passableGamBoardCopy[column][row + 1] = "*";
                            counter++;
                            break outer;
                        }

                    }
                }
            }
        }
        while (!enemyFound);


        return enemyCoordinates;
    }

    public static int[] playerStartingCoordinates(String[][] passableGamBoard) {

        int[] playerStartingCoordinates = new int[2];


        while (!passableGamBoard[playerColumn][playerRow].equals(" ") && (playerColumn != enemyCoordinates[0] && playerRow != enemyCoordinates[1])) {
            playerColumn = Valami.random.nextInt(height - 1);
            playerRow = Valami.random.nextInt(length - 1);
        }
        playerStartingCoordinates[0] = playerColumn;
        playerStartingCoordinates[1] = playerRow;


        return playerStartingCoordinates;
    }

    public static void printEnemyMovingCoordinates(String[][] passableGamBoard, int[] playerCoordinates) throws InterruptedException {

        String[][] passableGamBoardCopy = new String[height][length];

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                passableGamBoardCopy[column][row] = passableGamBoard[column][row];
            }
        }
        passableGamBoardCopy[playerCoordinates[0]][playerCoordinates[1]] = "*";
        boolean enemyFound = false;
        do {
            outer:
            for (int column = 1; column < height - 1; column++) {
                for (int row = 1; row < length - 1; row++) {
                    enemyFound = false;
                    boolean changed = false;
                    if (passableGamBoardCopy[column][row].equals("*")) {

                        if (column - 1 == enemyCoordinates[0] && row == enemyCoordinates[1]) {
                            enemyFound = true;
                            enemyCoordinates[0] = column - 1;
                            enemyCoordinates[1] = row;
                            break outer;
                        }
                        if (column + 1 == enemyCoordinates[0] && row == enemyCoordinates[1]) {
                            enemyFound = true;
                            enemyCoordinates[0] = column + 1;
                            enemyCoordinates[1] = row;
                            break outer;
                        }
                        if (column == enemyCoordinates[0] && row + 1 == enemyCoordinates[1]) {
                            enemyFound = true;
                            enemyCoordinates[0] = column;
                            enemyCoordinates[1] = row + 1;
                            break outer;
                        }
                        if (column == enemyCoordinates[0] && row - 1 == enemyCoordinates[1]) {
                            enemyFound = true;
                            enemyCoordinates[0] = column;
                            enemyCoordinates[1] = row - 1;
                            break outer;
                        }





                                    if (passableGamBoardCopy[column - 1][row].equals(gameBoardToFill)) {
                                        passableGamBoardCopy[column - 1][row] = "*";
                                        counter++;
                                        break outer;
                                    }
                                    if (passableGamBoardCopy[column + 1][row].equals(gameBoardToFill)) {
                                        passableGamBoardCopy[column + 1][row] = "*";
                                        counter++;
                                        break outer;
                                    }
                                    if (passableGamBoardCopy[column][row - 1].equals(gameBoardToFill)) {
                                        passableGamBoardCopy[column][row - 1] = "*";
                                        counter++;
                                        break outer;
                                    }
                                    if (passableGamBoardCopy[column][row + 1].equals(gameBoardToFill)) {
                                        passableGamBoardCopy[column][row + 1] = "*";
                                        counter++;
                                        break outer;
                                    }

                                }


                        if (changed) {
                            for (int i = 0; i < height; i++) {
                                for (int i1 = 0; i1 < length; i1++) {
                                    System.out.print(passableGamBoardCopy[i][i1]);
                                }
                                System.out.println();
                            }
                            Thread.sleep(200);
                        }

                }
            }
        } while (!enemyFound);
    }

}
