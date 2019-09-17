package entities;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Tester {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Customer c1 = new Customer("Matias","Koefoed");
            c1.addHobby("Gaming");
            c1.addHobby("Movies");
            c1.addPhone("12345678","Home");
            c1.addPhone("12345678", "Work");
            em.persist(c1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
