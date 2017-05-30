package org.kizilay.yusuf.BeanValidationApp.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.kizilay.yusuf.BeanValidationApp.validators.ZipCodeValidator;

@Constraint(validatedBy = ZipCodeValidator.class) // ZipCodeConstraint is more
													// complex then
													// EmailConstraint so use
													// ZipCodeValidator for
													// check zip code is valid
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCodeConstraint {

	String message() default "{org.kizilay.yusuf.BeanValidationApp.ZipCode.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	// For multiple constraint for the same target, like multiple regex
	// constraint for same property
	@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		ZipCodeConstraint[] value();
	}

}
