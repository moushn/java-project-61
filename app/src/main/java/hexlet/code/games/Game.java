package hexlet.code.games;

public interface Game {
    String getTask();

    String getQuestion();

    ResultCheckAnswer postAnswer(String answer);
}
