package be.vdab;

import be.vdab.animals.Animal;
import be.vdab.animals.Cat;
import be.vdab.animals.Dog;
import org.junit.Test;

public class AnimalTest extends AbstractPersistenceTest {
    @Test
    public void testAnimalsCanBePersistedInHierarcy() throws Exception {
        Animal a = new Cat("Missie", 8);
        entityManager.persist(a);

        Animal b = new Dog("Rocky", "bark");
        entityManager.persist(b);
    }
}
