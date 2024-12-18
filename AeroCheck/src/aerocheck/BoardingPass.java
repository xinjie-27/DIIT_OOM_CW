package aerocheck;

import java.util.Random;
import java.time.LocalDate;

public class BoardingPass {

    private static String date;
    private static String time;
    private static String gateNo = null;
    private static String flightNo = null;
    private static String flightStatus = null;
    private static String departureTime = null;
    private static String arrivalTime = null;

    public static String getDate() {
        return date;
    }

    public static String getTime() {
        return time;
    }

    public static String getGateNo() {
        return gateNo;
    }

    public static String getFlightNo() {
        return flightNo;
    }

    public static String getFlightStatus() {
        return flightStatus;
    }

    public static String getDepartureTime() {
        return departureTime;
    }

    public static String getArrivalTime() {
        return arrivalTime;
    }

    public static String randomDate() {
        Random r = new Random();
        int year = LocalDate.now().getYear();
        int month = r.nextInt(2) + 6;
        int day = r.nextInt(31) + 1;
        if (day < 10) {
            if (month < 10) {
                date = "0" + day + "/0" + month + "/" + year;
            } else {
                date = "0" + day + "/" + month + "/" + year;
            }
        } else {
            date = day + "/" + month + "/" + year;
        }
        return date;
    }

    public static String randomTime() {
        Random r = new Random();
        int hour = r.nextInt(24);
        int min = r.nextInt(60);
        if (hour < 10) {
            if (min < 0) {
                time = "0" + hour + ":" + "0" + min;
            } else {
                time = "0" + hour + ":" + min;
            }

        } else {
            time = hour + ":" + min;
        }
        return time;
    }

    public static String departureTime() {
        if (departureTime == null) {
            departureTime = randomTime();
        }
        return departureTime;
    }

    public static String arrivalTime() {
        if (arrivalTime == null) {
            arrivalTime = randomTime();
        }
        return arrivalTime;
    }

    public static String gateNo() {
        if (gateNo == null) {
            Random r = new Random();
            char letter = (char) (r.nextInt(26) + 'A');
            int digit = r.nextInt(10) + 1;
            gateNo = Character.toString(letter) + digit;
        }
        return gateNo;
    }

    public static String flightStatus() {
        if (flightStatus == null) {
            Random r = new Random();
            int fStatus = r.nextInt(2);
            if (fStatus == 0) {
                flightStatus = BaggageTags.green + "On Time" + Menu.reset;
            } else {
                flightStatus = Menu.red + "Delayed" + Menu.reset;
            }
        }
        return flightStatus;
    }

    public static String flightNo() {
        if (flightNo == null) {
            Random r = new Random();
            char letter1 = (char) (r.nextInt(26) + 'A');
            char letter2 = (char) (r.nextInt(26) + 'A');
            int digit1 = r.nextInt(9);
            int digit2 = r.nextInt(9);
            int digit3 = r.nextInt(9);
            int digit4 = r.nextInt(9);
            flightNo = Character.toString(letter1) + Character.toString(letter2) + " " + digit1 + digit2 + digit3 + digit4;
        }
        return flightNo;
    }

    public static void printBoardingPass(Passenger passenger) {
        System.out.println("\n=========================================================================================================================================================");
        System.out.printf("|\t\t\t\t\t\tBOARDING PASS\t\t\t\t\t\t\t| %18s -> %-18s |", passenger.getOrigin(), passenger.getDest());
        System.out.print("\n=========================================================================================================================================================");
        System.out.printf("\n| Passenger Name    : %-30s  Departure Date : %-15s \t\t\t| Passenger Name:\t\t\t    |", passenger.getName(), randomDate());
        System.out.printf("\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t| %-40s |", passenger.getName());
        System.out.printf("\n| Origin            : %-30s  Flight Status  : %-15s \t\t\t\t|\t\t\t\t\t    |", passenger.getOrigin(), flightStatus());
        System.out.printf("\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t| Flight Number: \tSeat Number: \t    |");
        System.out.printf("\n| Destination       : %-30s  Flight Number  : %-15s \t\t\t| %-15s \t%-15s\t    |", passenger.getDest(), flightNo(), flightNo(), passenger.getSeatNo());
        System.out.printf("\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\t\t\t\t\t    |");
        System.out.printf("\n| Departure Time    : %-30s  Seat Number    : %-15s \t\t\t| Boarding Gate: \tDeparture Time:\t    |", departureTime(), passenger.getSeatNo());
        System.out.printf("\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t| %-15s \t%-15s\t    |", gateNo(), departureTime());
        System.out.printf("\n| Special Assistance: %-50s\t\t\t\t\t\t|\t\t\t\t\t    |", Menu.red + SpecialNeeds.getAssistance() + Menu.reset);
        System.out.printf("\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t| Special Assistance: \t\t\t    |");
        System.out.printf("\n| Booking Number    : %-50s\t\t\t\t\t\t| %-40s\t    |", (Menu.blue + passenger.getBookingNo() + Menu.reset), (Menu.red + SpecialNeeds.getAssistance() + Menu.reset));
        System.out.println("\n=========================================================================================================================================================");

    }

}
