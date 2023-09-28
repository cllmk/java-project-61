package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class Progression {

    private static final String RULES_GAME = "What number is missing in the progression?";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MIN_LENGTH_PROGRESSION = 5;
    private static final int MAX_LENGTH_PROGRESSION = 10;
    public static final int MIN_STEP_PROGRESSION = 1;
    public static final int MAX_STEP_PROGRESSION = 5;

    private static String[][] generateExpressionsAndRightAnswers() {
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int lengthProgression = Utils.getRandomNumber(MIN_LENGTH_PROGRESSION, MAX_LENGTH_PROGRESSION);
            int stepProgression = Utils.getRandomNumber(MIN_STEP_PROGRESSION, MAX_STEP_PROGRESSION);
            int firstElement = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int[] progression = generateProgression(firstElement, stepProgression, lengthProgression);
            int sizeProgression = progression.length;
            int indexOfHiddenElement = Utils.getRandomNumber(0, sizeProgression - 1);
            int[] onePartOfProgression = Arrays.copyOfRange(progression, 0, indexOfHiddenElement);
            int[] twoPartOfProgression = Arrays.copyOfRange(progression, indexOfHiddenElement + 1, sizeProgression - 1);
            String answer = Arrays.toString(onePartOfProgression) + " .. " + Arrays.toString(twoPartOfProgression);
            expressionsAndAnswer[i][0] = answer.replaceAll(",|\\[|]", "");
            expressionsAndAnswer[i][1] = Integer.toString(progression[indexOfHiddenElement]);
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    public static int[] generateProgression(int firstNumber, int stepProgression, int sizeOfProgression) {
        int[] progression = new int[sizeOfProgression];
        for (int j = 0; j < sizeOfProgression; j++) {
            progression[j] = firstNumber + stepProgression;
            firstNumber = firstNumber + stepProgression;
            }
        return progression;
        }
}
