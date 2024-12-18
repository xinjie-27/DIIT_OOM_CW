package aerocheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaggageTags {

    private static String screenResult;
    public static int tag;
    public static int qty;
    public static double kg;
    public static String green = "\u001b[32m";
    public static String magenta = "\u001b[35m";

    public static String getScreenResult() {
        return screenResult;
    }

    public static String randomTagNo() {
        Random r = new Random();
        char c1 = (char) ('a' + r.nextInt(26));
        char c2 = (char) ('a' + r.nextInt(26));
        char c3 = (char) ('a' + r.nextInt(26));
        int n1 = r.nextInt(10);
        int n2 = r.nextInt(10);
        int n3 = r.nextInt(10);
        String randomTag = "" + Character.toUpperCase(c1) + Character.toUpperCase(c2) + Character.toUpperCase(c3) + n1 + n2 + n3;
        return randomTag;
    }

    public static String currentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }

    public static void baggageTag(Passenger passenger) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nDid you purchase checked baggage?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        while (!Menu.validInput) {
            try {
                System.out.print("Please select [1] or [2]: ");
                tag = scan.nextInt();
                if (tag == 1 || tag == 2) {
                    Menu.validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter [1] or [2].\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter a valid integer.\n");
                scan.nextLine();
            }
        }
        Menu.validInput = false;

        if (tag == 1) {
            while (!Menu.validInput) {
                try {
                    System.out.print("Checked baggage purchased(kg): ");
                    kg = scan.nextDouble();
                    if (kg >= 15 && kg <= 300) {
                        Menu.validInput = true;
                    } else {
                        System.out.println("ERROR! Please enter value between 15 to 300 kg.\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR! Please enter a valid integer.\n");
                    scan.nextLine();
                }
            }
            Menu.validInput = false;

            getScreeningStatus();
            while (!Menu.validInput) {
                try {
                    System.out.print("Enter quantity of baggage tag needed: ");
                    qty = scan.nextInt();
                    if (qty > 0 && qty <= 30) {
                        Menu.validInput = true;
                    } else {
                        System.out.println("ERROR! Min quantity of baggage tag is 1 and Max is 30.\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR! Please enter a valid integer.\n");
                    scan.nextLine();
                }
            }

            for (int i = 1; i < qty + 1; ++i) {
                System.out.println("     _____________________________________________________________ ");
                System.out.println("    |                        Baggage Tag[" + i + "]                       |");
                System.out.println("    |-------------------------------------------------------------|");
                System.out.printf("    |                                                             |");
                System.out.printf("\n    |  Baggage Tag No : %-40s  |", randomTagNo());
                System.out.println("\n    |                                                             |");
                System.out.printf("    |  Booking Number : %-40s  |", passenger.getBookingNo());
                System.out.println("\n    |                                                             |");
                System.out.printf("    |  Checked baggage purchased(kg): %-20.2f        |", kg);
                System.out.println("\n    |                                                             |");
                System.out.printf("    |  Screening status: %-45s     |", getScreenResult());
                System.out.println("\n    |                                                             |");
                System.out.printf("    |                      %-19s                    |", currentTime());
                System.out.println("\n    |_____________________________________________________________|");
            }
        }
        System.out.print("\n\t\t\t~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\t\t\tCheck in successful.\n\t\t\t  Enjoy your trip!");
        System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~");
    }

    public static String getScreeningStatus() {
        if (screenResult == null) {
            Random r = new Random();
            int screenStatus = r.nextInt(3);
            if (screenStatus == 0) {
                screenResult = green + "Cleared for boarding" + Menu.reset;
            } else if (screenStatus == 1) {
                screenResult = magenta + "Flagged for further inspection" + Menu.reset;
            } else {
                screenResult = Menu.red + "Rejected" + Menu.reset;
            }
        }
        return screenResult;
    }

}
