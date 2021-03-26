import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {


        printSeatMap();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numSeats = s.nextInt();

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

    public static void printSeatMap() {
        int rows = 7;
        int seats = 8;
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        for (int i = 1; i < rows; i++) {
            String str = "S ";
            System.out.print(i + " ");
            System.out.println(str.repeat(seats));
        }
    }
}