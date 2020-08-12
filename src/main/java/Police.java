import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Police extends Thread {
    CountDownLatch countDownLatch;
    String name;

    public Police(CountDownLatch countDownLatch, String  name) {
       this.countDownLatch=countDownLatch;
       this.name=name;

    }

    public void run() {
        for(int i=10;i>0;i--) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException ie) {
                ie.getStackTrace();
            }
            System.out.println("Count: " + i);
            Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
            for (Thread t: threadSet2) {
                t.getName();
            }
        }
        System.out.println("Game ouver ...");
        countDownLatch.countDown();
        //return;
    }
}
