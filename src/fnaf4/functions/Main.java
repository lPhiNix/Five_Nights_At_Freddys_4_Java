package fnaf4.functions;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        Scanner xd = new Scanner(System.in);
        PlushTrap.setBonus();
        PlushTrap.addAggressiveness();
        PlushTrap plushTrap = new PlushTrap(1);
        plushTrap.plushTrapCycle();
        PlushTrap.activatePlushTrap();

        Timer timerCycle = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b" +
                        "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b" +
                        "\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                System.out.print("\033[32mSegundos: "
                        + plushTrap.getSeconds() + " | Position: "
                        + PlushTrap.getPosition() + " | Agg: " + PlushTrap.getAggressiveness() +
                        " | Bonus: " + PlushTrap.getBonus() + "\033[37m");
                if (PlushTrap.isDeathTrap() || PlushTrap.isCompleteTrap() || PlushTrap.isTimeIsOut()) {
                    timerCycle.cancel();
                }
            }
        };
        timerCycle.scheduleAtFixedRate(timerTask, 10, 10);

    }
}
