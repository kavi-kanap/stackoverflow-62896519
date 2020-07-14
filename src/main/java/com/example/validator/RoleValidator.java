package com.example.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<CheckRole, String> {

    private final MyTableRepository repository;

    public RoleValidator(MyTableRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(CheckRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("ROLE_ROOT")){
            System.out.println("~~~~~~validation check");
            return (repository.count("ROLE_ROOT") > 0);
            //Following code will cause infinite recursion
            //return (repository.findByRole("ROLE_ROOT").size() > 0);
        }
        else {
            return true;
        }
    }

}
