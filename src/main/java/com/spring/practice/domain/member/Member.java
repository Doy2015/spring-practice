package com.spring.practice.domain.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.practice.infra.constants.RoleType;
import com.spring.practice.infra.converter.PasswordConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	@Comment("멤버 ID")
	private Long id;

	@Column(length = 50, nullable = false)
	@Comment("멤버 이름")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(length = RoleType.COLUMN_SIZE, nullable = false)
	@Comment("멤버 권한")
	private RoleType roleType;

	@Column(nullable = false)
	@Comment("멤버 이메일")
	private String email;

	@Column(nullable = false)
	@Comment("핸드폰")
	private String phone;

	@Column(nullable = false, length = 100)
	@Convert(converter = PasswordConverter.class)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Comment("비밀번호")
	private String password;

	static void testStringOld(String response) {
		switch (response) {
			case null -> { }
			case String s -> {
				if (s.equalsIgnoreCase("YES"))
					System.out.println("You got it");
				else if (s.equalsIgnoreCase("NO"))
					System.out.println("Shame");
				else
					System.out.println("Sorry?");
			}
		}
	}
}
