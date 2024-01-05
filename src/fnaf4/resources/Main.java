package fnaf4.resources;
import java.util.Scanner;

import fnaf4.functions.Night;
import fnaf4.functions.Sounds;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner evan = new Scanner(System.in);
        System.out.print(NightResources.resourceRoom(5));
        Sounds.addSound("*Breath*");
        Sounds.outputSounds();
        System.out.println(" ");
        System.out.print("Console: ");
        String n = evan.next();

    }
}
