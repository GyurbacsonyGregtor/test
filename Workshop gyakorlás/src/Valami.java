import java.util.Random;

class Valami {

    public static Random random = new Random(50);

    public static int height = 40;
    public static int length = 120;
    public static String gameBoardToFill = " ";
    public static String gameBoardFrame = "#";
    public static int numberOfWalls = 20;
    public static String wallBrick = "@";


    public static int counter = 0;


    public static Boolean[][] wallCoordinates() {

        Boolean[][] wallCoordinates = new Boolean[height][length];

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                wallCoordinates[column][row] = false;
            }
        }

        for (int wallNumber = 0; wallNumber <= numberOfWalls; wallNumber++) {
            int wallLengthHorizontal = random.nextInt(length - 6) + 3;
            int wallLengthVertical = random.nextInt(height - 6) + 3;
            int wallPosHorizontalColumn = random.nextInt(height-3) + 3;
            int wallPosHorizontalRow = random.nextInt(length - wallLengthHorizontal-3) + 3;
            int wallPosVerticalColumn = random.nextInt(height - wallLengthVertical-3) + 3;
            int wallPosVerticalRow = random.nextInt(length-3) + 3;

            for (int column = 0; column < height; column++) {
                for (int row = 0; row < length; row++) {
                    if (column >= wallPosHorizontalColumn && column <= wallPosHorizontalColumn + wallLengthHorizontal &&
                            row == wallPosHorizontalRow) {
                        wallCoordinates[column][row] = true;
                    } else if (row >= wallPosHorizontalRow && row <= wallPosVerticalRow + wallLengthVertical &&
                            column == wallPosVerticalColumn) {
                        wallCoordinates[column][row] = true;
                    }
                }
            }
        }

        return wallCoordinates;
    }

    public static String[][] gameBoardInit() {

        Boolean[][] wallCoordinates = wallCoordinates();
        String[][] gameBoard = new String[height][length];

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                if (column == 0 || row == 0 || column == height - 1 || row == length - 1) {
                    gameBoard[column][row] = gameBoardFrame;
                } else if (wallCoordinates[column][row]) {
                    gameBoard[column][row] = wallBrick;
                } else {
                    gameBoard[column][row] = gameBoardToFill;

                }
            }
        }


        return gameBoard;
    }

    public static String[][] passableBoard() throws InterruptedException {

        String[][] passableBoard;

        int spacecounter = 0;
        do {
            spacecounter = 0;
            counter++;

            passableBoard = gameBoardInit();
            outer:
            for (int column = 0; column < height; column++) {
                for (int row = 0; row < length; row++) {
                    if (passableBoard[column][row].equals(gameBoardToFill)) {
                        passableBoard[column][row] = "*";
                        break outer;
                    }

                }
            }
            for (int column = 0; column < height; column++) {
                for (int row = 0; row < length; row++) {
                    if (passableBoard[column][row].equals("*")) {
                        if (passableBoard[column - 1][row].equals(gameBoardToFill)) {
                            passableBoard[column - 1][row] = "*";
                            column = 1;
                            row = 1;
                        }
                        if (passableBoard[column + 1][row].equals(gameBoardToFill)) {
                            passableBoard[column + 1][row] = "*";
                            column = 1;
                            row = 1;
                        }
                        if (passableBoard[column][row - 1].equals(gameBoardToFill)) {
                            passableBoard[column][row - 1] = "*";
                            column = 1;
                            row = 1;
                        }
                        if (passableBoard[column][row + 1].equals(gameBoardToFill)) {
                            passableBoard[column][row + 1] = "*";
                            column = 1;
                            row = 1;
                        }
                    }
                }
            }
            for (int column = 0; column < height; column++) {
                for (int row = 0; row < length; row++) {
                    if (passableBoard[column][row].equals(gameBoardToFill)) {
                        spacecounter++;
                    }
                }
            }
        } while (spacecounter != 0);

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                if (passableBoard[column][row].equals("*")) {
                    passableBoard[column][row] = gameBoardToFill;
                }
            }
        }


        return passableBoard;
    }


    public static void drawGameBoard(String[][] gameBoard) {

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                System.out.print(gameBoard[column][row]);
            }
            System.out.println();
        }
    }

    public static void drawGameBoard(String[][] gameBoard, int[] playerCoordinates) {

        for (int column = 0; column < height; column++) {
            for (int row = 0; row < length; row++) {
                if (MovingItems.enemyCoordinates[0] == column && MovingItems.enemyCoordinates[1] == row) {
                    System.out.print(MovingItems.enemyMark);
                } else if (playerCoordinates[0] == column && playerCoordinates[1] == row) {
                    System.out.print(MovingItems.playerMark);
                } else {
                    System.out.print(gameBoard[column][row]);
                }
            }
                System.out.println();
        }
    }


    public static int[] directions(Direction direction) {

        int coordinates[] = new int[2];

        switch (direction) {

        }

        return coordinates;
    }
}
