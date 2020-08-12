import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class ManualHacker extends Hacker{
    private Long startTime;
    private LocalDateTime startLocalTime;
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;


    public ManualHacker(CountDownLatch countDownLatch, SimpleVault vault, Socket s) {
        super(countDownLatch, vault);
        this.startTime = System.currentTimeMillis();
        this.startLocalTime = LocalDateTime.now();
        this.client = s;
    }

    public void run() {
        try {
            out = new PrintWriter(client.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String name = "";
            String action = "";
            int guess = 0;

            out.println("name : ");
            name = in.readLine();
            Thread.currentThread().setName(name);
            out.println("max val: " + vault.getMaxPassword());
            while (!vault.isCorrect(guess)) {
                out.println("What is your guess?");
                guess = Integer.parseInt(in.readLine());
            }
            out.println("You guessed right");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}