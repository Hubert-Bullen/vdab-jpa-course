package be.vdab.animals;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    protected Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }
}
