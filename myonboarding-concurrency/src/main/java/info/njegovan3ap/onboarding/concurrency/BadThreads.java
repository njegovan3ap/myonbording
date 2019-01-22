package info.njegovan3ap.onboarding.concurrency;

public class BadThreads {
    static volatile String message;

    static synchronized String getMessage() {
        return message;
    }

    static synchronized void setMessage(String msg) {
        message = msg;
    }

    private static class CorrectorThread
            extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            setMessage("Mares do eat oats.");
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        (new CorrectorThread()).start();
        setMessage("Mares do not eat oats.");
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(getMessage());
    }
}
