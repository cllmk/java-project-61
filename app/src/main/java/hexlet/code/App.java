package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final int GREET_USER = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner choiceGame = new Scanner(System.in);
        int numberOfGame = choiceGame.nextInt();
        switch (numberOfGame) {
            case GREET_USER:
                Cli.welcome();
                break;
            case EVEN_GAME:
                Even.runGame();
                break;
            case CALC_GAME:
                Calc.runGame();
                break;
            case GCD_GAME:
                GCD.runGame();
                break;
            case PROGRESSION_GAME:
                Progression.runGame();
                break;
            case PRIME_GAME:
                Prime.runGame();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Operation selection error.");
        }
    }
}
