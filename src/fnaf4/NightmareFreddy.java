package fnaf4;

import java.util.Timer;
import java.util.TimerTask;

public class NightmareFreddy {
    //Attributes
    private int ai;
    private static int progress = 0;
    private static int freedles = 0;
    private boolean cancel;

    //Construct
    public NightmareFreddy(int ai) {
        this.ai = ai;
        this.cancel = false;
    }

    //Getter, Setter
    public int getAi() {
        return ai;
    }

    public static int getProgress() {
        return progress;
    }

    public static int getFreedles() {
        return freedles;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public static void setProgress(int progress) {
        NightmareFreddy.progress = progress;
    }

    public static void setFreedles(int freedles) {
        NightmareFreddy.freedles = freedles;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    //Cancel
    public void cancelNightmareFreddy() {
        this.cancel = true;
    }

    //AI
    public void activateNightmareFreddy() {
        if (this.ai != 0) {
            Timer timerFreddy = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (cancel || progress >= 80 || Night.isDeath() || Night.isComplete()) {
                        if (Night.isDeath() && progress >= 80) {
                            System.out.println("\033[90mFreddy's Jumpscare\033[37m");
                        }
                        cancel = false;
                        System.out.println("\033[90mEnd Freddy\033[37m");
                        timerFreddy.cancel();
                    } else {
                        aiNightmareFreddy(NightmareFreddy.this.ai);

                        System.out.println("\033[90mP: " + progress + " | F: " + freedles + "\033[37m");
                    }

                    if (progress >= 80) {
                        Night.setDeath(true);
                    }
                }
            };
            timerFreddy.scheduleAtFixedRate(timerTask, (long) (4) * 1000, (long) (4) * 1000);
        }
    }

    public static void aiNightmareFreddy (int ai) {
        // freedles++ each 10 of progress
        progress += ai;
        if ((progress >= 10 && freedles == 0) || (progress >= 20 && freedles == 1) || (progress >= 30 && freedles == 2)) {
            freedles++;
        }
        else if ((progress <= 10 && freedles == 1) || (progress <= 20 && freedles == 2) || (progress <= 30 && freedles == 3)) {
            freedles--;
        }
    }
}
