package org.kizilay.yusuf.BeanValidationApp.service.impl;

import org.kizilay.yusuf.BeanValidationApp.qualifiers.USA;
import org.kizilay.yusuf.BeanValidationApp.service.ZipCodeChecker;

@USA
public class ZipCodeCheckerImplForUsa implements ZipCodeChecker {

	@Override
	public Boolean isZipCodeValid() {
		return Boolean.TRUE;
	}

}
