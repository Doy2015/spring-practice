package com.spring.practice.infra.constants;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

@Schema(description = "에러 메시지", enumAsRef = true)
public enum ErrorMessage {
	INVALID_VALUE(HttpStatus.BAD_REQUEST, "잘못된 값입니다."),
	NOT_FOUND_DATA(HttpStatus.NOT_FOUND, "데이터를 찾을 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;

	ErrorMessage(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
