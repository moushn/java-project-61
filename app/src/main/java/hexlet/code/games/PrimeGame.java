package hexlet.code.games;

import java.math.BigInteger;
import java.util.Random;

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
        Random random = new Random();
        int guessedNumber = random.nextInt(MAX_NUMBER_GUESS);
        String rightAnswer = getRightAnswer(guessedNumber);
        return new RoundData(String.valueOf(guessedNumber), rightAnswer);
    }

    private String getRightAnswer(int number) {
        return BigInteger.valueOf(number).isProbablePrime(1) ? YES_ANSWER : NO_ANSWER;
    }
}
