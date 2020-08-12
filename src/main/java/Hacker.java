public interface Hacker {
    public boolean doGuess(SimpleVault vault, int guess);
    public boolean isFinished();
    public Long timePassed();
}
