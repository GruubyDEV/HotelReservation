package pl.karoldev.jpa;

import jakarta.persistence.*;

import java.util.Scanner;

public class Reservation extends Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    int roomNumber;
    Guest guest;

    final private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
    final private static EntityManager em = factory.createEntityManager();

    public Reservation() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;

        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Age: ");
        age = scanner.nextInt();
        System.out.print("Room number: ");
        this.roomNumber = scanner.nextInt();

        this.guest = new Guest(name, age);

        addReservation(guest, roomNumber);

    }

    private void addReservation(Guest guest, int roomNumber) {
        EntityTransaction transaction = em.getTransaction();


        //STARTING TRANSACTION
        transaction.begin();
        //PERSISTING IN NEW TRANSACTION
        em.persist(this.guest);
        //CLOSING TRANSACTION
        transaction.commit();

        System.out.println("Guest " + guest.toString() + " are added to reservation " + roomNumber);
    }

    public void showReservations() {
        int i = 1;

        while (em.find(this.guest.getClass(), i) != null) {
            System.out.println(em.find(this.guest.getClass(), i));
            i++;
        }
    }
    public void removeReservations() {
        //
    }

}
