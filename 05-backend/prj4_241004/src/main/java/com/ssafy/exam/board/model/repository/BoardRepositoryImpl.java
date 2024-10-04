package com.ssafy.exam.board.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;

public class BoardRepositoryImpl implements BoardRepository {

	private static BoardRepository repo = new BoardRepositoryImpl();

	private BoardRepositoryImpl() {
	}

	public static BoardRepository getInstance() {
		return repo;
	}

	@Override
	public List<Board> selectAllBoards() throws SQLException {
		List<Board> list = new ArrayList<>();

		DBUtil dbUtill = DBUtil.getInstance();
		String sql = "SELECT video_no, video_URL, video_title, category, part, channel_name FROM video";

		try (Connection conn = dbUtill.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
				Board board = new Board();
	            board.setVideoNo(rs.getInt("video_no"));
	            board.setVideoURL(rs.getString("video_URL"));
	            board.setVideoTitle(rs.getString("video_title"));
	            board.setCategory(rs.getString("category"));
	            board.setPart(rs.getString("part"));
	            board.setChannelName(rs.getString("channel_name"));

				list.add(board);
			}
		} catch (SQLException e) {
	        e.printStackTrace();
	    }

		return list;
	}

	@Override
	public Board selectBoardByNo(int videoNo) {
	    Board board = new Board();

	    DBUtil dbUtill = DBUtil.getInstance();
	    String sql = "SELECT video_no, video_URL, video_title, category, part, channel_name FROM video WHERE video_no = ?";

	    try (Connection conn = dbUtill.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        // 파라미터 설정
	        pstmt.setInt(1, videoNo);
	        
	        // 쿼리 실행
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                board.setVideoNo(rs.getInt("video_no"));
	                board.setVideoURL(rs.getString("video_URL"));
	                board.setVideoTitle(rs.getString("video_title"));
	                board.setCategory(rs.getString("category"));
	                board.setPart(rs.getString("part"));
	                board.setChannelName(rs.getString("channel_name"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return board;
	}


	@Override
	public void insertBoard(Board board) {
		DBUtil dbUtil = DBUtil.getInstance();
	    String sql = "INSERT INTO Video(video_URL, video_title, category, part, channel_name) VALUES(?, ?, ?, ?, ?);";

	    try (Connection conn = dbUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        // 파라미터 설정
	        pstmt.setString(1, board.getVideoURL());
	        pstmt.setString(2, board.getVideoTitle());
	        pstmt.setString(3, board.getCategory());
	        pstmt.setString(4, board.getPart());
	        pstmt.setString(5, board.getChannelName());

	        // 쿼리 실행
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new SQLException("Insert failed, no rows affected.");
	        }
	        else if (rowsAffected == 1) {
	            System.out.println("Insert Success!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void updateBoard(Board board) {
		DBUtil dbUtil = DBUtil.getInstance();
	    String sql = "UPDATE Video SET video_URL = ?, video_title = ?, category = ?, part = ?, channel_name = ? WHERE video_no = ?";

	    try (Connection conn = dbUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        // 파라미터 설정
	        pstmt.setString(1, board.getVideoURL());
	        pstmt.setString(2, board.getVideoTitle());
	        pstmt.setString(3, board.getCategory());
	        pstmt.setString(4, board.getPart());
	        pstmt.setString(5, board.getChannelName());
	        pstmt.setInt(6, board.getVideoNo());

	        // 쿼리 실행
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new SQLException("Update failed, no rows affected.");
	        }
	        else if (rowsAffected == 1) {
	            System.out.println("Update Success!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteBoard(int videoNo) {
		DBUtil dbUtil = DBUtil.getInstance();
	    String sql = "DELETE FROM Video WHERE video_no = ?";

	    try (Connection conn = dbUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        // 파라미터 설정
	        pstmt.setInt(1, videoNo);

	        // 쿼리 실행
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new SQLException("Delete failed, no rows affected.");
	        }
	        else if (rowsAffected == 1) {
	            System.out.println("Delete Success!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
