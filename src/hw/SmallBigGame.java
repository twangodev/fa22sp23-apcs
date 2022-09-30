package hw;

import java.util.Scanner;

// James Ding
public class SmallBigGame {

    double user, computer;
    String winner;

    /**
     * Creates a instance of the game
     * @param initUser The initial amount of money the user has
     * @param initComputer The initial amount of money the computer has
     */
    public SmallBigGame(double initUser, double initComputer) {
        user = initUser;
        computer = initComputer;
    }

    /**
     * Simulates the behavior of rolling a die
     * @return A randomly generated integer from 1-6
     */
    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }

    /**
     * Simulates the behavior of rolling two die
     * @return The sum of two randomly generated integers from 1-6
     */
    public int rollSum() {
        return rollDice() + rollDice();
    }

    /**
     * Prompts user to enter a bet, ensuring that they do have enough money to do so
     * @param kb Scanner
     * @return A legal bet amount
     */
    public double collectBet(Scanner kb) {
        System.out.print("Enter an amount to bet: ");
        double bet = kb.nextDouble();
        if (bet > user) {
            System.out.println("You don't have that much money! Try again.");
            bet = collectBet(kb);
        }
        return bet;
    }

    /**
     * Prompts user to enter a guess, ensuring that it can be understood
     * @param kb Scanner
     * @return A legal guess input, either big or small
     */
    public String guessInput(Scanner kb) {
        System.out.print("Guess big or small: ");
        String input = kb.nextLine().toLowerCase();
        if (!input.equals("big") && !input.equals("small")) {
            System.out.println("I didn't understand that!");
            return guessInput(kb);
        }
        return input;
    }

    /**
     * Classifies a result as big or small
     * @param result The amount the dice rolled
     * @return A actual outcome
     */
    public String classifyResult(int result) {
        if (result == 7) return "";
        else if (result < 7) return "small";
        return "big";
    }

    /**
     * Adds amount to user, and subtracts from computer
     * @param amount The amount of money to add to user, remove from computer
     */
    public void doTransaction(double amount) {
        user += amount;
        computer -= amount;
    }

    /**
     * Checks if game conditions are met in order for there to be a winner
     */
    public void setPossibleWinner() {
        if (user <= 0) winner = "A.I";
        if (computer <= 0) winner = "User";
    }

    /**
     * One round of the game
     * @param kb Scanner
     */
    public void play(Scanner kb) {
        System.out.println("Round begins! You have $" + user + ", A.I has $" + computer);
        double bet = collectBet(kb);
        kb.nextLine(); // Pop new-line character for next iteration
        String guess = guessInput(kb);

        System.out.println("Rolling dice...");
        int result = rollSum();
        System.out.println("The dice rolled to a sum of " + result);

        String classifiedResult = classifyResult(result);
        if (classifiedResult.equals("")) {
            System.out.println("Draw!");
        }
        else if (guess.equals(classifiedResult)) {
            System.out.println("You won that round!");
            doTransaction(bet);
        } else {
            System.out.println("You lost that round!");
            doTransaction(-bet);
        }

        setPossibleWinner();
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        SmallBigGame gameInstance = new SmallBigGame(100, 100);
        while (gameInstance.winner == null) {
            gameInstance.play(kb);
        }
        System.out.println(gameInstance.winner + " wins!");
    }

}