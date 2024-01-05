package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public class NightmareFoxy {
    //Attributes
    private int ai;
    private static int position = 5;
    private static int progress = -1;
    private boolean cancel;

    //Construct
    public NightmareFoxy (double ai) {
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

    public static int getProgress() {
        return progress;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public static void setPosition(int position) {
        NightmareFoxy.position = position;
    }

    public static void setProgress(int progress) {
        NightmareFoxy.progress = progress;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    //Cancel
    public void cancelNightmareFoxy() {
        this.cancel = true;
    }

    //AI
    public void activateNightmareFoxy () {
        if (this.ai != 0) {
            Timer timerFoxy = new Timer();
            TimerTask timerTask = new TimerTask()
            {
                public void run()
                {
                    if (cancel || position == 0 || progress == 10 || Night.isDeath() || Night.isComplete()) {
                        if (Night.isDeath() && position == 0) {
                            System.out.println("\033[91mFoxy's Jumpscare\033[37m");
                        }
                        cancel = false;
                        System.out.println("\033[91mEnd Foxy\033[37m");
                        timerFoxy.cancel();
                    }
                    else {
                        if ((int) (Math.random() * (100) + 1) <= NightmareFoxy.this.ai) {

                            aiNightmareFoxy();

                            if (position == -1) {
                                System.out.println("\033[91mP: " + progress + "\033[37m");
                            }
                            else {
                                System.out.println("\033[91mC: " + position + "\033[37m");
                            }
                        }
                        else {
                            System.out.println("\033[91mFail Move\033[37m");
                        }

                        if (position == 0) {
                            Night.setDeath(true);
                        }
                    }
                }
            };
            timerFoxy.scheduleAtFixedRate(timerTask, (long) (5) * 1000, (long) (5) * 1000);
        }
    }

    public static void aiNightmareFoxy () {
        if (position == -1) {
            // FoxyInCloset
            if (progress == -1) {
                //Generate progress 3 to 7
                progress = (int) ((Math.random() * (7 - 3 + 1)) + 3); //3-7
            }
            else {
                //If Progress = 10, Nightmare Foxy kill you
                progress++;
            }

            if (progress == 10) {
                position = 0;
            }
        }

        // FoxyRunCorridor
        else {
            // Nightmare Foxy run on corridor: 4, 5 or 6 (10% 3 or 7)
            if (position == 5) {
                position = (int) ((Math.random() * (6 - 4 + 1)) + 4); //4-6
            }
            else if (position == 4) {
                position = (int) ((Math.random() * (10)) + 1); //1-10
                if (position < 10) {
                    position = 5;
                }
                else if (position == 10) {
                    position = 3;
                }
            }
            else if (position == 6) {
                position = (int) ((Math.random() * (10)) + 1); //1-10
                if (position < 10) {
                    position = 5;
                }
                else if (position == 10) {
                    position = 7;
                }
            }
            // Foxy enter to the closet
            else if (position == 3) {
                position = -1;
            }
            else if (position == 7) {
                position = -1;
            }
        }
    }
}
