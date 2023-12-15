package hexlet.code.games;

import hexlet.code.Utils;

public final class CalcGame implements Game {
    private static final int MAX_NUMBER_GUESS = 100;
    private static final int GUESSES_OPERATORS_COUNT = 4;
    private static final String RULE = "What is the result of the expression?";

    @Override
    public String getRule() {
        return RULE;
    }

    @Override
    public RoundData generateRound() {
        String question;
        String guessedOperator;
        int guessedNumber1 = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        int guessedNumber2 = Utils.getRandomNumber(MAX_NUMBER_GUESS);
        guessedOperator = switch (Utils.getRandomNumber(GUESSES_OPERATORS_COUNT)) {
            case 0 -> "-";
            case 1 -> "+";
            case 2 -> "/";
            default -> "*";
        };
        int rightAnswer = calculate(guessedNumber1, guessedNumber2, guessedOperator);
        question = guessedNumber1 + " " + (guessedOperator) + " " + guessedNumber2;
        return new RoundData(question, String.valueOf(rightAnswer));
    }

    private int calculate(int number1, int number2, String operator) {
        return switch (operator) {
            case "-" -> number1 - number2;
            case "+" -> number1 + number2;
            case "/" -> number1 / number2;
            default -> number1 * number2;
        };
    }
}
