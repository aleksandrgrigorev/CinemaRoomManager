import java.util.Scanner;

public class Cinema {
    private static final int PRICE_FRONT = 10;
    private static final int PRICE_BACK = 8;
    private static final int MANY_SEATS = 60;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        String[][] cinema = initCinemaRoom(rows, seats);
        printCinemaRoom(cinema);

        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        int price = getPrice(rows, seats, row);
        System.out.println("Ticket price: $" + price);

        cinema[row][seat] = "B";
        printCinemaRoom(cinema);
    }

    private static int getPrice(int rows, int seats, int row) {
        int seatsTotal = rows * seats;
        if (seatsTotal <= MANY_SEATS) {
            return PRICE_FRONT;
        } else {
            if (row <= rows / 2) {
                return PRICE_FRONT;
            } else {
                return PRICE_BACK;
            }
        }
    }

    private static void printCinemaRoom(String[][] cinema) {
        System.out.println();
        System.out.println("Cinema:");
        for (String[] seatsStr : cinema) {
            for (String seat : seatsStr) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    private static String[][] initCinemaRoom(int rows, int seats) {
        String[][] cinema = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    cinema[i][j] = " ";
                    continue;
                }
                if (i == 0) {
                    cinema[i][j] = Integer.toString(j);
                    continue;
                }
                if (j == 0) {
                    cinema[i][j] = Integer.toString(i);
                    continue;
                }
                cinema[i][j] = "S";
            }
        }
        return cinema;
    }
}