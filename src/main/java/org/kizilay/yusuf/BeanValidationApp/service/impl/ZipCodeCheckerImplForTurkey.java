package org.kizilay.yusuf.BeanValidationApp.service.impl;

import org.kizilay.yusuf.BeanValidationApp.qualifiers.TURKEY;
import org.kizilay.yusuf.BeanValidationApp.service.ZipCodeChecker;

@TURKEY
public class ZipCodeCheckerImplForTurkey implements ZipCodeChecker {

	@Override
	public Boolean isZipCodeValid() {
		return Boolean.FALSE;
	}

}
