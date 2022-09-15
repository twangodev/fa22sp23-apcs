package hw;

import java.util.Scanner;

// James Ding
public class SmallBigGame {

    double user, computer;
    String winner;

    public SmallBigGame(double initUser, double initComputer) {
        user = initUser;
        computer = initComputer;
    }

    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }

    public int rollSum() {
        return rollDice() + rollDice();
    }

    public double collectBet(Scanner kb) {
        System.out.print("Enter an amount to bet: ");
        double bet = kb.nextDouble();
        if (bet > user) {
            System.out.println("You don't have that much money! Try again.");
            bet = collectBet(kb);
        }
        return bet;
    }

    public String guessInput(Scanner kb) {
        System.out.print("Guess big or small: ");
        String input = kb.nextLine().toLowerCase();
        if (!input.equals("big") && !input.equals("small")) {
            System.out.println("I didn't understand that!");
            return guessInput(kb);
        }
        return input;
    }

    public String classifyResult(int result) {
        if (result == 7) return "";
        else if (result < 7) return "small";
        return "big";
    }

    public void doTransaction(double amount) {
        user += amount;
        computer -= amount;
    }

    public void setPossibleWinner() {
        if (user <= 0) winner = "A.I";
        if (computer <= 0) winner = "User";
    }

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