/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;
import org.junit.Before;
 
/**
 *
 * @author Chris
 */
public class EntitiesTestCase extends TestCase {
    
    private EntityManagerFactory emf;
    private EntityManager entityManager;
    
    public EntitiesTestCase () {
       
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
    @Before
    @Override
    public void setUp() {
        setEmf(Persistence.createEntityManagerFactory("beanvalidationPU-EclipseLink-Standalone"));
        setEntityManager(emf.createEntityManager());
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
}
