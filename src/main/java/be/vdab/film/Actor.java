package be.vdab.film;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Actors by Film id", query = "select a from Film f join f.actors a where f.id = :fid order by a.firstName, a.lastName")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    /**
     * Made this "default" (aka "friendly" or "package protected") scope so the
     * inverse relationship can take care of keeping this in sync.
     * Other (better?) ways exist.
     */
    @ManyToMany(mappedBy = "actors")
    List<Film> films = new ArrayList<>();

    /**
     * Only used by JPA.
     */
    protected Actor() {
    }

    public Actor(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public List<Film> getFilms() {
        return films;
    }
}
