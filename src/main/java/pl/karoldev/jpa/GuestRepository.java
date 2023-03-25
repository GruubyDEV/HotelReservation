package pl.karoldev.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class GuestRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
    private static EntityManager em = factory.createEntityManager();

    public void createNewGuest(String name, int age) {
        System.out.println("------- CREATE --------");
        Guest newOne = new Guest(name, age);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        System.out.println("------- PERSISTING IN NEW TRANSACTION -----------");
        em.persist(newOne);
        System.out.println(" NewGuestID: " + newOne.getId());
        System.out.println("------- CLOSING TRANSACTION -------");
        transaction.commit();
    }

    public Guest findById(long id) {
        System.out.println("------- FIND BY ID -------");
        return em.find(Guest.class, id);
    }

    public void updateAge(Guest guest, int newAge) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("------ BEGIN -------");
        transaction.begin();
        guest.setAge(newAge);
        transaction.commit();
        System.out.println("------ CLOSING TRANSACTION -------");
    }

    public void remove(Guest guest) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("--------- BEGIN ----------");
        transaction.begin();
        em.remove(guest);
        transaction.commit();
        System.out.println("-------- CLOSING TRANSACTION --------");
    }
}
