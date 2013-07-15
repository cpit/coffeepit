/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit.info.lop.entities;

import info.cpit.lop.entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class PersonTest extends TestCase {

    EntityManagerFactory emf;
    EntityManager em;

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("lop-PU-Standalone");
        em = emf.createEntityManager();
    }

    @After
    @Override
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testSetName() {
        int anzahlPersonen = count();
        System.out.println("Anzahl Personen in DB: " + anzahlPersonen);
        Person person = new Person();
        person.setName("Hugo Himbeer");
        Person person2 = new Person();
        person2.setName("Toni Tomate");
        assertEquals("Nachname falsch", "Himbeer", person.getNachname());
        assertEquals("Vorname falsch", "Hugo", person.getVorname());
        em.getTransaction().begin();
        em.persist(person);
        em.persist(person2);
        em.getTransaction().commit();
        System.out.println("Anzahl Personen in DB: " + count());
        assertEquals("Keine Person in DB eingefuegt", anzahlPersonen+2, count());
        System.out.println("Person Nr. 2 eingefuegt: "+person2);
        System.out.println("Person eingefuegt: "+person);
        

    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Person> rt = cq.from(Person.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}