package montains_and_rain;

public class Main {

    /**
     * Egy egyszerű program egy számokból létrehozott "térképet" irat ki a képernyőre.
     * A számok elhelyezkedése a térkép koordinátá is, értékei pedig terep magasságát jelentik.
     * A felhasználótól bekért adatok alapján létrjött terepet aztán fokozatosan eláraszt a
     * térkép egyik legalacsonyabb ponján feltörő víz.
     * A vízzel elárasztott koordinátákat két mínusz jel jelképezi. A programban ugyan el van mentve a víz mélysége,
     * de ezt a felhasználó nem látja.
     */

    public static void main(String...ˇ) throws InterruptedException {

        UserInputHandler userInputHandler = new UserInputHandler();

        userInputHandler.startingText();

        //adatok bekérése, validálása és változókba mentése
        int percentageOfHills = userInputHandler.getPercentageOfHills();
        int size = userInputHandler.getSize();
        int smoothness = userInputHandler.getSmoothness();
        int amountOfWater = userInputHandler.getAmountOfWater();
        long speed = userInputHandler.getSpeed();

        // játék kezdete, felhasználótól bekért adatok átadása, pálya kirajzolása
        PlayGround playGround = new PlayGround(size, (int) (size * 0.7));

        playGround.makeMountainsNValleys(percentageOfHills, 4, smoothness);
        playGround.floodWithWater(amountOfWater, speed);
    }
}
