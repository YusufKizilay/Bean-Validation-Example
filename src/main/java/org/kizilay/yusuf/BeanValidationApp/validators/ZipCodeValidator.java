package org.kizilay.yusuf.BeanValidationApp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kizilay.yusuf.BeanValidationApp.constraints.ZipCodeConstraint;
import org.kizilay.yusuf.BeanValidationApp.qualifiers.USA;
import org.kizilay.yusuf.BeanValidationApp.service.ZipCodeChecker;

//Validator class must implement ConstraintValidator
public class ZipCodeValidator implements ConstraintValidator<ZipCodeConstraint, String> {

	@Inject
	@USA
	private ZipCodeChecker zipCodeChecker;

	private Pattern zipCodePattern = Pattern.compile("\\d{5}(-\\d{5})?");

	@Override
	public void initialize(ZipCodeConstraint constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null)
			return Boolean.TRUE;

		Matcher matcher = zipCodePattern.matcher(value);

		if (!matcher.matches())
			return Boolean.FALSE;

		return zipCodeChecker.isZipCodeValid();
	}

}
