package controller;

import java.util.Date;

public class Clock implements Runnable {

    public static final int TICK_LENGTH = 1000; //40 ticks/s
    private boolean running = true;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long startTime;
        while (running) {
            startTime = new Date().getTime();
            tick();
            waitForNextTick(startTime);
        }
    }

    private void tick() {
    }

    private void waitForNextTick(long startTime) {
        long timePassed = new Date().getTime() - startTime;
        long timeToWait = TICK_LENGTH;
        if (timeToWait > 0) {
            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can't keep up!");
            running = false;
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
