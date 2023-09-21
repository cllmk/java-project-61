package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

import static hexlet.code.Engine.COUNT_ROUNDS;

public class Progression {
    private static String RULES_GAME = "What number is missing in the progression?";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static String[][] generateExpressionsAndRightAnswers(){
        String[][] expressionsAndAnswer = new String[COUNT_ROUNDS][2];
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int lengthProgression = Engine.getRandomNumber(5, 11);
            int indexOfHiddenElement = Engine.getRandomNumber(0, lengthProgression - 1);
            String hiddenElement = null;
            String[] progression = new String[lengthProgression];
            int preElementOfProgression = Engine.getRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int stepProgression = Engine.getRandomNumber(1, 5);
            for (int j = 0; j < lengthProgression; j++) {
                progression[j] = String.valueOf(preElementOfProgression + stepProgression);
                preElementOfProgression = preElementOfProgression + stepProgression;
                if (j == indexOfHiddenElement) {
                    hiddenElement = progression[j];
                    progression[j] = "..";
                }
            }
            expressionsAndAnswer[i][0] = Arrays.toString(progression).replaceAll(",|\\[|]", "");
            expressionsAndAnswer[i][1] = hiddenElement;
        }
        return expressionsAndAnswer;
    }
    public static void runGame() {
        String[][] rightAnswers = generateExpressionsAndRightAnswers();
        Engine.runGame(RULES_GAME, rightAnswers);
    }
}
