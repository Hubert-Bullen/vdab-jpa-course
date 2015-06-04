package be.vdab.animals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Cat extends Animal {
    private int numberOfLives;

    protected Cat() {
    }

    public Cat(String name, int numberOfLives) {
        super(name);
        this.numberOfLives = numberOfLives;
    }
}
