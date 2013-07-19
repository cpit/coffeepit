
package info.coffeepit.jpa.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy-Handler zum Messen der Performance
 * @author Chris
 */
public class PerformanceInvocationHandler implements InvocationHandler {

    /**
     * Die Implementierungsklasse, dei gewrappt werden soll.
     */
    private Object impl;
    /**
     * Name des Proxy-Handlers 8zwecks Ausgabe)
     */
    private String name;
    /**
     * Konstruktor.
     * @param impl Implementierung, die gewrappt wird.
     * @param name Name des Handlers, zwecks Log-Ausgabe.
     */
    public PerformanceInvocationHandler(Object impl, String name) {
        this.impl = impl;
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(impl, args);
        System.out.println(name + ", Method " + method.getName() + ": " + (System.currentTimeMillis() - start) + " ms");
        return result;
    }
}
