package com.ssafy.exam;

import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	private Map<String, Member> memberMap = new HashMap<>();
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public void insertMember(Member member) {
		memberMap.put(member.getId(), member);
		System.out.println(member);
	}

	public Member selectSignIn(Member member) {
		Member m = memberMap.get(member.getId());
		
		if (m != null && m.getPw().equals(member.getPw()))
			return m;

		return null;
	}
}
