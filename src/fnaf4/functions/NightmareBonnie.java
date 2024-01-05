package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public class NightmareBonnie {
    //Attributes
    private int ai;
    private static int position = 5;
    private boolean cancel;

    //Construct
    public NightmareBonnie(double ai) {
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
        NightmareBonnie.position = position;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    //Cancel
    public void cancelNightmareBonnie() {
        this.cancel = true;
    }

    //AI
    public void activateNightmareBonnie() {
        if (this.ai != 0) {
            Timer timerBonnie = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (cancel || position == 0 || Night.isDeath() || Night.isComplete()) {
                        if (Night.isDeath() && position == 0) {
                            System.out.println("\033[94mBonnie's Jumpscare\033[37m");
                        }
                        cancel = false;
                        System.out.println("\033[94mEnd Bonnie\033[37m");
                        timerBonnie.cancel();
                    }
                    else {
                        if ((int) (Math.random() * (100) + 1) <= NightmareBonnie.this.ai) {

                            aiNightmareBonnie();

                            System.out.println("\033[94m" + position + "\033[37m");
                        } else {
                            System.out.println("\033[94mFail Move\033[37m");
                        }

                        if (position == 0) {
                            Night.setDeath(true);
                        }
                    }
                }
            };
            timerBonnie.scheduleAtFixedRate(timerTask, (long) (5) * 1000, (long) (5) * 1000);
        }
    }

    public static void aiNightmareBonnie() {
        // Nightmare Bonnie always move to 4 from 5
        if (position == 5) {
            position = 4;
        }
        // If Nightmare Bonnie is in 4, 50% come back to 5 or 50% move to 3
        else if (position == 4) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 5;
            } else if (position == 2) {
                position = 3;
            }
        }
        // If Nightmare Bonnie is in 3, 33% move to 2, come back 4 or stay in 3
        else if (position == 3) {
            position = (int) ((Math.random() * (4 - 2 + 1)) + 2); //2-4
        }
        // If Nightmare Bonnie is in 2, NB wait
        else if (position == 2) {
            position = 0;
        }
    }
}
