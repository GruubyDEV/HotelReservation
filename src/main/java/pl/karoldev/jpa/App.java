package pl.karoldev.jpa;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int chose;
        Reservation reservation = null;

        do {
            System.out.println("Welcome in Hotel!");
            System.out.println("1. Add reservation");
            System.out.println("2. Remove reservation");
            System.out.println("3. Show reservations");
            System.out.println("4. Exit");
            System.out.print("Chose: ");
            chose = scanner.nextInt();

            switch (chose) {
                case 1:
                    reservation = new Reservation();
                    break;
                case 2:
                    break;
                case 3:
                    reservation.showReservations();
                    break;
            }

        } while (chose != 4);
    }
}
