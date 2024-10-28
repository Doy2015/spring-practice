package com.spring.practice.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class MemberService {

	private final RestClient restClient;

	private void Sample() {

		restClient.get()
				.uri("http://localhost:8080/api/v1/members/{id}", 1)
				.retrieve()
				.toBodilessEntity();
	}
}
