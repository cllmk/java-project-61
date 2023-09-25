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
            int preElementOfProgression = Utils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            String[][] progressionAndHiddenElement = generateProgression(preElementOfProgression, stepProgression, lengthProgression);
            String[] progression = progressionAndHiddenElement[0];
            String hiddenElement = progressionAndHiddenElement[1][0];
            expressionsAndAnswer[i][0] = Arrays.toString(progression).replaceAll(",|\\[|]", "");
            expressionsAndAnswer[i][1] = hiddenElement;
        }
        return expressionsAndAnswer;
    }

    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }

    public static String[][] generateProgression(int firstNumberOfProgression, int stepProgression, int sizeOfProgression){
        String[][] progression = new String[2][sizeOfProgression];
        int indexOfHiddenElement = Utils.getRandomNumber(0, sizeOfProgression - 1);
        for (int j = 0; j < sizeOfProgression; j++) {
            progression[0][j] = String.valueOf(firstNumberOfProgression + stepProgression);
            firstNumberOfProgression = firstNumberOfProgression + stepProgression;
            if (j == indexOfHiddenElement) {
                progression[1][0] = progression[0][j];   // add hiddenElement to [1][0] for processing in the Engine
                progression[0][j] = "..";
            }
        }
        return progression;
    }
}
