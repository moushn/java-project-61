package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.ResultCheckAnswer;

import java.util.Scanner;

public class Engine {
    private static final int ROUND_COUNT = 3;

    public static void runGame(Game game) {
        String answer;
        ResultCheckAnswer resultCheckAnswer;
        Scanner scanner = new Scanner(System.in);

        Cli.welcome();
        System.out.println(game.getTask());
        for (int i = 0; i < ROUND_COUNT; i += 1) {
            System.out.println("Question: " + game.getQuestion());
            System.out.print("Your answer: ");
            answer = scanner.next();
            resultCheckAnswer = game.postAnswer(answer);
            System.out.println(dialogSupporter(answer, resultCheckAnswer, i));
            if (!resultCheckAnswer.isRightAnswer()) {
                break;
            }
        }
    }

    private static String dialogSupporter(String answer,
                                          ResultCheckAnswer resultCheckAnswer,
                                          int step) {
        String resultCheckInfo = resultCheckAnswer.isRightAnswer()
                ? "Correct!"
                : "'" + answer + "' is wrong answer ;(. Correct answer was '"
                + resultCheckAnswer.getRightAnswer() + "'.\n"
                + "Let's try again, " + Cli.getUsername() + "!";
        if (resultCheckAnswer.isRightAnswer() && step == ROUND_COUNT - 1) {
            resultCheckInfo += "\nCongratulations, " + Cli.getUsername() + "!";
        }
        return resultCheckInfo;
    }
}
