import java.util.Random; //used to generate random numbers
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //used to store the scores
        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            String[] choice = {"rock", "paper", "scissors"};
            Random rand = new Random();
            String computerChoice = choice[rand.nextInt(3)]; //nextint(): from 0 to n-1

            System.out.println("Enter your move (rock, paper, scissors) or enter exit:");
            String playerChoice = sc.nextLine().toLowerCase().trim();

            if (playerChoice.equals("exit")) {
                System.out.println("Thank you for playing! Good bye!");
                break;
            }
            //checks if a valid move is entered
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid move, please try again");
                continue;
            }


            System.out.println("computer move: " + computerChoice);
            System.out.println("player move: " + playerChoice);

            //when the moves are equal:
            if (computerChoice.equals(playerChoice)) {
                System.out.println("It's a tie!");
                //add 1 point to each and print the scores
                playerScore++;
                computerScore++;
                System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
            } //win conditions:
            else if ((computerChoice.equals("rock") && playerChoice.equals("paper")) ||
                    (computerChoice.equals("paper") && playerChoice.equals("scissors")) ||
                    (computerChoice.equals("scissors") && playerChoice.equals("rock"))) {
                playerScore++;
                System.out.println("You win! The computer bows to your greatness.");
                System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
            }
            else {
                computerScore++;
                System.out.println("You lose! The computer outsmarted you this time.");
                System.out.println("Your score: " + playerScore  + " | Computer score: " + computerScore);
            }

            //asks the player if they want to play another round
            String playAgain = "yes";
            while(true) {
                System.out.println("Do you want to play again? (yes/no): ");
                playAgain = sc.nextLine().toLowerCase().trim();
                //break out of this loop but not the other
                if (playAgain.equals("yes")) {
                    break;
                } //exit both loops, exit the system
                else if (playAgain.equals("no")) {
                    System.out.println("Thank you for playing! Good bye!");
                    System.exit(0);
                } //else the loop runs until yes/no are entered
                else {
                    System.out.println("Invalid input, please try again");
                }
            }
        }

    }
}