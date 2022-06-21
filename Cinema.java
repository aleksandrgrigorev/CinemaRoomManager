import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        int priceUp60 = 10;
        int priceFront = priceUp60;
        int priceBack = 8;
        int seatsTotal = rows * seats;
        int incomeLess60 = seatsTotal * priceUp60;
        int rowsFront = 0;
        int rowsBack = 0;

        if (seatsTotal < 60) {
            System.out.println("Total income:");
            System.out.println("$" + incomeLess60);
        } else {
            if (rows % 2 == 1) {
                rowsFront = (rows-1)/2;
                rowsBack = (rows+1)/2;
            } else {
                rowsFront = rows / 2;
                rowsBack = rowsFront;
            }
            int incomeMore60 = (rowsFront * priceFront + rowsBack * priceBack) * seats;
            System.out.println("Total income:");
            System.out.println("$" + incomeMore60);
        }
    }
}