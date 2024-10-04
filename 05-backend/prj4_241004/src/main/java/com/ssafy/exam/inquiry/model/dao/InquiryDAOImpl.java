package com.ssafy.exam.inquiry.model.dao;

import com.ssafy.exam.inquiry.model.dto.Inquiry;
import com.ssafy.exam.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InquiryDAOImpl implements InquiryDAO {
	private DBUtil dbUtil = DBUtil.getInstance();

	// 고객 문의 생성 메서드
	@Override
	public void createInquiry(Inquiry inquiry) throws SQLException {
	    String query = "INSERT INTO Inquiry (member_id, title, message, status) VALUES (?, ?, ?, ?)";
	    try (Connection conn = dbUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setString(1, inquiry.getMemberId());
	        pstmt.setString(2, inquiry.getTitle());
	        pstmt.setString(3, inquiry.getMessage());
	        pstmt.setString(4, inquiry.getStatus());

	        // 로그 출력
	        System.out.println("문의 생성 쿼리 실행 준비: " + pstmt.toString());

	        // 쿼리 실행
	        int rowsInserted = pstmt.executeUpdate();
	        
	        // 로그 출력
	        System.out.println("쿼리 실행 후 생성된 행 수: " + rowsInserted);

	        if (rowsInserted > 0) {
	            System.out.println("문의가 성공적으로 생성되었습니다.");
	        } else {
	            System.out.println("문의 생성에 실패하였습니다.");
	        }
	    } catch (SQLException e) {
	        // 예외 로그 출력
	        System.out.println("문의 생성 중 SQL 예외 발생: " + e.getMessage());
	        throw e;  // 예외 재발생
	    }
	}



	// 모든 고객 문의 목록 조회 메서드
	@Override
	public List<Inquiry> getAllInquiries() throws SQLException {
		List<Inquiry> inquiryList = new ArrayList<>();
		String sql = "SELECT * FROM Inquiry";
		try (Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Inquiry inquiry = new Inquiry(rs.getInt("inquiry_id"), rs.getString("member_id"), rs.getString("title"),
						rs.getString("message"), rs.getTimestamp("created_at").toString(), rs.getString("status"));
				inquiryList.add(inquiry);
			}
		}
		return inquiryList;
	}

	// 특정 고객 문의 상세 조회 메서드
	@Override
	public Inquiry getInquiryById(int inquiryId) throws SQLException {
		String sql = "SELECT * FROM Inquiry WHERE inquiry_id = ?";
		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, inquiryId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Inquiry(rs.getInt("inquiry_id"), rs.getString("member_id"), rs.getString("title"),
							rs.getString("message"), rs.getTimestamp("created_at").toString(), rs.getString("status"));
				}
			}
		}
		return null;
	}

	// 고객 문의 삭제 메서드
	@Override
	public void deleteInquiry(int inquiryId) throws SQLException {
		String sql = "DELETE FROM Inquiry WHERE inquiry_id = ?";
		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, inquiryId);
			pstmt.executeUpdate();
		}
	}

	// 고객 문의 수정 메서드
	@Override
	public void updateInquiry(Inquiry inquiry) throws SQLException {
		String sql = "UPDATE Inquiry SET title = ?, message = ?, status = ? WHERE inquiry_id = ?";
		try (Connection conn = dbUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, inquiry.getTitle());
			pstmt.setString(2, inquiry.getMessage());
			pstmt.setString(3, inquiry.getStatus());
			pstmt.setInt(4, inquiry.getInquiryId());
			pstmt.executeUpdate();
		}
	}
}
