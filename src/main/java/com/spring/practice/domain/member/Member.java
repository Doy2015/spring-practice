package com.spring.practice.domain.member;

import com.spring.practice.infra.constants.RoleType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(length = 50)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(length = RoleType.COLUMN_SIZE)
	private RoleType roleType;
}
