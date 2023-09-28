package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class GCD {

    private static final String RULES_GAME = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number1 = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            expressionsAndAnswer[i][0] = number1 + " " + number2;
            expressionsAndAnswer[i][1] = getGCD(number1, number2) + "";
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    public static int getGCD(int firstNumber, int secondNumber) {
        int tempMod;
        int maxDiv = Math.max(firstNumber, secondNumber);
        int minDiv = Math.min(firstNumber, secondNumber);
        if (minDiv == 0) {
            return minDiv;
        } else {
            do {
                tempMod = maxDiv % minDiv;
                maxDiv = minDiv;
                minDiv = tempMod;
            } while (minDiv != 0);
        }
        return maxDiv;
    }
}
