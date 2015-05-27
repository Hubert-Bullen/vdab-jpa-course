package be.vdab;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PassengerPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void testFindPassengers() throws Exception {
        List<Passenger> passengers = entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
        assertEquals("Buddy", passengers.get(0).getFirstName());
        assertEquals("Richie", passengers.get(1).getFirstName());
    }

    @Test
    public void testFindPassenger() throws Exception {
        Passenger buddy = entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList().get(0);
        assertEquals("Holly", buddy.getLastName());
        assertEquals(PassengerType.REGULAR, buddy.getType());
        assertEquals(32, buddy.getAge());
    }
}
