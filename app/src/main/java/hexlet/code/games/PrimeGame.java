package hexlet.code.games;

import hexlet.code.Utils;

import java.math.BigInteger;

public final class PrimeGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";
    private static final String RULE = "Answer '" + YES_ANSWER
            + "' if given number is prime. Otherwise answer '"
            + NO_ANSWER + "'.";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        int guessedNumber = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        String rightAnswer = isProbable(guessedNumber);
        return new RoundData(String.valueOf(guessedNumber), rightAnswer);
    }

    private String isProbable(int number) {
        return BigInteger.valueOf(number).isProbablePrime(1) ? YES_ANSWER : NO_ANSWER;
    }
}
