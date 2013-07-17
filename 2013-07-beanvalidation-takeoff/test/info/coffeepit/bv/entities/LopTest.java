/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.bv.entities;

import info.coffeepit.bv.entities.Lop;
import javax.validation.ValidationException;
import static junit.framework.TestCase.fail;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class LopTest extends EntitiesTestCase {

    public LopTest() {
    }

    @Test
    public void testNameFail() {
        String name = "X";
        Lop lop1 = new Lop();
        lop1.setName(name);
        
        try {
            getEntityManager().persist(lop1);
            System.out.println("Lop persisted: "+lop1);
        } catch (ValidationException validationException) {
            System.out.println("Validation ok: "+validationException);
            return;
        } 
        fail("Validation should fail but does not");
    }
    @Test
    public void testNameOK() {
        String name = "XXXX";
        Lop lop1 = new Lop();
        lop1.setName(name);
        try {
            getEntityManager().persist(lop1);
            System.out.println("Lop persisted: "+lop1);
        } catch (Exception exception) {
            fail("Persist failed: "+exception);
        } 
    }
}