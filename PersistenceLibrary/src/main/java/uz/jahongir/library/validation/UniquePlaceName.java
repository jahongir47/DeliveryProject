package uz.jahongir.library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePlaceNameValidator.class)
public @interface UniquePlaceName {
    String message() default "Place name should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
