/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv.entities;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class ValidatorTest extends EntitiesTestCase{
    
    @Test
    public void testSimpleValidation () {
        
        Lop lop = new Lop();
        lop.setName("X");
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Lop>> violations = validator.validate(lop);
        
        assertEquals(1, violations.size());
        
        for (ConstraintViolation violation : violations) {
            System.out.println("Violation: "+violation);
        }
    }
    
}
