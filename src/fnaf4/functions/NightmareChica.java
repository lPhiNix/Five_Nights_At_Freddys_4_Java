package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public class NightmareChica {
    //Attributes
    private int ai;
    private static int position = 5;
    private boolean cancel;

    //Construct
    public NightmareChica(double ai) {
        this.ai = (int) ((ai / 20) * 100);
        this.cancel = false;
    }

    //Getter, Setter
    public int getAi() {
        return ai;
    }

    public static int getPosition() {
        return position;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public static void setPosition(int position) {
        NightmareChica.position = position;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    //Cancel
    public void cancelNightmareChica() {
        this.cancel = true;
    }

    //AI
    public void activateNightmareChica() {
        if (this.ai != 0) {
            Timer timerChica = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (cancel || position == 0 || Night.isDeath() || Night.isComplete()) {
                        if (Night.isDeath() && position == 0) {
                            System.out.println("\033[93mChica's Jumpscare\033[37m");
                        }
                        cancel = false;
                        System.out.println("\033[93mEnd Chica\033[37m");
                        timerChica.cancel();
                    } else {
                        if ((int) (Math.random() * (100) + 1) <= NightmareChica.this.ai) {

                            aiNightmareChica();

                            System.out.println("\033[93m" + position + "\033[37m");
                        } else {
                            System.out.println("\033[93mFail Move\033[37m");
                        }

                        if (position == 0) {
                            Night.setDeath(true);
                        }
                    }
                }
            };
            timerChica.scheduleAtFixedRate(timerTask, (long) (5) * 1000, (long) (5) * 1000);
        }
    }

    public static void aiNightmareChica() {
        // Nightmare Chica always move to 4 from 6
        if (position == 5) {
            position = 6;
        }
        // If Nightmare Chica is in 6, 33% come back to 5, move to 7 or move to kitchen (9)
        else if (position == 6) {
            position = (int) ((Math.random() * (3)) + 1); //1-3
            if (position == 1) {
                position = 5;
            } else if (position == 2) {
                position = 9;
            } else if (position == 3) {
                position = 7;
            }
        }
        // If Nightmare Chica is in kitchen (9), 50% stay in kitchen or come back to 6
        else if (position == 9) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 9;
            } else if (position == 2) {
                position = 6;
            }
        }
        // If Nightmare Chica is in 7, 33% move to 8, come back 6 or stay in 7
        else if (position == 7) {
            position = (int) ((Math.random() * (8 - 6 + 1)) + 6); //6-8
        }
        // If Nightmare Chica is in 8, NB wait
        else if (position == 8) {
            position = 0;
        }
    }
}
