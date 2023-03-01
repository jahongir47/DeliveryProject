package uz.jahongir.library.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquePermissionNameValidator.class)
public @interface UniqueRegionName {
    String message() default "Region name should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
