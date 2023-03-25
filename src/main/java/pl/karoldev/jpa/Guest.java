package pl.karoldev.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nanme;
    private int age;


    public Guest(String nanme, int age) {
        this.nanme = nanme;
        this.age = age;
    }

    public long getId() {
        return this.id;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }
}
