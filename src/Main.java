import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = {"R", "P", "S"};

        while (true) {
            String playerAMove, playerBMove;

            // Get Player A's move
            do {
                System.out.print("Player A, choose your move (R/P/S): ");
                playerAMove = scanner.nextLine().toUpperCase();
            } while (!isValidMove(playerAMove, moves));

            // Get Player B's move
            do {
                System.out.print("Player B, choose your move (R/P/S): ");
                playerBMove = scanner.nextLine().toUpperCase();
            } while (!isValidMove(playerBMove, moves));

            // Compare moves and determine winner
            int result = (getIndex(playerAMove, moves) - getIndex(playerBMove, moves) + 3) % 3;
            if (result == 0) {
                System.out.println("Rock vs Rock, it's a Tie!");
            } else if (result == 1) {
                System.out.println("Player A wins! " + getWinningPhrase(playerAMove, playerBMove));
            } else {
                System.out.println("Player B wins! " + getWinningPhrase(playerBMove, playerAMove));
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgain = scanner.nextLine().toUpperCase();

            if (!playAgain.equals("Y")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    private static boolean isValidMove(String move, String[] moves) {
        for (String validMove : moves) {
            if (move.equals(validMove)) {
                return true;
            }
        }
        return false;
    }

    private static int getIndex(String move, String[] moves) {
        for (int i = 0; i < moves.length; i++) {
            if (move.equals(moves[i])) {
                return i;
            }
        }
        return -1;
    }

    private static String getWinningPhrase(String winnerMove, String loserMove) {
        if (winnerMove.equals("R") && loserMove.equals("S")) {
            return "Rock breaks Scissors!";
        } else if (winnerMove.equals("P") && loserMove.equals("R")) {
            return "Paper covers Rock!";
        } else if (winnerMove.equals("S") && loserMove.equals("P")) {
            return "Scissors cut Paper!";
        } else {
            return "";
        }
    }
}
