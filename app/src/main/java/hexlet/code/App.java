package hexlet.code;
import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" +
                           "2 - Even\n" +
                           "3 - Calc\n" +
                           "4 - GCD\n" +
                           "5 - Progression\n" +
                           "6 - Prime\n" +
                           "0 - Exit\n");
        System.out.print("Your choice: ");
        Scanner choiceGame = new Scanner(System.in);
        int numberOfGame = choiceGame.nextInt();
        switch (numberOfGame) {
            case 1:
                Cli.welcome();
                break;
            case 2:
                Even.runGame();
                break;
            case 3:
                Calc.runGame();
                break;
            case 4:
                GCD.runGame();
                break;
            case 5:
                Progression.runGame();
                break;
            case 6:
                Prime.runGame();
                break;
            case 0:
                break;
            default: System.out.println("Operation selection error.");
        }
    }
}
