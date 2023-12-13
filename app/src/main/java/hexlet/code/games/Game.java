package hexlet.code.games;

public interface Game {
    String getRule();

    RoundData generateRound();
}
