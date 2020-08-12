public class HackerDecorator implements Hacker{

    private Hacker hacker;
    public HackerDecorator(Hacker hacker) {
        this.hacker = hacker;
    }

    public boolean doGuess(SimpleVault vault, int guess) {
        boolean  retVal = this.hacker.doGuess(vault,guess);
        return retVal;
    }

    @Override
    public boolean isFinished() {
        boolean  retVal = hacker.isFinished();
        return retVal;
    }

    @Override
    public Long timePassed() {
        return this.hacker.timePassed();
    }
}
