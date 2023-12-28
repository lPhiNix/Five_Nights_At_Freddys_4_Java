package fnaf4;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Night {
    //Attributes
    private static int gameProgress = 0;
    private static int continueNight = 1;
    private static int hour = 12;
    private static boolean complete = false;
    private static boolean death = false;
    private static int countnight = 0;
    private static int counthour = 0;

    //Getter, Setter
    public static int getGameProgress() {
        return gameProgress;
    }

    public static int getContinueNight() {
        return continueNight;
    }

    public static int getHour() {
        return hour;
    }

    public static boolean isComplete() {
        return complete;
    }

    public static boolean isDeath() {
        return death;
    }

    public static int getCountnight() {
        return countnight;
    }

    public static int getCounthour() {
        return counthour;
    }

    public static void setGameProgress(int gameProgress) {
        Night.gameProgress = gameProgress;
    }

    public static void setHour(int hour) {
        Night.hour = hour;
    }

    public static void setContinueNight(int continueNight) {
        Night.continueNight = continueNight;
    }

    public static void setComplete(boolean complete) {
        Night.complete = complete;
    }

    public static void setDeath(boolean death) {
        Night.death = death;
    }

    public static void setCountnight(int countnight) {
        Night.countnight = countnight;
    }

    public static void setCounthour(int counthour) {
        Night.counthour = counthour;
    }

    //Hour Cycle
    public static void hourCycle () {

        System.out.println("\033[36m" + hour + "\033[37m");

        Timer timerNight0 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (!death) {
                    if (counthour == (60 * 1000)) {
                        if (hour == 12) {
                            hour = 1;
                        }
                        else if (hour >= 1 && hour < 6) {
                            hour++;
                        }

                        System.out.println("\033[36m" + hour + " 2AM\033[37m");

                        if (hour == 6) {
                            complete = true;
                            gameProgress++;
                            timerNight0.cancel();
                        }

                        counthour = 0;
                    }
                    else {
                        counthour++;
                    }
                }
                else {
                    counthour = 0;
                    timerNight0.cancel();
                }
            }
        };
        timerNight0.scheduleAtFixedRate(timerTask, 1, 1);
    }

    //Night Methods
    public static void Night1 () {
        //2AM - 3AM
        NightmareBonnie nightmareBonnie2AM = new NightmareBonnie(1);
        NightmareChica nightmareChica2AM = new NightmareChica(1);
        NightmareFreddy nightmareFreddy2AM = new NightmareFreddy(1);

        //3AM - 6AM
        NightmareBonnie nightmareBonnie3AM = new NightmareBonnie(3);
        NightmareChica nightmareChica3AM = new NightmareChica(2);
        NightmareFreddy nightmareFreddy3AM = new NightmareFreddy(2);

        hourCycle();
        Room.eventsNight();

        Timer timerNight1 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (hour == 2 && countnight == 0) {
                    //Activate
                    nightmareBonnie2AM.activateNightmareBonnie();
                    nightmareChica2AM.activateNightmareChica();
                    nightmareFreddy2AM.activateNightmareFreddy();
                    countnight++;
                }
                if (hour == 3 && countnight == 1) {
                    //Cancel
                    nightmareBonnie2AM.cancelNightmareBonnie();
                    nightmareChica2AM.cancelNightmareChica();
                    nightmareFreddy2AM.cancelNightmareFreddy();

                    //Activate
                    nightmareBonnie3AM.activateNightmareBonnie();
                    nightmareChica3AM.activateNightmareChica();
                    nightmareFreddy3AM.activateNightmareFreddy();
                    countnight++;
                }
                if (complete || death) {
                    countnight = 0;
                    timerNight1.cancel();
                }
            }
        };
        timerNight1.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void Night2 () {
        //12AM - 3AM
        NightmareBonnie nightmareBonnie12AM = new NightmareBonnie(5);
        NightmareChica nightmareChica12AM = new NightmareChica(5);
        NightmareFoxy nightmareFoxy12AM = new NightmareFoxy(1);
        NightmareFreddy nightmareFreddy12AM = new NightmareFreddy(2);

        //3AM - 6AM
        NightmareBonnie nightmareBonnie3AM = new NightmareBonnie(7);
        NightmareChica nightmareChica3AM = new NightmareChica(7);
        NightmareFoxy nightmareFoxy3AM = new NightmareFoxy(4);
        NightmareFreddy nightmareFreddy3AM = new NightmareFreddy(3);

        hourCycle();
        Room.eventsNight();

        Timer timerNight2 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (hour == 12 && countnight == 0) {
                    //Activate
                    nightmareBonnie12AM.activateNightmareBonnie();
                    nightmareChica12AM.activateNightmareChica();
                    nightmareFoxy12AM.activateNightmareFoxy();
                    nightmareFreddy12AM.activateNightmareFreddy();

                    countnight++;
                }
                if (hour == 3 && countnight == 1) {
                    //Cancel
                    nightmareBonnie12AM.cancelNightmareBonnie();
                    nightmareChica12AM.cancelNightmareChica();
                    nightmareFoxy12AM.cancelNightmareFoxy();
                    nightmareFreddy12AM.cancelNightmareFreddy();

                    //Activate
                    nightmareBonnie3AM.activateNightmareBonnie();
                    nightmareChica3AM.activateNightmareChica();
                    nightmareFoxy3AM.activateNightmareFoxy();
                    nightmareFreddy3AM.activateNightmareFreddy();

                    countnight++;
                }
                if (complete || death) {
                    countnight = 0;
                    timerNight2.cancel();
                }
            }
        };
        timerNight2.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void Night3 () {
        //12AM - 3AM
        NightmareBonnie nightmareBonnie12AM = new NightmareBonnie(7);
        NightmareChica nightmareChica12AM = new NightmareChica(7);

        //3AM - 6AM
        NightmareBonnie nightmareBonnie3AM = new NightmareBonnie(10);
        NightmareChica nightmareChica3AM = new NightmareChica(10);

        //12AM - 6AM
        NightmareFoxy nightmareFoxy12AM = new NightmareFoxy(10);
        NightmareFreddy nightmareFreddy12AM = new NightmareFreddy(3);

        hourCycle();
        Room.eventsNight();

        Timer timerNight3 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (hour == 12 && countnight == 0) {
                    //Activate
                    nightmareBonnie12AM.activateNightmareBonnie();
                    nightmareChica12AM.activateNightmareChica();
                    nightmareFoxy12AM.activateNightmareFoxy();
                    nightmareFreddy12AM.activateNightmareFreddy();

                    countnight++;
                }
                if (hour == 3 && countnight == 1) {
                    //Cancel
                    nightmareBonnie12AM.cancelNightmareBonnie();
                    nightmareChica12AM.cancelNightmareChica();

                    //Activate
                    nightmareBonnie3AM.activateNightmareBonnie();
                    nightmareChica3AM.activateNightmareChica();

                    countnight++;
                }
                if (complete || death) {
                    countnight = 0;
                    timerNight3.cancel();
                }
            }
        };
        timerNight3.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void Night4 () {
        //12AM - 3AM
        NightmareBonnie nightmareBonnie12AM = new NightmareBonnie(10);
        NightmareChica nightmareChica12AM = new NightmareChica(10);
        NightmareFoxy nightmareFoxy12AM = new NightmareFoxy(5);

        //3AM - 6AM
        NightmareBonnie nightmareBonnie3AM = new NightmareBonnie(12);
        NightmareChica nightmareChica3AM = new NightmareChica(12);
        NightmareFoxy nightmareFoxy3AM = new NightmareFoxy(10);

        //12AM - 6AM
        NightmareFreddy nightmareFreddy12AM = new NightmareFreddy(4);

        hourCycle();
        Room.eventsNight();

        Timer timerNight4 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {
                if (hour == 12 && countnight == 0) {
                    //Activate
                    nightmareBonnie12AM.activateNightmareBonnie();
                    nightmareChica12AM.activateNightmareChica();
                    nightmareFoxy12AM.activateNightmareFoxy();
                    nightmareFreddy12AM.activateNightmareFreddy();

                    countnight++;
                }
                if (hour == 3 && countnight == 1) {
                    //Cancel
                    nightmareBonnie12AM.cancelNightmareBonnie();
                    nightmareChica12AM.cancelNightmareChica();
                    nightmareFoxy12AM.cancelNightmareFoxy();

                    //Activate
                    nightmareBonnie3AM.activateNightmareBonnie();
                    nightmareChica3AM.activateNightmareChica();
                    nightmareFoxy3AM.activateNightmareFoxy();

                    countnight++;
                }
                if (complete || death) {
                    countnight = 0;
                    timerNight4.cancel();
                }
            }
        };
        timerNight4.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void Night5 () {
        //12 AM - 6AM
        NightmareFredbear nightmareFredbear = new NightmareFredbear(12, false);

        hourCycle();
        Room.eventsNight();

        Timer timerNight5 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {

                if (countnight == 0) {
                    //Activate
                    nightmareFredbear.activateNightmareFredbear(true);

                    countnight++;
                }

                if (complete || death) {
                    countnight = 0;
                    timerNight5.cancel();
                }
            }
        };
        timerNight5.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void Night6 () {
        //12AM - 4AM
        NightmareBonnie nightmareBonnie12AM = new NightmareBonnie(12);
        NightmareChica nightmareChica12AM = new NightmareChica(12);
        NightmareFoxy nightmareFoxy12AM = new NightmareFoxy(10);
        NightmareFreddy nightmareFreddy12AM = new NightmareFreddy(5);

        //4AM - 6AM
        NightmareFredbear nightmareFredbear4AM = new NightmareFredbear(15, false);

        hourCycle();
        Room.eventsNight();

        Timer timerNight6 = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {

                if (hour == 12 && countnight == 0) {
                    //Activate
                    nightmareBonnie12AM.activateNightmareBonnie();
                    nightmareChica12AM.activateNightmareChica();
                    nightmareFoxy12AM.activateNightmareFoxy();
                    nightmareFreddy12AM.activateNightmareFreddy();

                    countnight++;
                }
                if (hour == 4 && countnight == 1) {
                    //Cancel
                    nightmareBonnie12AM.cancelNightmareBonnie();
                    nightmareChica12AM.cancelNightmareChica();
                    nightmareFoxy12AM.cancelNightmareFoxy();
                    nightmareFreddy12AM.cancelNightmareFreddy();

                    //Activate
                    nightmareFredbear4AM.activateNightmareFredbear(false);

                    countnight++;
                }

                if (complete || death) {
                    countnight = 0;
                    timerNight6.cancel();
                }
            }
        };
        timerNight6.scheduleAtFixedRate(timerTask, 1, 1);
    }

    public static void NIGHTMARE () {
        //12 AM - 6AM
        NightmareFredbear NIGHTMARE = new NightmareFredbear(20, true);

        hourCycle();
        Room.eventsNight();

        Timer timerNightmare = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            public void run()
            {

                if (countnight == 0) {
                    //Activate
                    NIGHTMARE.activateNightmareFredbear(true);

                    countnight++;
                }

                if (complete || death) {
                    countnight = 0;
                    timerNightmare.cancel();
                }
            }
        };
        timerNightmare.scheduleAtFixedRate(timerTask, 1, 1);
    }
}
