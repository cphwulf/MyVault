public class Vault {
    private int password;
    private static final int MAX_PASSWORD = 9999;
    public Vault(int password) {
        this.password = password;
    }

    public int getMaxPassword() {
        return this.MAX_PASSWORD;
    }

    public boolean isCorrect(int password) {
        boolean retVal = false;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.password == password) {
            retVal = true;
        }
        return retVal;
    }
}
