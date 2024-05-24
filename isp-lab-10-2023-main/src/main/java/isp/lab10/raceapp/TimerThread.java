package isp.lab10.raceapp;

public class TimerThread extends Thread {
    private long startTime;
    private long endTime;
    private volatile boolean running = true;

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (running) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Race finished! Time taken: " + elapsedTime/1000.0 + " seconds");
    }

    public void stopTimer() {
        running = false;
    }
}

