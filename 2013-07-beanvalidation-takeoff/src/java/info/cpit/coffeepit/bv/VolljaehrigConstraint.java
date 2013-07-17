/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Chris
 */
@Documented
@Constraint(validatedBy = VolljaehrigConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VolljaehrigConstraint {

    String message() default "{info.cpit.coffeepit.bv.VolljaehrigConstraint}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}