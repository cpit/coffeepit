package info.coffeepit.jpa;

import info.coffeepit.jpa.entities.Foo;
import java.util.Collection;

/**
 * Interface fuer den Performance-Test. Wird benoetigt fuer den dynamischen Proxy-Mechanismus, der die
 * Performance-Messung durchfuehrt.
 *
 * @author Chris
 */
public interface JPAPerformanceTestIF {

    void countValues1();

    void countValues2();

    void deleteAllValues();

    /**
     * Persistiert die Collection mit Foo-Objekten.
     *
     * @param foos Collection mit Foo-Objekten
     */
    void insertData(Collection<Foo> foos);

    /**
     * Select-Test 1
     */
    void selectFromDb1();

    /**
     * Aendert bei allen Foo-Objekten und den damit verknuepften Bar-Objekten die Werte.
     *
     * @param foos Collection mit Foo-Objekten, die geaendert werden sollen.
     */
    void updateValues1(Collection<Foo> foos);

    void updateValues2(Collection<Foo> foos);
}
