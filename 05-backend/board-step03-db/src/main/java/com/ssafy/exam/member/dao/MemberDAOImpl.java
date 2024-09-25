package com.ssafy.exam.member.dao;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.exam.member.dto.Member;

public class MemberDAOImpl implements MemberDAO {
	private Map<String, Member> memberMap = new HashMap<>();
	private static MemberDAOImpl instance = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertMember(Member member) {
		memberMap.put(member.getId(), member);
		System.out.println(member);
	}

	@Override
	public Member selectSignIn(Member member) {
		Member m = memberMap.get(member.getId());
		
		if (m != null && m.getPw().equals(member.getPw()))
			return m;

		return null;
	}
}
