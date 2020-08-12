public class AIHacker extends HackerDecorator implements Runnable{

    public AIHacker(Hacker hacker) {
        super(hacker);
    }

    @Override
    public boolean doGuess(SimpleVault vault, int guess) {
        return super.doGuess(vault,doAI(vault,guess));
    }

    @Override
    public Long timePassed() {
        return super.timePassed();
    }

    public int doAI(Vault vault, int guess) {
        int m = vault.getMaxPassword();
        int retVal = 0;
        //return super.doGuess(vault, guess);
        Long startTime = System.currentTimeMillis();
        for(int i=0;i<m;i++) {
            if (vault.isCorrect(i)) {
                Long stop = System.currentTimeMillis();
                System.out.println("Guessed .." + i + " in " + stop/1000 + " seconds");
                retVal=i;
                return retVal;
            }
        }
        return retVal;
    }

    @Override
    public void run() {

    }
}
