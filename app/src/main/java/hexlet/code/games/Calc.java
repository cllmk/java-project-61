package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class Calc {

    private static final String RULES_GAME = "What is the result of the expression?";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATORS = {" + ", " - ", " * "};

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number1 = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int operator = Utils.getRandomNumber(0, OPERATORS.length);
            expressionsAndAnswer[i][0] = number1 + OPERATORS[operator] + number2;
            expressionsAndAnswer[i][1] = String.valueOf(calculate(number1, number2, OPERATORS[operator]));
        }
        return expressionsAndAnswer;
    }

    public static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case " + " -> num1 + num2;
            case " - " -> num1 - num2;
            case " * " -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
