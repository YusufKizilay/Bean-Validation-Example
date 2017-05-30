package org.kizilay.yusuf.BeanValidationApp;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kizilay.yusuf.BeanValidationApp.model.Customer;

public class CustomerIntegrationTest {

	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeClass
	public static void init() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterClass
	public static void close() {
		validatorFactory.close();
	}

	@Test
	public void shouldRaiseNoConstraintViolation() {
		Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", null, null, null);

		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(0, violations.size());

	}

	@Test
	public void shouldRaiseNoConstraintViolationCauseInvalidEmail() {
		Customer customer = new Customer("John", "Smith", "dummyEmailF", null, null, null);

		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(1, violations.size());
		//assertEquals("invalid email address", violations.iterator().next().getMessage());
		assertEquals("dummy", violations.iterator().next().getInvalidValue());
		assertEquals("{org.kizilay.yusuf.BeanValidationApp.Email.message}",
				violations.iterator().next().getMessageTemplate());
	}

}
