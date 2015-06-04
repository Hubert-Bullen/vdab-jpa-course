package be.vdab.animals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Dog extends Animal {
    String trick;

    protected Dog() {
    }

    public Dog(String name, String trick) {
        super(name);
        this.trick = trick;
    }
}
