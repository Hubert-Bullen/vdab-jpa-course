package be.vdab;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void findAllBooks() throws Exception {
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());
    }

    @Test
    public void findAllBooksReturnsExactlyThreeBooks() {
        List<Book> books  = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        assertEquals(3, books.size());
    }
}
