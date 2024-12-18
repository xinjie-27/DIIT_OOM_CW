package aerocheck;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SpecialNeeds {

    private static int specialNeed;
    public static int specialAsstChoice;
    private static String assistance = null;

    public static int getSpecialNeed() {
        return specialNeed;
    }

    public static String getAssistance() {
        return assistance;
    }

    public static String SpecialAssistance() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nDo you need special assistance? ");
        System.out.println("[1] Yes ");
        System.out.println("[2] No");
        while (!Menu.validInput) {
            try {
                System.out.print("Please select [1] or [2]: ");
                specialNeed = scan.nextInt();
                if (specialNeed == 1 || specialNeed == 2) {
                    Menu.validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter [1], or [2].\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter a valid integer.\n");
                scan.nextLine();
            }

        }
        Menu.validInput = false;
        if (specialNeed == 1) {
            System.out.println("\n+======================================================+");
            System.out.println("|              Special Assistance Provided             |");
            System.out.println("+======================================================+");
            System.out.println("|               [1] Wheelchair                         |");
            System.out.println("|               [2] Stretcher                          |");
            System.out.println("|               [3] Infant Incubator                   |");
            System.out.println("|               [4] Vision Assistance                  |");
            System.out.println("|               [5] Other                              |");
            System.out.println("+======================================================+");
            while (!Menu.validInput) {
                try {
                    System.out.print("Please enter special assistance needed(1-5): ");
                    specialAsstChoice = scan.nextInt();
                    if (specialAsstChoice >= 1 && specialAsstChoice <= 5) {
                        Menu.validInput = true;
                    } else {
                        System.out.println("Invalid choice. Please enter [1-5].\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR! Please enter a valid integer.\n");
                    scan.nextLine();
                }
            }
            Menu.validInput = false;

            switch (specialAsstChoice) {
                case 1:
                    assistance = "*** Wheelchair NEEDED ***";
                    break;
                case 2:
                    assistance = "*** Stretcher NEEDED ***";
                    break;
                case 3:
                    assistance = "*** Infant Incubator NEEDED ***";
                    break;
                case 4:
                    assistance = "*** Vision Assistance NEEDED ***";
                    break;
                case 5:
                    scan.nextLine();
                    System.out.print("Please specify your needs: ");
                    assistance = "*** " + scan.nextLine() + " NEEDED ***";
                    break;
            }
        } else {
            assistance = "NONE";
        }
        return assistance;
    }
}
