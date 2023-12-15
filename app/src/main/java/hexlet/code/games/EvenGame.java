package hexlet.code.games;

import hexlet.code.Utils;

public final class EvenGame implements Game {

    private static final int MAX_NUMBER_GUESS = 100;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";
    private static final String RULE = "Answer '" + YES_ANSWER
            + "' if the number is even, otherwise answer '"
            + NO_ANSWER + "'.";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        int guessedNumber = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        String rightAnswer = isEven(guessedNumber) ? YES_ANSWER : NO_ANSWER;
        return new RoundData(String.valueOf(guessedNumber), rightAnswer);
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
