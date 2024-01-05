package fnaf4;

import fnaf4.functions.Night;
import fnaf4.resources.MenuAnimations;
import fnaf4.resources.MenuResources;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner evan = new Scanner(System.in);
        String menuConsole = "-1";
        int menuAnimationLimit = 0;
        do {
            switch (Night.getGameProgress()) {
                case 0:
                    if (menuAnimationLimit == 0) {
                        MenuAnimations.animationMenu0();
                    }
                    else {
                        System.out.print(MenuResources.resourceMenu0(3));
                    }
                    menuAnimationLimit++;
                    System.out.print("Console: ");
                    menuConsole = evan.next();
                    switch (menuConsole) {
                        case "1":
                            //Reset
                            break;
                        case "2":
                            //1st MiniGame
                            break;
                        case "5":
                            //How to play
                            break;
                        default:
                            break;
                    }
                    break;

            }
        }
        while (!menuConsole.equalsIgnoreCase("Exit"));
        menuAnimationLimit = 0;
    }
}
