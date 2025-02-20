package com.handsonproblems.validemail;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

public class EmailValidator {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static boolean validateUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (violations.isEmpty()) {
            System.out.println(" Valid email: " + user.getEmail());
            return true;
        } else {
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(" Invalid email: " + user.getEmail() + " | Error: " + violation.getMessage());
            }
            return false;
        }
    }
}

