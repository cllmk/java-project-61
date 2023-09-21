package hexlet.code;

import javax.sound.midi.Soundbank;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static String userName;
    public static final int COUNT_ROUNDS = 3;
    public static void runGame(String rulesGame, String[][] questionExpression){
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        userName = sc.next();
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

                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", playerAnswer, rightAnswer);
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
        }
    }
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
//    private static int MIN_RANDOM;
//    private static int MAX_RANDOM;
//    public static void setMinMaxRandom(int min, int max) {
//        MIN_RANDOM = min;
//        MAX_RANDOM = max;
//    }
}
