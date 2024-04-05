package com.spring.practice.domain.member;

import com.spring.practice.infra.constants.RoleType;
import com.spring.practice.infra.utils.QueryDsl5RepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.spring.practice.domain.member.QMember.member;

public class MemberRepositorySupportImpl extends QueryDsl5RepositorySupport implements MemberRepositorySupport {
	public MemberRepositorySupportImpl() {
		super(Member.class);
	}

	@Override
	public Page<Member> findByRoleType(RoleType roleType, Pageable pageable) {
		return applyPagination(pageable,
				contentQuery -> contentQuery.select(member)
						.from(member)
						.where(member.roleType.eq(roleType))
				, countQuery -> countQuery.select(member.count())
						.from(member)
						.where(member.roleType.eq(roleType)));
	}
}
