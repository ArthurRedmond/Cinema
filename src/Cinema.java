import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = s.nextInt();
        System.out.println("");

        printSeatMap(numRows, numSeats);
        System.out.println("");

        System.out.println("Enter a row number:");
        int seatRow = s.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = s.nextInt();

        System.out.println("\nTicket price: $" + ticketPrice(numRows, numSeats, seatRow));
        printSeatMap(numRows, numSeats, seatRow, seatNumber);
    }

    public static void printSeatMap(int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 1; i <= rows; i++) {
            String str = "S ";
            System.out.print(i + " ");
            System.out.println(str.repeat(seats));
        }
    }

    public static void printSeatMap(int rows, int seats, int seatRow, int seatNumber) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 1; i <= rows; i++) {
            String str = "S ";
            if (i == seatRow) {
                System.out.print(i + " ");
                System.out.println(str.repeat(seatNumber - 1) + "B " + str.repeat(seats - seatNumber));
            } else {
                System.out.print(i + " ");
                System.out.println(str.repeat(seats));
            }
        }
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

    public static void printTotalIncome(int numRows, int numSeats) {

        int totalSeats = numSeats * numRows;
        int numFrontRows = numRows / 2;
        int numBackRows = numRows - numFrontRows;
        int totalIncome = 0;

        if (totalSeats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            if (numRows % 2 == 0) {
                totalIncome = (numFrontRows * numSeats) * 10 + (numFrontRows * numSeats) * 8;
            } else {
                totalIncome = (numFrontRows * numSeats) * 10 + (numBackRows * numSeats) * 8;
            }
        }
        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
    }
}

