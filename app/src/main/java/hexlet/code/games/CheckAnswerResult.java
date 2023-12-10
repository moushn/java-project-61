package hexlet.code.games;

public final class CheckAnswerResult {
    private final String rightAnswer;
    private final boolean isRightAnswer;

    public CheckAnswerResult(String pRightAnswer, boolean pIsRightAnswer) {
        this.rightAnswer = pRightAnswer;
        this.isRightAnswer = pIsRightAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }
}
