package be.vdab;

import be.vdab.film.Actor;
import static org.junit.Assert.*;

import be.vdab.film.Film;
import be.vdab.film.Gender;
import be.vdab.film.Genre;
import org.junit.Test;

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
}
