package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)		// Helper class that contains business rules/ validation logic
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	public String value() default "KING";
	
	// define default error message
	public String message() default "must start with KING";
	
	// define default groups
	public Class<?>[] groups() default{};
	
	// define default payloads
	public Class<? extends Payload>[] payload() default{};
}
