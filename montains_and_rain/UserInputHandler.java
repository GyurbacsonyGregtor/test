package montains_and_rain;

import java.util.Scanner;

public class UserInputHandler extends Main {

   private Scanner scanner = new Scanner(System.in);
   private boolean valid = false;
    protected void startingText() throws InterruptedException {
        //bemutatkozó szöveg
        System.out.println();
        System.out.println("Üdv a Dimbek-Dombok & Végtelen Forrásvíz című, nagy sikerű játékban!");
        Thread.sleep(100);
        System.out.println("A feladatod elárasztani a terepet vízzel.");
        Thread.sleep(100);
        System.out.println("Mivel a víz elvégzi a munka nagy részét, neked csupán néhány ártalmatlan adatot kell meghatároznod.");
        Thread.sleep(100);
        System.out.println("Például hogy mennyire legyen dimbes-dombos a terep 1-től 100-ig: ");
    }

    protected int getPercentageOfHills() {
        int percentageOfHills = 10;

        do {
            try {
                percentageOfHills = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Írj be egy számot 1-től 100-ig");
                scanner.nextLine();
            }
        } while (!valid);
        return percentageOfHills;
    }

    int getSize() {
        boolean valid;
        System.out.println("Mekkora legyen a pálya 20-tól 70-ig: ");
        valid = false;
        int size = 20;

        do {
            try {
                size = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Írj be egy számot 10-től 70-ig");
                scanner.nextLine();
            }
        } while (!valid);
        return size;
    }

    protected int getSmoothness() {
        boolean valid;
        System.out.println("Mennyire legyen elsimítva a terep?");
        System.out.println("\t0 --> Durván szeretem!");
        System.out.println("\t1 --> Nagy csúcsok");
        System.out.println("\t2 --> Magas dombok");
        System.out.println("\t3 --> Ausztrália");
        System.out.println("\t4 --> Dimbes-dombos");
        System.out.println("\t5 --> Sivatag");
        System.out.println("\t6 --> Hold felszín!");


        valid = false;
        int smoothness = 0;

        do {
            try {
                smoothness = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Írj be egy számot 0-tól 3-ig!");
                scanner.nextLine();
            }
        } while (!valid);
        return smoothness;
    }

    protected int getAmountOfWater() {
        boolean valid;
        System.out.println("Mennyi víz legyen?");
        System.out.println("\t20 alatt kevés.");
        System.out.println("\t40 felett sok.");
        valid = false;
        int amountOfWater = 10;

        do {
            try {
                amountOfWater = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Írj be egy számot!");
                scanner.nextLine();
            }
        } while (!valid);
        return amountOfWater;
    }

    protected long getSpeed() {
        boolean valid;
        System.out.println("És végül: Milyen gyorsan törjön elő a víz? (1000 = 1 mp)");
        valid = false;
        long speed = 10;

        do {
            try {
                speed = Integer.parseInt(scanner.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Írj be egy számot!");
                scanner.nextLine();
            }
        } while (!valid);
        return speed;
    }

}
