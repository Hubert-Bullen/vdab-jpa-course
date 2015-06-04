package be.vdab;

import be.vdab.film.Actor;
import be.vdab.film.statistics.AverageActorAgePerDirector;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.TypedQuery;
import java.util.List;

public class QueryDemoTest extends AbstractPersistenceTest {
    @Test
    public void simpleQuery() throws Exception {
        TypedQuery<Actor> query = entityManager.createNamedQuery("Actors by Film id", Actor.class);
        query.setParameter("fid", 1);
        List<Actor> actors = query.getResultList();
        assertEquals(2, actors.size());
        assertEquals("Anthony", actors.get(0).getFirstName());
        assertEquals("Brad", actors.get(1).getFirstName());
    }

    @Test
    public void harderQuery() throws Exception {
        TypedQuery<AverageActorAgePerDirector> query = entityManager.createQuery("select new be.vdab.film.statistics.AverageActorAgePerDirector(f.director.name, avg(a.age)) from Film f join f.actors a", AverageActorAgePerDirector.class);
        List<AverageActorAgePerDirector> statistics = query.getResultList();
        for (AverageActorAgePerDirector statistic : statistics) {
            System.out.println(statistic);
        }
        assertEquals(56, (int)statistics.get(0).getAverageAge());
        assertEquals("Edward Zwick", statistics.get(0).getDirectorName());
    }
}
