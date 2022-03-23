
public class Blank2 {
    public static void main(String[] a) {

        displayHighScorePosition("Jonatán", calculateHighScorePosition(1500));
        displayHighScorePosition("Dzsonatán", calculateHighScorePosition(900));
        displayHighScorePosition("Joe Nathan", calculateHighScorePosition(400));
        displayHighScorePosition("John Atan", calculateHighScorePosition(50));

    }

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into " + position + ". position on the high score table!");
    }

    public static int calculateHighScorePosition(int playerScore){
        if ( playerScore > 1000) {
            return 1;
        } else if (playerScore > 500){
            return 2;
        } else if (playerScore > 100){
            return 3;
        }   return 4;
    }

}