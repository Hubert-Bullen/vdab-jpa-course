package be.vdab;

import be.vdab.film.Actor;
import static org.junit.Assert.*;

import be.vdab.film.Film;
import be.vdab.film.Gender;
import be.vdab.film.Genre;
import org.junit.Test;

import java.util.List;

public class FilmPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void actorFullName() throws Exception {
        assertEquals("Brad Pitt", new Actor("Brad", "Pitt", Gender.male).fullName());
    }

    @Test
    public void actorCanBeSaved() throws Exception {
        Actor clint = new Actor("Clint", "Eastwood", Gender.male);
        entityManager.persist(clint);
        assertNotNull(clint);
    }

    @Test
    public void filmCanBeSaved() throws Exception {
        Film film = new Film("Legends Of The Fall", 133, Genre.drama);
        entityManager.persist(film);
        assertNotNull(film);
    }

    @Test
    public void filmAndActorCanBeAssociated() throws Exception {
        prepare();

        System.out.println("-----------------------");
        Film film = entityManager.find(Film.class, 1);
        System.out.println("-----------------------");
        List<Actor> list = film.getActors();
        System.out.println(list.getClass().getName());
        System.out.println("-----------------------");

        for (Actor actor : list) {
            System.out.println(actor.getFirstName());
        }

    }

    private void prepare() {
        Film film = new Film("Legends Of The Fall", 133, Genre.drama);
        Actor anthony = new Actor("Anthony", "Hopkins", Gender.male);
        Actor julia = new Actor("Julia", "Ormond", Gender.female);

        entityManager.persist(film);
        entityManager.persist(anthony);
        entityManager.persist(julia);

        film.addActor(anthony);
        film.addActor(julia);

        entityManager.flush();
        entityManager.clear();
    }
}
