public class SimpleHacker implements Hacker {
    Long timePassed = 0L;
    @Override
    public boolean doGuess(SimpleVault vault, int guess) {
        boolean retVal = vault.isCorrect(guess);
        return retVal;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public Long timePassed() {
        return this.timePassed;
    }
}
