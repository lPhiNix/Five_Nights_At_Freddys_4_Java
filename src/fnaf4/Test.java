package fnaf4;

import fnaf4.functions.Night;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner xd = new Scanner(System.in);
        int i = 0;
        int r, l, a, c;
        String con;
        while (!Night.isDeath() || !Night.isComplete()) {
            con = "0";
            r = 0;
            l = 0;
            a = 0;
            c = 0;
            System.out.println("ROOM");
            System.out.print("Console: ");
            con = xd.next();
            switch (con) {
                case "L":
                    do {
                        if (l == 0) {
                            System.out.println("LEFT DOOR");
                        }
                        l++;
                        System.out.print("Console: ");
                        con = xd.next();
                        switch (con) {
                            case "1":
                                System.out.println("*Illuminate*");
                                break;
                            case "2":
                                System.out.println("*Close the Left Door*");
                                break;
                            case "B":
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Command Not Valid.");
                        }

                    } while (!con.equals("B"));
                    break;

                case "R":
                    do {
                        if (r == 0) {
                            System.out.println("RIGHT DOOR");
                        }
                        r++;
                        System.out.print("Console: ");
                        con = xd.next();
                        switch (con) {
                            case "1":
                                System.out.println("*Illuminate*");
                                break;
                            case "2":
                                System.out.println("*Close the Right Door*");
                                break;
                            case "B":
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Command Not Valid.");
                        }
                    } while (!con.equals("B"));
                    break;

                case "A":
                    do {
                        if (a == 0) {
                            System.out.println("CLOSET");
                        }
                        a++;
                        System.out.print("Console: ");
                        con = xd.next();
                        switch (con) {
                            case "1":
                                System.out.println("*Illuminate*");
                                break;
                            case "2":
                                System.out.println("*Close the Closet*");
                                break;
                            case "B":
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Command Not Valid.");
                        }
                    } while (!con.equals("B"));
                    break;

                case "C":
                    do {
                        if (c == 0) {
                            System.out.println("BED");
                        }
                        c++;
                        System.out.print("Console: ");
                        con = xd.next();
                        switch (con) {
                            case "1":
                                System.out.println("*Illuminate*");
                                break;
                            case "B":
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Command Not Valid.");
                        }
                    } while (!con.equals("B"));
                default:
                    System.out.println("Command Not Valid.");
            }
        }
    }
}
