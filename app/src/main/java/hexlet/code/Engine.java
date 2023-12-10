package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.CheckAnswerResult;

import java.util.Scanner;

public class Engine {
    private static final int ROUND_COUNT = 3;

    public static void runGame(Game game) {
        String answer;
        CheckAnswerResult checkAnswerResult;
        Scanner scanner = new Scanner(System.in);

        Cli.welcome();
        System.out.println(game.getTask());
        for (int i = 0; i < ROUND_COUNT; i += 1) {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Your answer: ");
            answer = scanner.next();
            checkAnswerResult = game.postAnswer(answer);
            System.out.println(dialogSupporter(answer, checkAnswerResult, i));
            if (!checkAnswerResult.isRightAnswer()) {
                break;
            }
        }
    }

    private static String dialogSupporter(String answer,
                                          CheckAnswerResult checkAnswerResult,
                                          int step) {
        String resultCheckInfo = checkAnswerResult.isRightAnswer()
                ? "Correct!"
                : "'" + answer + "' is wrong answer ;(. Correct answer was '"
                + checkAnswerResult.getRightAnswer() + "'.\n"
                + "Let's try again, " + Cli.getUsername() + "!";
        if (checkAnswerResult.isRightAnswer() && step == ROUND_COUNT - 1) {
            resultCheckInfo += "\nCongratulations, " + Cli.getUsername() + "!";
        }
        return resultCheckInfo;
    }
}
