package com.ssafy.exam.member.dao;

import java.sql.SQLException;

import com.ssafy.exam.member.dto.Member;

public interface MemberDAO {

	void insertMember(Member member) throws SQLException;

	Member selectSignIn(Member member) throws SQLException;

}