package com.ssafy.exam.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.util.DBUtil;

// CRUD

public class BoardDAOImpl implements BoardDAO {
	private static BoardDAOImpl instance = new BoardDAOImpl();

	private BoardDAOImpl() {
	}

	public static BoardDAOImpl getInstance() {
		return instance;
	}

	@Override
	public Board selectBoard(int no) throws SQLException {
		Board board = new Board();

		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = dbUtil.getConnection();
		String sql = "select * from board where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			int views = rs.getInt("views");

			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			board.setViews(views);
			
			return board;
		}

		return null;
	};

	@Override
	public List<Board> selectBoardList() throws SQLException {
		List<Board> list = new ArrayList<>();

		DBUtil dbUtill = DBUtil.getInstance();
		Connection conn = dbUtill.getConnection();
		String sql = "select no, title, writer, content, views from board order by no desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String content = rs.getString("content");
			int views = rs.getInt("views");

			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			board.setViews(views);

			list.add(board);
		}

		return list;
	};

	@Override
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbUtill = DBUtil.getInstance();
		Connection conn = dbUtill.getConnection();
		String sql = "INSERT INTO board(title, writer, content) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		
		int updateResult = pstmt.executeUpdate();
		
		if(updateResult > 0)
			System.out.println("update Success!");
	};

	@Override
	public void updateBoard(int no, String title, String content) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = dbUtil.getConnection();
		String sql = "UPDATE board SET title = ?, content = ? WHERE no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setInt(3, no);
		int viewsUpdate = pstmt.executeUpdate();

		if(viewsUpdate > 0) {
			System.out.println("board Update!");
		}
	};

	@Override
	public void deleteBoard(int no) throws SQLException {
		DBUtil dbUtill = DBUtil.getInstance();
		Connection conn = dbUtill.getConnection();
		String sql = "DELETE FROM board WHERE no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		int deleteResult = pstmt.executeUpdate();
		
		if(deleteResult > 0) {
			System.out.println("delete Success!");
		}
	}

	@Override
	public void updateViewCnt(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection conn = dbUtil.getConnection();
		String sql = "UPDATE board SET views = views + 1 WHERE no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		int viewsUpdate = pstmt.executeUpdate();

		if(viewsUpdate > 0) {
			System.out.println("views Update!");
		}
	};

}

