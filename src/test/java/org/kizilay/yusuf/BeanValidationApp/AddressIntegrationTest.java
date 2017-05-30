package org.kizilay.yusuf.BeanValidationApp;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.kizilay.yusuf.BeanValidationApp.model.Address;

public class AddressIntegrationTest {

	@Test
	public void shouldRaiseNoConstraintViolationCauseInvalidZipCode() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Address address = new Address("233 Spring Street", null, "New York", "NY", "Dummy Zip Code", "USA");

		Set<ConstraintViolation<Address>> violations = validator.validate(address);
		assertEquals(1, violations.size());
	}

}
