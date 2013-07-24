package info.coffeepit.jpa;

import info.coffeepit.jpa.util.PerformanceInvocationHandler;
import info.coffeepit.jpa.util.DatenGenerator;
import info.coffeepit.jpa.entities.Bar;
import info.coffeepit.jpa.entities.Foo;
import static info.coffeepit.jpa.util.DatenGenerator.MAXINT;
import static info.coffeepit.jpa.util.DatenGenerator.RANDOM;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Chris
 */
public class JPAPerformanceTest implements JPAPerformanceTestIF {

    private static final int NUMBER_FOO_INSTANCES = 500;
    private static final int NUMBER_BAR_INSTANCES = 500;
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
        TypedQuery<Foo> q = entityManager.createQuery("select f from Foo f where f.someText like '%8%'", Foo.class);
        List<Foo> foos = q.getResultList();
        System.out.println("Anzahl Foos: " + foos.size());
    }

    @Override
    public void updateValues1(Collection<Foo> foos) {
        entityManager.getTransaction().begin();
        for (Foo foo : foos) {
            entityManager.merge(foo);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateValues2(Collection<Foo> foos) {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("UPDATE Foo f SET f.someDecimalNumber = :newNumber WHERE f.someDecimalNumber = :oldNumber");
        q.setParameter("oldNumber", new BigDecimal(6));
        q.setParameter("newNumber", new BigDecimal(666));
        System.out.println("Updated: " + q.executeUpdate() + " items");
        entityManager.getTransaction().commit();
    }

    private void countAll() {
        Query queryFoo = entityManager.createNativeQuery("select count(*) from Foo");
        Query queryBar = entityManager.createNativeQuery("select count(*) from Bar");
        System.out.println("Anzahl Foo-Objekte in DB: " + queryFoo.getSingleResult() + ", Bar-Objekte: " + queryBar.getSingleResult());
    }

    @Override
    public void countValues2() {
    }

    @Override
    public void deleteAllValues() {
        countAll();
        entityManager.getTransaction().begin();
        Query q1 = entityManager.createQuery("select f from Foo f");
        Query q2 = entityManager.createQuery("DELETE FROM Foo f WHERE f.someText like '%'");
        System.out.println("Delete from Foo: " + q2.executeUpdate() + " items");
        entityManager.getTransaction().commit();
        countAll();
    }

    public static void runPerformanceTest(String persistenceUnitName, int numberFoos, int numberBars) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = emf.createEntityManager();
        System.out.println("Persistence-Unit: " + persistenceUnitName);
        JPAPerformanceTestIF performanceTest = (JPAPerformanceTestIF) Proxy.newProxyInstance(JPAPerformanceTestIF.class
                .getClassLoader(), new Class<?>[]{JPAPerformanceTestIF.class},
                new PerformanceInvocationHandler(
                new JPAPerformanceTest(em), persistenceUnitName));
        DatenGenerator generator = new DatenGenerator();
        Collection<Foo> sampleData = generator.generateFooObjects(numberFoos, numberBars);
        performanceTest.deleteAllValues();
        performanceTest.insertData(sampleData);
        for (Foo foo : sampleData) {
            foo.setSomeText("A new dummy Text (" + DatenGenerator.RANDOM.nextInt(DatenGenerator.MAXINT) + ")");
            foo.setSomeDecimalNumber(new BigDecimal(RANDOM.nextInt(MAXINT)));
            for (Bar bar : foo.getBars()) {
                bar.setSomeText("A new dummy Text (" + DatenGenerator.RANDOM.nextInt(DatenGenerator.MAXINT) + ")");
                bar.setSomeNumber(new BigDecimal(RANDOM.nextInt(MAXINT)));
            }
        }
        performanceTest.updateValues1(sampleData);
        performanceTest.updateValues2(sampleData);
        performanceTest.selectFromDb1();
    }

    public static void main(String... args) throws Exception {
        //runPerformanceTest("openJPA-2.2.2", NUMBER_FOO_INSTANCES, NUMBER_BAR_INSTANCES);
        //runPerformanceTest("eclipseLink-2.1", NUMBER_FOO_INSTANCES, NUMBER_BAR_INSTANCES);
        runPerformanceTest("hibernate-4", NUMBER_FOO_INSTANCES, NUMBER_BAR_INSTANCES);
    }
}
