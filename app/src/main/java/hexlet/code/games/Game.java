package hexlet.code.games;

public interface Game {
    String getTask();

    String getQuestion();

    CheckAnswerResult postAnswer(String answer);
}
