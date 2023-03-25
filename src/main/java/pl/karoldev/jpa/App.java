package pl.karoldev.jpa;

public class App {

    public static void main(String[] args) {
        GuestRepository repo = new GuestRepository();
        repo.createNewGuest("Pawel", 34);
        Guest guest = repo.findById(1l);
        System.out.println(guest.getId());
        repo.updateAge(guest, 45);
        repo.remove(guest);
    }
}
