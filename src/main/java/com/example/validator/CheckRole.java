package com.example.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, ANNOTATION_TYPE, METHOD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
public @interface CheckRole {

    String message() default "{org.hibernate.validator.CheckRole.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
