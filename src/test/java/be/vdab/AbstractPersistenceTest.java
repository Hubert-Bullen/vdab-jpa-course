package be.vdab;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by KVRRQ70 on 26/05/2015.
 */
public abstract class AbstractPersistenceTest {
    private static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeClass
    public static void initializeEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Books");
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        entityManagerFactory.close();
    }

    @Before
    public void initializeEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void destroyEntityManager() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
