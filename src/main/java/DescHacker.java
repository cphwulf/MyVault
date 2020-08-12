import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class DescHacker extends Hacker{

    private Long startTime;
    private LocalDateTime startLocalTime;

    public DescHacker(CountDownLatch countDownLatch, Vault vault) {
        super(countDownLatch,vault);
        this.startTime = System.currentTimeMillis();
        this.startLocalTime = LocalDateTime.now();
    }

    @Override
    public boolean doGuess(Vault vault, int guess) {
        return this.vault.isCorrect(guess);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished;
    }


    public void run() {
        int guess = 0;
        for(int i=vault.getMaxPassword(); i > 0; i--) {
            //System.out.println("DescGuessing " + guess);

                System.out.println("You guessed the pw from DES");
                Long timeSpend = System.currentTimeMillis() - startTime;
                System.out.println("Stopping ..." + timeSpend + " as " + LocalDateTime.now());
                countDownLatch.countDown();
                //return;
            }
        }
    }
}

