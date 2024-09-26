package com.ssafy.exam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.exam.member.dto.Member;
import com.ssafy.exam.util.DBUtil;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertMember(Member member) throws SQLException {
		DBUtil dbUtill = DBUtil.getInstance();
		Connection conn = dbUtill.getConnection();
		String sql = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPw());
		int insertMember = pstmt.executeUpdate();
		
		if(insertMember > 0) {
			System.out.println("member Insert!");
		}
	}

	@Override
	public Member selectSignIn(Member member) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = dbUtil.getConnection();
		String sql = "SELECT * FROM member WHERE id = ? AND password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPw());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String password = rs.getString("password");
			
			Member mem = new Member();
			mem.setId(id);
			mem.setName(name);
			mem.setPw(password);
			
			return mem;
		}

		return null;
	}
}
