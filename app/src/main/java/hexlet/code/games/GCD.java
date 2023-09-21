package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class GCD {
    private static final String RULES_GAME = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number1 = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            expressionsAndAnswer[i][0] = number1 + " " + number2;
            int tempMod;
            int maxDiv = Math.max(number1, number2);
            int minDiv = Math.min(number1, number2);
            if (minDiv == 0) {
                expressionsAndAnswer[i][1] = minDiv + "";
            } else {
                do {
                    tempMod = maxDiv % minDiv;
                    maxDiv = minDiv;
                    minDiv = tempMod;
                    expressionsAndAnswer[i][1] = maxDiv + "";
                } while (minDiv != 0);
            }
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }
}
