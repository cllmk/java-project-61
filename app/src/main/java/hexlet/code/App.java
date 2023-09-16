package hexlet.code;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" +
                           "2 - Even\n" +
                           "0 - Exit\n");
        Scanner choiceGame = new Scanner(System.in);
        System.out.print("Your choice: ");
        int numberOfGame = choiceGame.nextInt();
        switch (numberOfGame) {
            case 1:
                Cli.welcome();
                break;
            case 2:
                Even.parityCheck();
                break;
            case 0:
                break;
        }
    }
}
