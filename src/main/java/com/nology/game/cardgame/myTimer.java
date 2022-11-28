package com.nology.game.cardgame;
import java.util.Timer;
import java.util.TimerTask;

public class myTimer {

    private static Timer timer = new Timer();
    private static int interval = 5;

    private static final int setInterval() {
        if (interval == 1) {
            timer.cancel();
        }
        return --interval;
    }



    public static void main(String[] args) {

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                System.out.println(setInterval());
            }
        }, 1000, 1000);

    }
}
