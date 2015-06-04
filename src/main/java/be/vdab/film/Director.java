package be.vdab.film;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Director {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    /**
     * Only used by JPA.
     */
    protected Director() {
    }

    public Director(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
