//backend

import java.util.Random;

public class EvenOrOdd{
    //private variables
    private Random random;
    private static final String[] computerChoices = {"1", "2"};
    private String computerNum;
    private int computerScore = 0, playerScore = 0;
    //constructor
    public EvenOrOdd() {
        random = new Random();
    }
    //helper methods

    //Call this method to begin playing
    public String playEvenOrOdd(String playerChoice, String playerNum) {
        String result;
        int randNum = random.nextInt(2);
        computerNum = computerChoices[randNum];


        if (computerNum.equals(playerNum) && playerChoice.equals("Even")) {
            result = "Player Wins!";
            playerScore++;
        }
        else if (computerNum.equals(playerNum) && playerChoice.equals("Odd")) {
            result = "Computer Wins!";
            computerScore++;
        }
        else if (!(computerNum.equals(playerNum)) && playerChoice.equals("Even")) {
            result = "Computer Wins!";
            computerScore++;
        }
        else {
            result = "Player Wins!";
            playerScore++;
        }

        return result;
    }

    //Getter Methods to be used in the frontend
    public String getComputerNum() {
        return computerNum;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}