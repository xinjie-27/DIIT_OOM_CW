package aerocheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Menu {

    public static String blue = "\u001B[34m";
    public static String red = "\u001B[31m";
    public static String reset = "\u001B[0m";
    public static int menuChoice;
    public static int checkInChoice;
    public static boolean validInput = false;
    public static boolean guiWindowOpen = false;
    public static boolean exitCanceled = false;

    public void printMenu() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println(" __        __   _                            _        ");
            System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___  ");
            System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\ ");
            System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) |");
            System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/ ");
            System.out.println("     _                   ____ _               _    _  ");
            System.out.println("    / \\   ___ _ __ ___  / ___| |__   ___  ___| | _| | ");
            System.out.println("   / _ \\ / _ \\ '__/ _ \\| |   | '_ \\ / _ \\/ __| |/ / | ");
            System.out.println("  / ___ \\  __/ | | (_) | |___| | | |  __/ (__|   <|_| ");
            System.out.println(" /_/   \\_\\___|_|  \\___/ \\____|_| |_|\\___|\\___|_|\\_(_) ");
            System.out.println("                                ");
            System.out.println("               ___              ");
            System.out.println("               \\\\ `\\         ");
            System.out.println("    ___         \\\\  \\        ");
            System.out.println("   |   \\         \\\\  `\\     ");
            System.out.println("   |____\\         \\    \\     ");
            System.out.println("   |_____\\         \\    `\\   ");
            System.out.println("   |      \\         \\     \\  ");
            System.out.println("   |     __\\__-----------------------------_._._");
            System.out.println("  _|---~~~__o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_o_[][]\\");
            System.out.println("  |___                   /~      )               /");
            System.out.println("     ~~~---..__________ /      ,/_______________/");
            System.out.println("                       /      /");
            System.out.println("                      /     ,/");
            System.out.println("                     /     /");
            System.out.println("                    //   ,/");
            System.out.println("                   //   /");
            System.out.println("                  //__/");
            System.out.println("+======================================================+");
            System.out.println("|                        MENU                          |");
            System.out.println("+======================================================+");
            System.out.println("|                 [1] Counter check-in                 |");
            System.out.println("|                 [2] Self service                     |");
            System.out.println("|                 [3] Exit                             |");
            System.out.println("+======================================================+");

            while (!validInput) {
                try {
                    System.out.print("Please select [1], [2] or [3]: ");
                    menuChoice = scan.nextInt();
                    if (menuChoice == 1 || menuChoice == 2 || menuChoice == 3) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid choice. Please enter [1], [2], or [3].\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR! Please enter a valid integer.\n");
                    scan.nextLine();
                }
            }
            switch (menuChoice) {
                case 1:
                    counterCheckIn();
                    break;
                case 2:
                    selfCheckIn();
                    break;
                case 3:
                    System.out.println("---------------------System ended-----------------------");
                    System.exit(0);
                    return;
            }
            validInput = false;
        }
    }

    public static int counter() {
        Random r = new Random();
        return r.nextInt(10) + 1;
    }

    public static void selfCheckIn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n+======================================================+");
        System.out.println("|                    Self-check In                     |");
        System.out.println("+======================================================+");
        System.out.println("|              [1] Individual Check-in                 |");
        System.out.println("|              [2] Group Check-in                      |");
        System.out.println("+======================================================+");
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Please select [1] or [2]: ");
                checkInChoice = scan.nextInt();
                if (checkInChoice == 1 || checkInChoice == 2) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter [1], [2], or [3].\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR! Please enter a valid integer.\n");
                scan.nextLine();
            }
        }
        validInput = false;

        switch (checkInChoice) {
            case 1:
                individualCheckIn();
                break;

            case 2:
                groupCheckIn();
                break;
        }

    }

    public static void individualCheckIn() {
        Scanner scan = new Scanner(System.in);
        String bookingNo;

        System.out.print("Enter your booking number: ");
        bookingNo = scan.nextLine().toUpperCase();

        while (!IndividualP.validBookingNo(bookingNo)) {
            System.out.print("Error! Please enter a valid booking number: ");
            bookingNo = scan.nextLine().toUpperCase();
        }
        IndividualP.searchIndividualBookNo(bookingNo);
    }

    public static void groupCheckIn() {
        Scanner scan = new Scanner(System.in);
        String bookingNo1;
        System.out.print("Enter your booking number: ");
        bookingNo1 = scan.nextLine().toUpperCase();

        while (!GroupP.validBookingNo(bookingNo1)) {
            System.out.print("Error! Please enter a valid booking number: ");
            bookingNo1 = scan.nextLine().toUpperCase();
        }
        GroupP.searchGroupBookNo(bookingNo1);
    }

    public static void counterCheckIn() {
        JFrame frame = new JFrame("Counter Check-In");
        frame.setSize(500, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        frame.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("<html><center><b>Welcome to AeroCheck!</b><br><br>"
                + "Please proceed to <font color='blue'><b>Counter " + counter() + 
                "</b></font> for assistance.</center></html>");
        label.setFont(new Font("Monospaced", Font.PLAIN, 16));
        label.setBounds(35, 50, 460, 80);
        panel.add(label);

        JButton ok = new JButton("Ok");
        ok.setBounds(200, 150, 100, 40);
        ok.setHorizontalAlignment(JButton.CENTER);
        panel.add(ok);

        ok.addActionListener((ActionEvent e) -> {
            frame.setAlwaysOnTop(false);
            frame.dispose();
            guiWindowOpen = false;
        });

        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        guiWindowOpen = true;
    }
}
