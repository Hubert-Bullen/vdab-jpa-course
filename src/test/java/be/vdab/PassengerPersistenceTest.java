package be.vdab;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PassengerPersistenceTest extends AbstractPersistenceTest {
    /**
     * TODO: Possible problem: failing test depends on order of other methods (delete).
     */
    @Test
    public void testFindPassengers() throws Exception {
        List<Passenger> passengers = entityManager
                .createQuery("select p from Passenger p", Passenger.class)
                .getResultList();

        assertEquals("Buddy", passengers.get(0).getFirstName());
        assertEquals("Richie", passengers.get(1).getFirstName());
    }

    @Test
    public void testFindPassengerById() throws Exception {
        Passenger buddy = entityManager.find(Passenger.class, 1);
        assertEquals("Holly", buddy.getLastName());
        assertEquals(PassengerType.REGULAR, buddy.getType());
        assertEquals(32, buddy.getAge());
    }

    @Test
    public void passengersCanBeCreated() throws Exception {
        Passenger passenger = new Passenger("Jimi", "Hendrix", PassengerType.OCCASIONAL, new Date(), new byte[]{'d', 'a', 't', 'a'});
        entityManager.persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test
    public void passengersCanBeUpdated() throws Exception {
        Passenger passenger = entityManager.find(Passenger.class, 1);
        passenger.setFirstName("John");
    }

    @Test
    public void passengersAreNotUpdatedWhenDetached() throws Exception {
        Passenger p = entityManager.find(Passenger.class, 1);
        assertTrue(entityManager.contains(p));
        entityManager.detach(p);
        assertFalse(entityManager.contains(p));
        p.setFirstName("XXX");
        entityManager.flush();
    }

    @Test
    public void passengerCanBeDeleted() throws Exception {
        Passenger p = entityManager.getReference(Passenger.class, 2);
        entityManager.remove(p);
    }
}
