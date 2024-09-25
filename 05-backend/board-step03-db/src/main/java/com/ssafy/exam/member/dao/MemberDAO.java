package com.ssafy.exam.member.dao;

import com.ssafy.exam.member.dto.Member;

public interface MemberDAO {

	void insertMember(Member member);

	Member selectSignIn(Member member);

}