package aerocheck;

import java.util.ArrayList;

public class GroupP extends Passenger {

    static GroupP matchedPassenger = null;

    // ArrayList to store group data
    private static ArrayList<GroupP> groupData = new ArrayList<>();

    public GroupP(String bookingNo, String name, String iC, String phoneNo, String email, String origin, String destination, String seatNo) {
        super(bookingNo, name, iC, phoneNo, email, origin, destination, seatNo);
    }

    // Getter method for GroupData
    public static ArrayList<GroupP> getGroupData() {
        return groupData;
    }

    // Method to search for a group passenger by booking number
    public static void searchGroupBookNo(String inputBookNo) {

        for (GroupP group : groupData) {
            if (group.getBookingNo().equals(inputBookNo)) {
                matchedPassenger = group;
                // Found a match for the booking number, print boarding pass
                System.out.println(Menu.blue + "\n********************************************************" + Menu.reset);
                System.out.println("\tBooking Number : " + group.getBookingNo());
                System.out.println("\tPassenger Name : " + group.getName());
                System.out.println("\tIC number      : " + group.getIC());
                System.out.println(Menu.blue + "********************************************************" + Menu.reset);
                SpecialNeeds.SpecialAssistance();
                Email.sendBoardingPass(matchedPassenger);
                BoardingPass.printBoardingPass(group);
            }

        }
        if (matchedPassenger != null) {
            BaggageTags.baggageTag(matchedPassenger);
        }
    }

    static {
        // Sample data for group 1
        ArrayList<GroupP> group1 = new ArrayList<>();
        group1.add(new GroupP("BKU9805", "Alice", "05012345028765", "0126748793", "alice@gmail.com", "Kuala Lumpur", "Miri", "1A"));
        group1.add(new GroupP("BKU9805", "Jane", "061209024578", "0184563728", "jane@gmail.com", "Kuala Lumpur", "Miri", "1C"));
        group1.add(new GroupP("BKU9805", "Emerlyn", "030412029875", "01128907834", "emerlyn@gmail.com", "Kuala Lumpur", "Miri", "4C"));
        group1.add(new GroupP("BKU9805", "Fienn", "030617027833", "0126453876", "fienn@gmail.com", "Kuala Lumpur", "Miri", "7D"));
        group1.add(new GroupP("BKU9805", "Esther", "090225026743", "0172356647", "esther@gmail.com", "Kuala Lumpur", "Miri", "10A"));

        // Sample data for group 2
        ArrayList<GroupP> group2 = new ArrayList<>();
        group2.add(new GroupP("DUN2345", "Jason", "991022027833", "01123428876", "jason@gmail.com", "Penang", "Kuala Lumpur", "5A"));
        group2.add(new GroupP("DUN2345", "Mel", "001220025784", "0128759384", "mel@gmail.com", "Penang", "Kuala Lumpur", "5B"));
        group2.add(new GroupP("DUN2345", "Evelyn", "040123028978", "0122893472", "evelyn@gmail.com", "Penang", "Kuala Lumpur", "8C"));
        group2.add(new GroupP("DUN2345", "Fion", "050418026574", "0182934758", "fion@gmail.com", "Penang", "Kuala Lumpur", "3A"));
        group2.add(new GroupP("DUN2345", "Issac", "060123028739", "01123768877", "issac@gmail.com", "Penang", "Kuala Lumpur", "6C"));

        // Add group data to the main ArrayList
        groupData.addAll(group1);
        groupData.addAll(group2);
    }

    public static boolean validBookingNo(String inputBookNo) {
        for (GroupP passenger : groupData) {
            if (passenger.getBookingNo().equals(inputBookNo)) {
                return true;
            }
        }
        return false;
    }
}
