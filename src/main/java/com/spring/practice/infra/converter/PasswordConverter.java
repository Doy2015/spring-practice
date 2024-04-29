package com.spring.practice.infra.converter;

import com.spring.practice.infra.utils.PasswordUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

	private static final String BCRYPT = "{bcrypt}";

	@Override
	public String convertToDatabaseColumn(String attribute) {
		if (StringUtils.isEmpty(attribute) || attribute.contains(BCRYPT)) {
			return attribute;
		}
		return PasswordUtil.encrypt(attribute);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dbData;
	}
}
