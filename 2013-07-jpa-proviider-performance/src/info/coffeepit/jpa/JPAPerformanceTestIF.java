/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.jpa;

import info.coffeepit.jpa.entities.Foo;
import java.util.Collection;

/**
 *
 * @author Chris
 */
public interface JPAPerformanceTestIF {

    void countValues1();

    void countValues2();

    void deleteValues1();

    /**
     * Persistiert die Collection mit Foo-Objekten.
     * @param foos Collection mit Foo-Objekten
     */
    void insertData(Collection<Foo> foos);

    void selectFromDb1();

    /**
     * Aendert bei allen Foo-Objekten und den damit verknuepften Bar-Objekten die Werte
     * @param foos Collection mit Foo-Objekten, die geaendert werden sollen.
     */
    void updateValues(Collection<Foo> foos);
}
