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
    private static final Random random = new Random();
    /**
     * Wertebereich der generierten Zahlen
     */
    private static final int maxInt = 10;

    public DatenGenerator() {
    }

    /**
     * Erzeugt Testdaten
     *
     * @param numberFoos Anzahl an Foo-Objekten
     * @param numberBars Anzahl an Bar-Objekten, die jeweils in einem Foo-Objekt sind.
     * @return Collection mit Foo-Objekten
     */
    public List<Foo> generateData(int numberFoos, int numberBars) {
        List<Foo> foos = new ArrayList<>(numberBars);
        for (int i = 0; i < numberFoos; i++) {
            Foo foo = new Foo("A dummy text: " + generateBigDecimal().toString(),
                    generateBigDecimal());
            List<Bar> bars = generateBars(foo, numberBars);
            foo.setBars(bars);
            foos.add(foo);
        }
        return foos;
    }

    /**
     * Erzeugt eine zufaellige BigDecimal-Zahl.
     *
     * @return
     */
    public BigDecimal generateBigDecimal() {
        return new BigDecimal(random.nextInt(maxInt));
    }

    /**
     * Erzeugt eine Collection mit Bar-Objekten.
     *
     * @param foo Zugehoriges Foo-Objekt
     * @param numberBars Anzahl an Bar-Objekten, die erzeugt werden.
     * @return Collection mit Bar-Objekten
     */
    private List<Bar> generateBars(Foo foo, int numberBars) {
        List<Bar> bars = new ArrayList<>(numberBars);
        for (int i = 0; i < numberBars; i++) {
            Bar bar = new Bar(foo, "Ein Dummy-Text: " + generateBigDecimal().toString(),
                    generateBigDecimal());
            bars.add(bar);
        }
        return bars;
    }
}
