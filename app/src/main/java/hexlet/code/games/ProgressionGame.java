package hexlet.code.games;

import java.util.Random;
import java.util.StringJoiner;

public final class ProgressionGame implements Game {
    private static final int MAX_FIRST_NUM = 20;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int PROGRESSION_STEP_COEFFICIENT = 3;
    private static final String TASK = "What number is missing in the progression?";
    private static final String HIDDEN_ELEMENT = "..";
    private int guessedElement;

    @Override
    public String getTask() {
        return TASK;
    }

    public String getQuestion() {
        Random random = new Random();
        int[] progression = generateProgression();
        int guessedIndex = random.nextInt(progression.length - 1) + 1;
        guessedElement = progression[guessedIndex];
        return castProgressionToQuestion(progression, guessedIndex);
    }

    public CheckAnswerResult postAnswer(String answer) {
        boolean isRightAnswer = checkAnswer(Integer.parseInt(answer), guessedElement);
        return new CheckAnswerResult(String.valueOf(guessedElement), isRightAnswer);
    }

    private boolean checkAnswer(int answer, int rightAnswer) {
        return rightAnswer == answer;
    }

    private int[] generateProgression() {
        Random random = new Random();
        int[] progression =
                new int[random.nextInt(MIN_PROGRESSION_LENGTH) + MAX_PROGRESSION_LENGTH - MIN_PROGRESSION_LENGTH];
        int step = random.nextInt(PROGRESSION_STEP_COEFFICIENT) + PROGRESSION_STEP_COEFFICIENT;
        progression[0] = random.nextInt(MAX_FIRST_NUM);
        for (int i = 1; i < progression.length; i += 1) {
            progression[i] = progression[i - 1] + step;
        }
        return progression;
    }

    private String castProgressionToQuestion(int[] progression, int index) {
        StringJoiner accum = new StringJoiner(" ");
        for (int i = 0; i < progression.length; i += 1) {
            if (i != index) {
                accum.add(String.valueOf(progression[i]));
            } else {
                accum.add(HIDDEN_ELEMENT);
            }
        }
        return accum.toString();
    }
}
