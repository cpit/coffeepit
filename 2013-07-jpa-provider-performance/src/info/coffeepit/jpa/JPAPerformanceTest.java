/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.jpa;

import info.coffeepit.jpa.util.PerformanceInvocationHandler;
import info.coffeepit.jpa.util.DatenGenerator;
import info.coffeepit.jpa.entities.Bar;
import info.coffeepit.jpa.entities.Foo;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chris
 */
public class JPAPerformanceTest implements JPAPerformanceTestIF {

    private EntityManager entityManager;

    public JPAPerformanceTest(EntityManager em) {
        entityManager = em;
    }

    @Override
    public void insertData(Collection<Foo> foos) {
       entityManager.getTransaction().begin();
        for (Foo foo : foos) {
            entityManager.persist(foo);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void countValues1() {
    }

    @Override
    public void selectFromDb1() {
        TypedQuery<Foo> q = entityManager.createQuery("select f from Foo f where f.string1 = '1'", Foo.class);
        List <Foo> foos = q.getResultList();
        System.out.println("Anzahl Foos: "+foos.size());
    }

    @Override
    public void updateValues(Collection<Foo> foos) {
        entityManager.getTransaction().begin();
        for (Foo foo : foos) {
            entityManager.merge(foo);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void countValues2() {
    }

    @Override
    public void deleteValues1() {
    }

    public static void runPerformanceTest(String persistenceUnitName, int numberFoos, int numberBars) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        System.out.println("Persistence-Unit: " + persistenceUnitName);
        JPAPerformanceTestIF performanceTest = (JPAPerformanceTestIF) Proxy.newProxyInstance(JPAPerformanceTestIF.class.getClassLoader(),
                new Class<?>[]{JPAPerformanceTestIF.class},
                new PerformanceInvocationHandler(new JPAPerformanceTest(em), persistenceUnitName));
        DatenGenerator generator = new DatenGenerator();
        Collection<Foo> sampleData = generator.generateData(numberFoos, numberBars);
        performanceTest.insertData(sampleData);
        for (Foo foo : sampleData) {
            foo.setDecimal1(generator.generateBigDecimal());
            foo.setDecimal2(generator.generateBigDecimal());
            foo.setDecimal3(generator.generateBigDecimal());
            foo.setDecimal4(generator.generateBigDecimal());
            foo.setDecimal5(generator.generateBigDecimal());
            for (Bar bar : foo.getBars()) {
                bar.setNumber1(generator.generateBigDecimal());
                bar.setNumber2(generator.generateBigDecimal());
                bar.setNumber3(generator.generateBigDecimal());
                bar.setNumber4(generator.generateBigDecimal());
                bar.setNumber5(generator.generateBigDecimal());
            }
        }
        performanceTest.updateValues(sampleData);
        performanceTest.selectFromDb1();

    }

    public static void main(String... args) throws Exception {
        runPerformanceTest("openJPA-2.2.2",200,200);
        runPerformanceTest("eclipseLink-2.1",200,200);
        runPerformanceTest("openJPA-2.2.2",200,200);
         runPerformanceTest("eclipseLink-2.1",200,200);
    }
}
