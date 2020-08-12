import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class AscHacker extends Hacker{
    private Long startTime;
    private LocalDateTime startLocalTime;

    public AscHacker(CountDownLatch countDownLatch, Vault vault) {
        super(countDownLatch,vault);
        this.startTime = System.currentTimeMillis();
        this.startLocalTime = LocalDateTime.now();
    }
    public void run() {
        for(int guess=0; guess < vault.getMaxPassword(); guess++) {
            //System.out.println("AscGuessing " + guess);
            if(vault.isCorrect(guess) )  {
                System.out.println("You guessed pw from ASC");
                Long timeSpend = System.currentTimeMillis() - startTime;
                System.out.println("Stopping ..." + timeSpend + " as " + LocalDateTime.now());
                countDownLatch.countDown();
                return;
            }
        }
    }
}
