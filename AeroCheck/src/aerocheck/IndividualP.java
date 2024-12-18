package aerocheck;

import java.util.ArrayList;

public class IndividualP extends Passenger {

    public IndividualP(String bookingNo, String name, String iC, String phoneNo, 
            String email, String origin, String destination, String seatNo) {
        super(bookingNo, name, iC, phoneNo, email, origin, destination, seatNo);
    }
    // ArrayList to store individual data
    private static ArrayList<IndividualP> individualData = new ArrayList<>();

    // Getter method for individualData
    public static ArrayList<IndividualP> getIndividualData() {
        return individualData;
    }

    // Method to search for an individual passenger by booking number
    public static void searchIndividualBookNo(String inputBookNo) {
        for (IndividualP passenger : individualData) {
            if (passenger.getBookingNo().equals(inputBookNo)) {
                // Found a match, print all information
                System.out.println(Menu.blue + "\n********************************************************" + Menu.reset);
                System.out.println("\tBooking Number : " + passenger.getBookingNo());
                System.out.println("\tPassenger Name : " + passenger.getName());
                System.out.println("\tIC number      : " + passenger.getIC());
                System.out.println(Menu.blue + "********************************************************" + Menu.reset);
                SpecialNeeds.SpecialAssistance();
                BoardingPass.printBoardingPass(passenger);
                Email.sendBoardingPass(passenger);
                BaggageTags.baggageTag(passenger);
                return; // Exit the method after finding the match
            }
        }

    }

    // Method to add individual data
    static {
        individualData.add(new IndividualP("JTU789", "John Smith", "S1234567A", "0123456789", "john.smith@example.com", "Singapore", "London", "1A"));
        individualData.add(new IndividualP("MMM777", "Jane Doe", "F9876543B", "0987654321", "jane.doe@example.com", "New York", "Tokyo", "2B"));
        individualData.add(new IndividualP("ABC123", "Alice Johnson", "G5678901C", "0123456789", "alice.johnson@example.com", "Paris", "Sydney", "3C"));
        individualData.add(new IndividualP("XYZ456", "David Lee", "T2345678D", "0987654321", "david.lee@example.com", "Hong Kong", "Los Angeles", "4D"));
        individualData.add(new IndividualP("DEF789", "Emily Wong", "S6789012E", "0123456789", "emily.wong@example.com", "London", "Singapore", "5E"));
        individualData.add(new IndividualP("GHI123", "Michael Brown", "F3456789F", "0987654321", "michael.brown@example.com", "Tokyo", "New York", "6F"));
        individualData.add(new IndividualP("JKL456", "Sophia Taylor", "G7890123G", "0123456789", "sophia.taylor@example.com", "Sydney", "Paris", "7G"));
        individualData.add(new IndividualP("MNO789", "William Miller", "T4567890H", "0987654321", "william.miller@example.com", "Los Angeles", "Hong Kong", "8H"));
        individualData.add(new IndividualP("PQR123", "Olivia Davis", "S9012345I", "0123456789", "olivia.davis@example.com", "Singapore", "Bangkok", "9I"));
        individualData.add(new IndividualP("STU456", "James Wilson", "F1234567J", "0987654321", "james.wilson@example.com", "New York", "London", "10J"));

    }

    public static boolean validBookingNo(String inputBookNo) {
        for (IndividualP passenger : individualData) {
            if (passenger.getBookingNo().equals(inputBookNo)) {
                return true;
            }
        }
        return false;
    }

}
