package be.vdab.film;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private int length;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    private Director director;

    /**
     * Only used by JPA.
     */
    protected Film() {
    }

    public Film(String title, int length, Genre genre) {
        this.title = title;
        this.length = length;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Adds an actor and syncs this on the inverse side.
     * @param a The actor to add.
     * TODO: maybe also add removeActor(Actor a)
     */
    public void addActor(Actor a) {
        this.actors.add(a);
        a.films.add(this);
    }

    /**
     * Sometimes we can protect this list from modifications, so the
     * client can not add items through this getter.
     * Only works because hibernate doesn't use this getter. It's using field based access.
     * @return The list of actors, protected against modifications.
     * @see #addActor(Actor) adding actors
     */
    public List<Actor> getActors() {
        return Collections.unmodifiableList(actors);
    }
}
