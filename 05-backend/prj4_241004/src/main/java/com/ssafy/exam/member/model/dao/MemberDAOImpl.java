package com.ssafy.exam.member.model.dao;

import com.ssafy.exam.member.model.dto.Member;
import com.ssafy.exam.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO {

	private DBUtil dbUtil = DBUtil.getInstance();

	@Override
	public void saveMember(Member member) throws SQLException {
		String sql = "INSERT INTO Member (id, password, name, nick_name, phone_num, addr_num, addr_basic, addr_detail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhoneNum());
			pstmt.setString(6, member.getAddrNum());
			pstmt.setString(7, member.getAddrBasic());
			pstmt.setString(8, member.getAddrDetail());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Member findMemberById(String id) throws SQLException {
		Member member = null;
		String sql = "SELECT * FROM Member WHERE id = ?";

		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"),
							rs.getString("nick_name"), rs.getString("phone_num"), rs.getString("addr_num"),
							rs.getString("addr_basic"), rs.getString("addr_detail"));
				}
			}
		}
		return member;
	}

	@Override
	public Member findMemberByIdAndPassword(String id, String password) throws SQLException {
		Member member = null;
		String sql = "SELECT * FROM Member WHERE id = ? AND password = ?";

		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					member = new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"),
							rs.getString("nick_name"), rs.getString("phone_num"), rs.getString("addr_num"),
							rs.getString("addr_basic"), rs.getString("addr_detail"));
				}
			}
		}
		return member;
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		String sql = "DELETE FROM Member WHERE id = ?";

		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected == 0) {
				System.out.println("No member found with the provided ID.");
			} else {
				System.out.println("Member deleted successfully.");
			}
		} catch (SQLException e) {
			System.err.println("Error during member deletion: " + e.getMessage());
			throw e; // Rethrow the exception to be handled by the caller
		}
		System.out.println("Deleting member with ID: " + id);
	}

	@Override
	public void updateMember(Member member) throws SQLException {
		String sql = "UPDATE Member SET name = ?, nick_name = ?, phone_num = ?, addr_num = ?, addr_basic = ?, addr_detail = ? WHERE id = ?";

		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getNickName());
			pstmt.setString(3, member.getPhoneNum());
			pstmt.setString(4, member.getAddrNum());
			pstmt.setString(5, member.getAddrBasic());
			pstmt.setString(6, member.getAddrDetail());
			pstmt.setString(7, member.getId());
			
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected == 0) {
				System.out.println("No member found with the provided ID.");
			} else {
				System.out.println("Member updateed successfully.");
			}
		} catch (SQLException e) {
			System.err.println("Error during member deletion: " + e.getMessage());
			throw e; // Rethrow the exception to be handled by the caller
		}
		System.out.println("Update member with ID: " + member.getId());
		
	}

}
