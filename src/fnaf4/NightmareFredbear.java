package fnaf4;

import java.util.Timer;
import java.util.TimerTask;
public class NightmareFredbear {
    //Attributes
    private int ai;
    private boolean nightmare;
    private static int position = 5;
    private static int randomLaugh;
    private static int countLaugh1;
    private static int countLaugh2;
    private static int countLaugh;
    private int limitLaugh;
    private int timeOfMove;
    private boolean cancel;

    //Construct
    public NightmareFredbear (double ai, boolean nightmare) {
        this.ai = (int) ((ai / 20) * 100);
        this.cancel = false;
        this.nightmare = nightmare;
        if (nightmare) this.timeOfMove = 2;
        else this.timeOfMove = 3;
    }

    //Getter, Setter
    public int getAi() {
        return ai;
    }

    public boolean isNightmare() {
        return nightmare;
    }

    public static int getPosition() {
        return position;
    }

    public static int getRandomLaugh() {
        return randomLaugh;
    }

    public static int getCountLaugh1() {
        return countLaugh1;
    }

    public static int getCountLaugh2() {
        return countLaugh2;
    }

    public static int getCountLaugh() {
        return countLaugh;
    }

    public int getLimitLaugh() {
        return limitLaugh;
    }

    public int getTimeOfMove() {
        return timeOfMove;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setAi(int ai) {
        this.ai = ai;
    }

    public void setNightmare(boolean nightmare) {
        this.nightmare = nightmare;
    }

    public static void setPosition(int position) {
        NightmareFredbear.position = position;
    }

    public static void setRandomLaugh(int randomLaugh) {
        NightmareFredbear.randomLaugh = randomLaugh;
    }

    public static void setCountLaugh1(int countLaugh1) {
        NightmareFredbear.countLaugh1 = countLaugh1;
    }

    public static void setCountLaugh2(int countLaugh2) {
        NightmareFredbear.countLaugh2 = countLaugh2;
    }

    public static void setCountLaugh(int countLaugh) {
        NightmareFredbear.countLaugh = countLaugh;
    }

    public void setLimitLaugh(int limitLaugh) {
        this.limitLaugh = limitLaugh;
    }

    public void setTimeOfMove(int timeOfMove) {
        this.timeOfMove = timeOfMove;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    //Cancel
    public void cancelNightmareFredbear() {
        this.cancel = true;
    }

    //AI
    public void activateNightmareFredbear (boolean aloneOnNight) {
        if (this.ai != 0) {

            //sleep((20) * 1000);

            if (aloneOnNight) this.limitLaugh = 4;
            else this.limitLaugh = 2;

            laughFredbear(this.nightmare, this.limitLaugh);

            Timer timerFredbear = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (cancel || position == 0 || Night.isDeath() || Night.isComplete()) {
                        countLaugh = 100;
                        if (Night.isDeath() && position == 0) {
                            System.out.println("\033[33mFredbear's Jumpscare\033[37m");
                        }
                        cancel = false;
                        System.out.println("\033[33mEnd Fredbear\033[37m");
                        timerFredbear.cancel();
                    }
                    else {
                        if ((int) (Math.random() * (100) + 1) <= NightmareFredbear.this.ai) {


                            aiNightmareFredbear(NightmareFredbear.this.nightmare);


                            System.out.println("\033[33m" + position + "\033[37m");
                        }
                        else {
                            System.out.println("\033[33mFail Move\033[37m");
                        }

                        if (position == 0) {
                            Night.setDeath(true);
                        }
                    }
                }
            };
            timerFredbear.scheduleAtFixedRate(timerTask, (long) (this.timeOfMove) * 1000, (long) (this.timeOfMove) * 1000);
        }
    }

    public static void aiNightmareFredbear(boolean nightmare) {
        if (position == 5) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 4;
            } else if (position == 2) {
                position = 6;
            }
        } else if (position == 4) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 3;
            } else if (position == 2) {
                position = 6;
            }
        } else if (position == 6) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 7;
            } else if (position == 2) {
                position = 4;
            }
        } else if (position == 3) {
            if (nightmare) {
                //sleep((10) * 1000);
                if (position == 3) position = 0;
            } else {
                //sleep((15) * 1000);
                if (position == 3) position = 0;
            }
        } else if (position == 7) {
            if (nightmare) {
                //sleep((10) * 1000);
                if (position == 7) position = 0;
            } else {
                //sleep((15) * 1000);
                if (position == 7) position = 0;
            }
        } else if (position == -1 || position == 1) {
            if (nightmare) {
                //sleep((11) * 1000);
                if (position == -1 || position == 1) position = 0;
            } else {
                //sleep((20) * 1000);
                if (position == -1 || position == 1) position = 0;
            }
        }
    }

    public static void laughFredbear(boolean nightmare, int limit) {
        Timer timerLaugh = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {

                if ((int) (Math.random() * (100) + 1) <= 1 && position != 1) {
                    System.out.println("Fake Laugh");
                }

                randomLaugh = (int) ((Math.random() * (2)) + 1); //1-2

                if (randomLaugh == 1) {
                    countLaugh1++;
                } else {
                    countLaugh2++;
                }

                //System.out.println("Count1: " + countLaugh1 + " Count2: " + countLaugh2);

                if (nightmare) {
                    if (countLaugh1 >= 20 || countLaugh2 >= 20) {
                        position = (int) ((Math.random() * (2)) + 1); //1-2
                        if (position == 1) {
                            NightmareFredbear.position = -1;
                        } else {
                            NightmareFredbear.position = 1;
                        }
                        countLaugh1 = 0;
                        countLaugh2 = 0;
                        System.out.println("Laugh");
                        countLaugh++;
                    }
                } else {
                    if (countLaugh1 >= 30 || countLaugh2 >= 30) {
                        position = (int) ((Math.random() * (2)) + 1); //1-2
                        if (position == 1) {
                            NightmareFredbear.position = -1;
                        } else {
                            NightmareFredbear.position = 1;
                        }
                        countLaugh1 = 0;
                        countLaugh2 = 0;
                        System.out.println("Laugh");
                        countLaugh++;
                    }
                }

                if (countLaugh >= limit || position == 0 || Night.isDeath() || Night.isComplete()) {
                    timerLaugh.cancel();
                }
            }
        };
        timerLaugh.scheduleAtFixedRate(timerTask, (long) (1) * 1000, (long) (1) * 1000);
    }
}
