package com.ssafy.exam.board.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.board.util.DBUtil;

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
	public Board selectBoardByNo(int no) {
	    Board board = new Board();

	    DBUtil dbUtill = DBUtil.getInstance();
	    String sql = "SELECT video_no, video_URL, video_title, category, part, channel_name FROM video WHERE video_no = ?";

	    try (Connection conn = dbUtill.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        // 파라미터 설정
	        pstmt.setInt(1, no);
	        
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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int no) {
		// TODO Auto-generated method stub

	}
}
