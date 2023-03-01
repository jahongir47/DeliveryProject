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
public @interface UniquePermissionName {
    String message() default "Permission name should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
