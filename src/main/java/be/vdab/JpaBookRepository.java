package be.vdab;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaBookRepository implements BookRepository {
    private EntityManager entityManager;

    public JpaBookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAllBooks() {
        return entityManager.createQuery("select b from Book b").getResultList();
    }
}
