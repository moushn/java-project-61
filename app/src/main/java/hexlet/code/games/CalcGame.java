package hexlet.code.games;

import hexlet.code.Utils;

public final class CalcGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final int GUESSES_OPERATORS_COUNT = 3;
    private static final String RULE = "What is the result of the expression?";
    private static final String OPERATORS = "-+*";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        String question;
        int guessedNumber1 = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        int guessedNumber2 = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        int guessedOperator = Utils.getRandomNumber(GUESSES_OPERATORS_COUNT);
        int rightAnswer = calculate(guessedNumber1, guessedNumber2, guessedOperator);
        question = guessedNumber1 + " " + OPERATORS.charAt(guessedOperator) + " " + guessedNumber2;
        return new RoundData(question, String.valueOf(rightAnswer));
    }

    private int calculate(int number1, int number2, int operator) {
        return switch (operator) {
            case 0 -> number1 - number2;
            case 1 -> number1 + number2;
            default -> number1 * number2;
        };
    }
}
