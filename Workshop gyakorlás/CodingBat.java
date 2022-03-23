import java.util.*;

public class CodingBat extends Valami {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String[][] gameBoard = Valami.gameBoardInit();
        Valami.drawGameBoard(gameBoard);
        System.out.println();
        String a = scanner.nextLine();
        String[][] passableGameBoard = Valami.passableBoard();
        Valami.drawGameBoard(passableGameBoard);

        MovingItems.enemyCoordinates = MovingItems.enemyStartingCoordinates(passableGameBoard);
        int[] playerCoordinates = MovingItems.playerStartingCoordinates(passableGameBoard);

        MovingItems.playerColumn = playerCoordinates[0];
        MovingItems.playerRow = playerCoordinates[1];


        Valami.drawGameBoard(passableGameBoard, playerCoordinates);
        System.out.println();

        //a = scanner.nextLine();
        MovingItems.printEnemyMovingCoordinates(passableGameBoard, playerCoordinates);
        for (int i = 0; i < 300; i++) {
            MovingItems.enemyCoordinates = MovingItems.enemyMovingCoordinates(passableGameBoard, playerCoordinates);
            Valami.drawGameBoard(passableGameBoard, playerCoordinates);

            if (Arrays.equals(playerCoordinates, MovingItems.enemyCoordinates)) {
                System.out.println("Célpont megtalálva." + MovingItems.counter);
                System.out.println("Ez a " + Valami.counter + ". randomrenerált pálya.");
                break;
            }
            Thread.sleep(200);
            clearScreen();
        }

    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}

