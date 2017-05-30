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
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Size(min = 7)
@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
		+ "@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")

@ReportAsSingleViolation // use one message for all kind of violation (when size
							// or pattern violation use same message )
@Constraint(validatedBy = {}) // use to define own constraint, not built-in

@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {

	String message() default "{org.kizilay.yusuf.BeanValidationApp.Email.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	// For multiple constraint for the same target, like multiple regex
	// constraint for same property
	@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		EmailConstraint[] value();
	}
}
