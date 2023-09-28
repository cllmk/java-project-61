package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class Even {
    private static final String RULES_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;

    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            expressionsAndAnswer[i][0] = String.valueOf(number);
            expressionsAndAnswer[i][1] = isEven(number) ? "yes" : "no";
            ;
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
