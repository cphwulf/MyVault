import java.util.concurrent.CountDownLatch;

public abstract class Hacker extends Thread{
    protected Vault vault;
    protected String name;
    protected CountDownLatch countDownLatch;
    protected boolean isFinished;
    protected long result;

    public Hacker(CountDownLatch countDownLatch, Vault vault) {
        this.vault = vault;
        this.countDownLatch = countDownLatch;
        this.name = this.getClass().getSimpleName();
        this.setName(name);
        this.isFinished = false;
        this.result = Long.MIN_VALUE;
    }

    @Override
    public synchronized void start() {
        System.out.println("Starting " + this.getName());
        super.start();
    }

    public abstract boolean doGuess(Vault vault, int guess);
    public abstract boolean isFinished();

}
