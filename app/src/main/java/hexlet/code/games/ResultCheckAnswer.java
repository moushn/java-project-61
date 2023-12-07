package hexlet.code.games;

public class ResultCheckAnswer {
    private final String rightAnswer;
    private final boolean isRightAnswer;

    public ResultCheckAnswer(String rightAnswer, boolean isRightAnswer) {
        this.rightAnswer = rightAnswer;
        this.isRightAnswer = isRightAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }
}
