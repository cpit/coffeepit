package info.coffeepit.jpa.util;

import info.coffeepit.jpa.entities.Bar;
import info.coffeepit.jpa.entities.Foo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generator zum Erzeugen von Testdaten.
 *
 * @author Chris
 */
public class DatenGenerator {

    /**
     * Ein Random-Objekt
     */
    public static final Random RANDOM = new Random();
    /**
     * Wertebereich der generierten Zahlen
     */
    public static final int MAXINT = 10;

    public DatenGenerator() {
    }

    /**
     * Erzeugt Testdaten
     *
     * @param numberFoos Anzahl an Foo-Objekten
     * @param numberBars Anzahl an Bar-Objekten, die jeweils in einem Foo-Objekt sind.
     * @return Collection mit Foo-Objekten
     */
    public List<Foo> generateFooObjects(int numberFoos, int numberBars) {
        List<Foo> foos = new ArrayList<>(numberFoos);
        for (int i = 0; i < numberFoos; i++) {
            Foo foo = new Foo("Dummy Text " + RANDOM.nextInt(MAXINT),
                    new BigDecimal(RANDOM.nextInt(MAXINT)));
            List<Bar> bars = generateBarObjects(foo, numberBars);
            foo.setBars(bars);
            foos.add(foo);
        }
        return foos;
    }

    /**
     * Erzeugt eine Collection mit Bar-Objekten.
     *
     * @param foo Zugehoriges Foo-Objekt
     * @param numberBars Anzahl an Bar-Objekten, die erzeugt werden.
     * @return Collection mit Bar-Objekten
     */
    private List<Bar> generateBarObjects(Foo foo, int numberBars) {
        List<Bar> bars = new ArrayList<>(numberBars);
        for (int i = 0; i < numberBars; i++) {
            Bar bar = new Bar(foo, "Dummy-Text " + RANDOM.nextInt(MAXINT),
                    new BigDecimal(RANDOM.nextInt(MAXINT)));
            bars.add(bar);
        }
        return bars;
    }
}
