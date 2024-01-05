package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public class PlushTrap {
    //Attributes
    private int seconds;
    private static int position = 6;
    private static boolean stop = false;
    private static int aggressiveness;
    private static int bonus = 0;
    private static boolean deathTrap = false;
    private static boolean completeTrap = false;
    private static boolean timeIsOut = false;

    //Construct
    public PlushTrap(int night) {
        if (night >= 5) this.seconds = 30;
        else if (night == 4) this.seconds = 45;
        else if (night == 3) this.seconds = 60;
        else this.seconds = 90;
    }

    //Setter, Getter
    public int getSeconds() {
        return seconds;
    }

    public static int getPosition() {
        return position;
    }

    public static boolean isStop() {
        return stop;
    }

    public static int getAggressiveness() {
        return aggressiveness;
    }

    public static int getBonus() {
        return bonus;
    }


    public static boolean isDeathTrap() {
        return deathTrap;
    }

    public static boolean isCompleteTrap() {
        return completeTrap;
    }

    public static boolean isTimeIsOut() {
        return timeIsOut;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public static void setPosition(int position) {
        PlushTrap.position = position;
    }

    public static void setStop(boolean stop) {
        PlushTrap.stop = stop;
    }

    public static void setAggressiveness(int aggressiveness) {
        PlushTrap.aggressiveness = aggressiveness;
    }

    public static void setBonus(int bonus) {
        PlushTrap.bonus = bonus;
    }

    public static void setDeathTrap(boolean deathTrap) {
        PlushTrap.deathTrap = deathTrap;
    }

    public static void setCompleteTrap(boolean completeTrap) {
        PlushTrap.completeTrap = completeTrap;
    }

    public static void setTimeIsOut(boolean timeIsOut) {
        PlushTrap.timeIsOut = timeIsOut;
    }

    //Fun With PlushTrap Cycle
    public void plushTrapCycle() {
        //System.out.println("\033[32m" + seconds + "s\033[37m");
        Timer timerCycle = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (deathTrap || completeTrap || timeIsOut) {
                    timerCycle.cancel();
                } else {
                    PlushTrap.this.seconds--;
                    //System.out.println("\033[32m" + seconds + "s\033[37m");
                    if (PlushTrap.this.seconds == 0) {
                        timeIsOut = true;
                    }
                }
            }
        };
        timerCycle.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

    //Bonus
    public static void setBonus() {
        Timer timerBonus = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (deathTrap || completeTrap || timeIsOut) {
                    timerBonus.cancel();
                } else {
                    if (!stop) {
                        int bonusTemp = (int) (Math.random() * (2 + 1));
                        if (bonusTemp == 0 && bonus < 2) {
                            bonus++;
                        }
                        else if (bonusTemp == 1 && bonus > 0) {
                            bonus--;
                        }
                        //System.out.println("\033[32m" + bonus + " bonus\033[37m");
                    }
                }
            }
        };
        timerBonus.scheduleAtFixedRate(timerTask, 2000, 2000);
    }

    //Aggressiveness
    public static void addAggressiveness () {
        Timer timerBonus = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (deathTrap || completeTrap || timeIsOut) {
                    timerBonus.cancel();
                } else {
                    if (!stop) {
                        aggressiveness++;
                        //System.out.println(aggressiveness + " agg");
                        if (bonus == 1) {
                            aggressiveness++;
                            //System.out.println(aggressiveness + " agg");

                        }
                        if (bonus == 2) {
                            aggressiveness++;
                            //System.out.println(aggressiveness + " agg");
                        }
                    }
                    else {
                        aggressiveness = 0;
                    }
                }
            }
        };
        timerBonus.scheduleAtFixedRate(timerTask, 50, 50);
    }

    //AI
    public static void activatePlushTrap () {
        Timer timerBonnie = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (deathTrap || completeTrap || timeIsOut) {
                    if (deathTrap) {
                        System.out.println("\033[32mPlushTrap's Jumpscare\033[37m");
                    }
                    else if (completeTrap) {
                        System.out.println("\033[32mGREAT!\033[37m");
                    }
                    else {
                        System.out.println("\033[32mTime is Out!\033[37m");
                    }
                    System.out.println("\033[32mEnd PlushTrap\033[37m");
                    timerBonnie.cancel();
                }
                else {
                    if (aggressiveness >= (int) ((Math.random() * (499 - 400 + 1)) + 400)) {

                        aiPlushTrap();

                        //System.out.println("\033[94m" + position + "\033[37m");
                    } else {
                        //System.out.println("\033[94mFail Move\033[37m");
                    }

                    if (position == 0) {
                        deathTrap = true;
                    }
                }
            }
        };
        timerBonnie.scheduleAtFixedRate(timerTask, (long) (2) * 1000, (long) (2) * 1000);
    }

    public static void aiPlushTrap() {
        if (position == 6) {
            position = 5;
        } else if (position == 5) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 4;
            } else if (position == 2) {
                position = -4;
            }
        } else if (position == 4 || position == -4) {
            position = 3;
        } else if (position == 3) {
            position = (int) ((Math.random() * (2)) + 1); //1-2
            if (position == 1) {
                position = 2;
            } else if (position == 2) {
                position = -2;
            }
        } else if (position == 2 || position == -2) {
            position = 1;
        } else if (position == 1) {
            position = 0;
        }
    }
}
