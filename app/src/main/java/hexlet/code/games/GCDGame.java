package hexlet.code.games;

import hexlet.code.Utils;

public final class GCDGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final String RULE = "Find the greatest common divisor of given numbers.";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        int guessedNumber1 = Utils.getRandomNumber(1, MAX_NUMBER_GUESS);
        int guessedNumber2 = Utils.getRandomNumber(1, MAX_NUMBER_GUESS);
        int rightAnswer = calculateGCD(guessedNumber1, guessedNumber2);
        String question = guessedNumber1 + " " + guessedNumber2;
        return new RoundData(question, String.valueOf(rightAnswer));
    }

    private int calculateGCD(int number1, int number2) {
        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);
        int gcd;
        do {
            gcd = max % min;
            max = min;
            min = gcd;
        } while (gcd != 0);
        return max;
    }
}
