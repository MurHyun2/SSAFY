package com.ssafy.exam.member.model.service;

import com.ssafy.exam.member.model.dto.Member;
import java.sql.SQLException;

public interface MemberService {
	void register(Member member) throws SQLException;

	Member login(String id, String password) throws SQLException;

	void deleteMember(String id) throws SQLException;
	
	void modifyMember(Member member) throws SQLException;
}
