package fnaf4.functions;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Sounds {
    private static String[] sounds = new String[8];
    //*Breath*, *Steps*, *Broken plates*, *Freedles's Laugh*, *Light steps to left*, *Light steps to right*, *Strong steps*,

    public static void outputSounds() {
        System.out.print("Sounds: ");
        for (String s : sounds) {
            if (s != null) {
                System.out.print(s + " ");
            }
        }
    }

    public static void addSound(String sound) {
        if (repeatSound(sound)) {
            return;
        }

        for (int i = 0; i < sounds.length; i++) {
            if (sounds[i] == null || sounds[i].isEmpty()) {
                sounds[i] = sound;

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        removeSound(sound);
                        timer.cancel();
                    }
                }, 5000);

                return;
            }
        }
    }

    private static boolean repeatSound(String sound) {
        for (String s : sounds) {
            if (s != null && s.equals(sound)) {
                return true;
            }
        }
        return false;
    }

    private static void removeSound(String sound) {
        for (int i = 0; i < sounds.length; i++) {
            if (sounds[i] != null && sounds[i].equals(sound)) {
                sounds[i] = null;
                return;
            }
        }
    }
}