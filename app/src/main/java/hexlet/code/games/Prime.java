package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class Prime {

    private static final String RULES_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;


    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            String answer = isPrime(number) ? "yes" : "no";
            expressionsAndAnswer[i][0] = String.valueOf(number);
            expressionsAndAnswer[i][1] = answer;
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    public static boolean isPrime(int number) {
        boolean isPrimeNumber = number > 1;
        for (int j = 2; j <= Math.sqrt(number) && isPrimeNumber; j++) {
            if (number % j == 0) {
                isPrimeNumber = false;
            }
        }
        return isPrimeNumber;
    }
}
