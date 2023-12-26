package hexlet.code.games;

import hexlet.code.Utils;

public final class ProgressionGame implements Game {
    private static final int MAX_FIRST_NUM = 20;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MIN_PROGRESSION_STEP = 3;
    private static final int MAX_PROGRESSION_STEP = 5;
    private static final String RULE = "What number is missing in the progression?";
    private static final String HIDDEN_ELEMENT = "..";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        String[] progression = generateProgression(Utils.getRandomNumber(MAX_FIRST_NUM),
                Utils.getRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH),
                Utils.getRandomNumber(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP));
        int guessedIndex = Utils.getRandomNumber(progression.length - 1);
        String guessedElement = progression[guessedIndex];
        String question = castProgressionToQuestion(progression, guessedIndex);
        return new RoundData(question, guessedElement);
    }

    private String[] generateProgression(int firstElement, int length, int step) {
        String[] progression = new String[length];
        int currentValue = firstElement;
        for (int i = 0; i < progression.length; i += 1) {
            progression[i] = String.valueOf(currentValue);
            currentValue += step;
        }
        return progression;
    }

    private String castProgressionToQuestion(String[] progression, int index) {
        progression[index] = HIDDEN_ELEMENT;
        return String.join(" ", progression);
    }
}
