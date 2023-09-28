package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int COUNT_ROUNDS = 3;

    public static void runGame(String rulesGame, String[][] questionExpression) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rulesGame);
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            String question = questionExpression[i][0];
            String rightAnswer = questionExpression[i][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String playerAnswer = sc.next();
            boolean isRightAnswer = rightAnswer.equals(playerAnswer);
            if (isRightAnswer) {
                System.out.println("Correct!");
                if (i == 2) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", playerAnswer, rightAnswer);
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
    }
}
