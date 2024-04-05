package com.spring.practice.domain.member;

import com.spring.practice.infra.constants.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositorySupport {

	Page<Member> findByRoleType(RoleType roleType, Pageable pageable);
}
