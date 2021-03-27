import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = s.nextInt();
        String[][] seatMap = new String[numRows][numSeats];
        seatMap = generateSeatMap(seatMap);

        int userInput = -1;
        boolean userContinue = true;

        while (userContinue) {
            userInput = printMenu();
            switch (userInput) {
                case 0:
                    userContinue = false;
                    break;
                case 1:
                    printSeatMap(seatMap);
                    break;
                case 2:
                    buyTicket(seatMap);
                    break;
                default:
                    continue;
            }
        }
    }

    public static String[][] generateSeatMap(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = "S";
            }
        }
        return array;
    }

    public static void printSeatMap(String[][] seatMap) {
        System.out.println("\nCinema:");
        System.out.print(" ");
        for (int i = 1; i <= seatMap[0].length; i++) {
            System.out.print(" " + i);
        }
        for (int i = 0; i < seatMap.length; i++) {
            System.out.println();
            System.out.print(i + 1 + " ");
            Arrays.stream(seatMap[i]).forEach(e -> System.out.print(e + " "));
        }
        System.out.println();
    }

    public static int printMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");
        return s.nextInt();
    }

    public static void buyTicket(String[][] array) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int seatRow = s.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = s.nextInt();
        System.out.println("Ticket price: $" + ticketPrice(array.length, array[0].length, seatRow));
        array[seatRow - 1][seatNumber - 1] = "B";
    }

    public static int ticketPrice(int numRows, int numSeats, int seatRow) {
        int totalSeats = numSeats * numRows;
        int numFrontRows = numRows / 2;
        int ticketPrice = 0;

        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            if (seatRow <= numFrontRows) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        return ticketPrice;
    }

//    public static void printTotalIncome(int numRows, int numSeats) {
//
//        int totalSeats = numSeats * numRows;
//        int numFrontRows = numRows / 2;
//        int numBackRows = numRows - numFrontRows;
//        int totalIncome = 0;
//
//        if (totalSeats <= 60) {
//            totalIncome = totalSeats * 10;
//        } else {
//            if (numRows % 2 == 0) {
//                totalIncome = (numFrontRows * numSeats) * 10 + (numFrontRows * numSeats) * 8;
//            } else {
//                totalIncome = (numFrontRows * numSeats) * 10 + (numBackRows * numSeats) * 8;
//            }
//        }
//        System.out.println("Total income:");
//        System.out.println("$" + totalIncome);
//    }
}

