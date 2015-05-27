package be.vdab;

import javax.persistence.EntityManager;

public class Main {
    private static EntityManager em;













    public static void main(String[] args) {
        Passenger p = em.find(Passenger.class, 1);
        em.detach(p);
        someFunkyLogic(p);

        // p  exists with lastName="Blah"

        // db -> id 1 lastname="Holly"

        em.merge(p);

        em.refresh(p);

        em.getTransaction().commit();

    }

    private static void someFunkyLogic(Passenger p) {
        System.out.println("Funky stuff");
        p.setLastName("Blah");
    }
}
