package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class LogicsEven {

    private static int COUNT_CYCLE;

    public static void setCountCycle(int countCycle) {
        COUNT_CYCLE = countCycle;
    }

    private static int MIN_RANDOM;
    private static int MAX_RANDOM;
    public static void setMinMaxRandom(int min, int max) {
        MIN_RANDOM = min;
        MAX_RANDOM = max;
    }
    private static String userName;
    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner sc = new Scanner(System.in);
        userName = sc.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public static void run() {
        int i = 0;
        for (; i < COUNT_CYCLE; i++) {
            int number = getRandomNumber(MIN_RANDOM, MAX_RANDOM);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            Scanner sc = new Scanner(System.in);
            String answer = sc.next().toLowerCase();
            boolean answerBinary = answer.equals("yes");
            String correctAnswer = number % 2 == 0 ? "yes" : "no";
            if (number % 2 == 0 && answerBinary) {
                System.out.println("Correct!");
            } else if (number % 2 != 0 && answer.equals("no")) {
                System.out.println("Correct!");
            } else {
                System.out.println("\'" + answer + "\'"
                        + "is wrong answer ;(. Correct answer was " + "\'"
                        + correctAnswer + "\'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
            if (i == COUNT_CYCLE - 1) {
                System.out.println("Congratulations, " + userName + "!");
            }
        }
    }
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
