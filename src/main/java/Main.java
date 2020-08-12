import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) throws IOException {
        List<Socket> clients = new ArrayList<>();
        int scount=0;
        int slimit=3;
        Socket s = null;
        try (ServerSocket serverSocket = new ServerSocket(5556)) {

            while (scount<slimit) {
                s = serverSocket.accept();
                clients.add(s);
                scount++;
            }
            int count=0;
            int limit=1;
            Random rd = new Random();
            while(count < limit) {
                System.out.println(" ");
                System.out.println(" Starting new rung ..." + count);
                CountDownLatch countDownLatch = new CountDownLatch(4);
                count++;
                //Vault vault = new Vault(rd.nextInt(MAX_PASSWORD));
                Vault vault = new Vault(1234);
                List<Thread> threadList = new ArrayList<>();
                Hacker a = new AscHacker(countDownLatch,vault);
                threadList.add(a);
                for (Socket client: clients ) {
                    Hacker h = new ManualHacker(countDownLatch,vault,client);
                    threadList.add(h);
                }
                Hacker dh = new DescHacker(countDownLatch,vault);
                threadList.add(dh);
                Police ph = new Police(countDownLatch, "Police");
                threadList.add(ph);
                for(Thread t: threadList) {
                    t.start();
                }
                System.out.println("Now running");
                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                for (Thread t: threadSet) {
                    t.getName();
                }
                try {
                    System.out.println("Now waiting" );
                    Long startT = System.currentTimeMillis();
                    Set<Thread> threadSet2 = Thread.getAllStackTraces().keySet();
                    for (Thread t: threadSet2) {
                        System.out.println(t.getName());
                    }
                    countDownLatch.await(8000, TimeUnit.MILLISECONDS);
                    System.out.println("Now done waiting" + (startT - System.currentTimeMillis()));
                    Set<Thread> threadSet3 = Thread.getAllStackTraces().keySet();
                    for (Thread t: threadSet3) {
                        System.out.println(t.getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Now Done");
            }
        }
    }
}
