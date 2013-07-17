/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Chris
 */
public class VolljaehrigConstraintValidator implements ConstraintValidator<VolljaehrigConstraint, info.cpit.coffeepit.bv.entities.Person> {

    @Override
    public void initialize(VolljaehrigConstraint constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isValid(info.cpit.coffeepit.bv.entities.Person value, ConstraintValidatorContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}