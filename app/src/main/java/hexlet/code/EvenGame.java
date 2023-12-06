package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final int NEED_RIGHT_ANSWER = 3;
    private static final int MAX_NUMBER_GUESS = 100;
    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";

    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        if (play()) {
            System.out.println("Congratulations, " + Cli.getUsername() + "!");
        }
    }

    private static boolean play() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int guessedNumber;
        String answer;
        String rightAnswer;
        boolean isRightAnswer = false;

        for (int i = 0; i < NEED_RIGHT_ANSWER; i += 1) {
            guessedNumber = random.nextInt(MAX_NUMBER_GUESS);
            System.out.println("Question: " + guessedNumber);
            System.out.print("Your answer: ");
            answer = scanner.next();
            rightAnswer = getRightAnswer(guessedNumber);
            isRightAnswer = checkAnswer(answer, rightAnswer);
            System.out.println(dialogSupporter(answer, rightAnswer, isRightAnswer));
            if (!isRightAnswer) {
                break;
            }
        }

        return isRightAnswer;
    }

    private static String getRightAnswer(int guessedNumber) {
        return guessedNumber % 2 == 0 ? YES_ANSWER : NO_ANSWER;
    }

    private static boolean checkAnswer(String answer, String rightAnswer) {
        return rightAnswer.equals(answer);
    }

    private static String dialogSupporter(String answer, String rightAnswer, boolean isRightAnswer) {
        return isRightAnswer
                ? "Correct!"
                : "'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                + "Let's try again, " + Cli.getUsername() + "!";
    }
}
