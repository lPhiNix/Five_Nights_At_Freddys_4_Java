package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Room {
    //Attributes
    private static boolean lookAtBed = false;
    private static boolean illuminateBed = false;
    private static boolean stayLeftDoor = false;
    private static boolean illuminateLeftDoor = false;
    private static boolean closeLeftDoor = false;
    private static boolean stayRightDoor = false;
    private static boolean illuminateRightDoor = false;
    private static boolean closeRightDoor = false;
    private static boolean stayCloset = false;
    private static boolean illuminateCloset = false;
    private static boolean closeCloset = false;

    //Counts
    private static int fredbearLeftToClosetBedSeconds = 0;

    //Events
    public static void eventsNight () {
        Timer timerEvents = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                if (Night.isDeath() || Night.isComplete()) {
                    timerEvents.cancel();
                }
                else {
                    illuminateLeftBonnie();
                    illuminateRightChica();
                    closeLeftBonnie();
                    closeRightChica();
                    dontClosetFoxy();
                    illuminateClosetFoxy();
                    lowProgressClosetFoxy();
                    lowProgressBedFreddy();
                    illuminateLeftFredbear();
                    illuminateRightFredbear();
                    closeLeftFredbear();
                    closeRightFredbear();
                    doLeftClosetBedFredbear();
                    doRightClosetBedFredbear();
                    illuminateBedFredbear();
                    illuminateClosetFredbear();
                    closeClosetFredbear();
                }
            }
        };
        timerEvents.scheduleAtFixedRate(timerTask, 100, 100);
    }

    public static void illuminateLeftBonnie () {
        if (stayLeftDoor && illuminateLeftDoor && NightmareBonnie.getPosition() == 2) {
            Night.setDeath(true);
            System.out.print("\033[94mBonnie's Jumpscare in Left Door\033[37m");
        }
        else if (stayLeftDoor && illuminateLeftDoor && (NightmareBonnie.getPosition() == 3 || NightmareBonnie.getPosition() == 4)) {
            NightmareBonnie.setPosition(5);
        }
    }

    public static void illuminateRightChica () {
        if (stayLeftDoor && illuminateLeftDoor && NightmareChica.getPosition() == 8) {
            Night.setDeath(true);
            System.out.print("\033[94mBonnie's Jumpscare in Left Door\033[37m");
        }
        else if (stayLeftDoor && illuminateLeftDoor && (NightmareBonnie.getPosition() == 6 || NightmareBonnie.getPosition() == 7)) {
            NightmareBonnie.setPosition(5);
        }
    }

    public static void closeLeftBonnie () {
        if (stayLeftDoor && closeLeftDoor && NightmareBonnie.getPosition() == 2) {
            NightmareBonnie.setPosition(4);
        }
        else if (stayLeftDoor && closeLeftDoor && NightmareBonnie.getPosition() == 3) {
            NightmareBonnie.setPosition(2);
        }
    }

    public static void closeRightChica () {
        if (stayRightDoor && closeRightDoor && NightmareChica.getPosition() == 8) {
            NightmareBonnie.setPosition(6);
        }
        else if (stayRightDoor && closeRightDoor && NightmareChica.getPosition() == 7) {
            NightmareBonnie.setPosition(8);
        }
    }

    public static void dontClosetFoxy () {
        if (stayLeftDoor && illuminateLeftDoor && NightmareFoxy.getPosition() == 3) {
            NightmareFoxy.setPosition(4);
        }
        else if (stayRightDoor && illuminateRightDoor && NightmareFoxy.getPosition() == 7) {
            NightmareFoxy.setPosition(6);
        }
    }

    public static void illuminateClosetFoxy () {
        if (stayCloset && illuminateCloset && NightmareFoxy.getPosition() == -1) {
            if (NightmareFoxy.getProgress() >= 6) {
                System.out.print("\033[91mFoxy's mini jumpscare in closet\033[37m");
            }
            else if (NightmareFoxy.getProgress() >= 4) {
                System.out.print("\033[91mFoxy in the dark\033[37m");
            }
            else if (NightmareFoxy.getProgress() >= 2) {
                System.out.print("\033[91mIt looks like a hook\033[37m");
            }
            else if (NightmareFoxy.getProgress() >= 0) {
                System.out.print("\033[91mFoxy plush\033[37m");
            }
        }
    }

    public static void lowProgressClosetFoxy () {
        if (stayCloset && closeCloset && NightmareFoxy.getPosition() == -1) {
            Timer timerLowProgress = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    NightmareFoxy.setProgress(NightmareFoxy.getProgress() - 1);
                    if (!closeCloset || NightmareFoxy.getProgress() == 0) {
                        timerLowProgress.cancel();
                    }
                }
            };
            timerLowProgress.scheduleAtFixedRate(timerTask, 1000, 1000);
        }
    }

    public static void lowProgressBedFreddy () {
        if (lookAtBed && illuminateBed && NightmareFreddy.getProgress() < 60) {
            Timer timerLowProgress = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    if (NightmareFreddy.getProgress() >= 20) {
                        NightmareFreddy.setProgress(NightmareFreddy.getProgress() - 20);
                    }
                    else {
                        NightmareFreddy.setProgress(0);
                    }
                    if (!illuminateBed || NightmareFreddy.getProgress() == 0) {
                        timerLowProgress.cancel();
                    }
                }
            };
            timerLowProgress.scheduleAtFixedRate(timerTask, 1000, 1000);
        }
    }

    public static void illuminateLeftFredbear () {
        if (stayLeftDoor && illuminateLeftDoor && (NightmareFredbear.getPosition() == 2 || NightmareFredbear.getPosition() == 3)) {
            Night.setDeath(true);
            System.out.print("\033[33mFredbear's Jumpscare in Left Door\033[37m");
        }
    }

    public static void illuminateRightFredbear () {
        if (stayRightDoor && illuminateRightDoor && (NightmareFredbear.getPosition() == 7 || NightmareFredbear.getPosition() == 8)) {
            Night.setDeath(true);
            System.out.print("\033[33mFredbear's Jumpscare in Right Door\033[37m");
        }
    }

    public static void closeLeftFredbear () {
        if (stayLeftDoor && closeLeftDoor && (NightmareFredbear.getPosition() == 2 || NightmareFredbear.getPosition() == 3)) {
            NightmareFredbear.setPosition(6);
        }
    }

    public static void closeRightFredbear () {
        if (stayRightDoor && closeRightDoor && (NightmareFredbear.getPosition() == 7 || NightmareFredbear.getPosition() == 8)) {
            NightmareFredbear.setPosition(4);
        }
    }

    public static void doRightClosetBedFredbear () {
        if (NightmareFredbear.getPosition() == 2 || NightmareFredbear.getPosition() == 3) {
            Timer timerClosetBedFredbear = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    fredbearLeftToClosetBedSeconds++;
                    System.out.print(fredbearLeftToClosetBedSeconds + " " + NightmareFredbear.getPosition());
                    if (fredbearLeftToClosetBedSeconds >= 10 && stayRightDoor) {
                        NightmareFredbear.setPosition((int) ((Math.random() * (2)) + 1));
                        if (NightmareFredbear.getPosition() == 1) {
                            NightmareFredbear.setPosition(-1);
                        } else {
                            NightmareFredbear.setPosition(1);
                        }
                    }
                    if (NightmareFredbear.getPosition() != 2 && NightmareFredbear.getPosition() != 3) {
                        fredbearLeftToClosetBedSeconds = 0;
                        timerClosetBedFredbear.cancel();
                    }
                }
            };
            timerClosetBedFredbear.scheduleAtFixedRate(timerTask, 1000, 1000);
        }
    }

    public static void doLeftClosetBedFredbear () {
        if (NightmareFredbear.getPosition() == 7 || NightmareFredbear.getPosition() == 8) {
            Timer timerClosetBedFredbear = new Timer();
            TimerTask timerTask = new TimerTask() {
                public void run() {
                    fredbearLeftToClosetBedSeconds++;
                    System.out.print(fredbearLeftToClosetBedSeconds + " " + NightmareFredbear.getPosition());
                    if (fredbearLeftToClosetBedSeconds >= 10 && stayLeftDoor) {
                        NightmareFredbear.setPosition((int) ((Math.random() * (2)) + 1));
                        if (NightmareFredbear.getPosition() == 1) {
                            NightmareFredbear.setPosition(-1);
                        } else {
                            NightmareFredbear.setPosition(1);
                        }
                        timerClosetBedFredbear.cancel();
                    }
                    if (NightmareFredbear.getPosition() != 7 && NightmareFredbear.getPosition() != 8) {
                        fredbearLeftToClosetBedSeconds = 0;
                        timerClosetBedFredbear.cancel();
                    }
                }
            };
            timerClosetBedFredbear.scheduleAtFixedRate(timerTask, 1000, 1000);
        }
    }

    public static void illuminateBedFredbear () {
        if (lookAtBed && illuminateBed && NightmareFredbear.getPosition() == 1) {
            NightmareFredbear.setPosition((int) ((Math.random() * (6 - 4 + 1)) + 4));
        }
    }

    public static void illuminateClosetFredbear () {
        if (stayCloset && illuminateCloset && NightmareFredbear.getPosition() == -1) {
            System.out.print("\033[91mFredbear mini jumpscare in closet\033[37m");
        }
    }

    public static void closeClosetFredbear () {
        if (stayCloset && closeCloset && NightmareFredbear.getPosition() == -1) {
            NightmareFredbear.setPosition((int) ((Math.random() * (6 - 4 + 1)) + 4));
        }
    }
}

