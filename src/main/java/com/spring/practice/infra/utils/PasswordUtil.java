package com.spring.practice.infra.utils;

import com.spring.practice.infra.constants.ErrorMessage;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

@UtilityClass
public class PasswordUtil {

	private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	public String encrypt(String password) {
		Assert.notNull(password, ErrorMessage.INVALID_VALUE.name());
		return passwordEncoder.encode(password);
	}

	public boolean match(String inputPassword, String encodePassword) {
		Assert.notNull(inputPassword, ErrorMessage.INVALID_VALUE.name());
		Assert.notNull(encodePassword, ErrorMessage.INVALID_VALUE.name());
		return passwordEncoder.matches(inputPassword, encodePassword);
	}
}
