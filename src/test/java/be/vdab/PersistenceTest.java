package be.vdab;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersistenceTest {
    @Test
    public void findAllBooks() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());
        assertEquals("Uncle Tom's Cabin", books.get(1).getTitle());
        assertEquals("Moby Dick or The Whale", books.get(2).getTitle());

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
