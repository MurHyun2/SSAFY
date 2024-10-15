package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectBoardAll() throws SQLException {
		DBUtil dbutil = DBUtil.getInstance();
		Connection conn = dbutil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("""
				SELECT no, title, content, view_cnt, reg_date
				FROM board
				ORDER BY no DESC
				""");

		List<Board> list = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Board board = new Board();
			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));

			list.add(board);
		}

		return list;
	}

	@Override
	public Board selectBoardOne(int no) throws SQLException {
		DBUtil dbutil = DBUtil.getInstance();
		Connection conn = dbutil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("""
				SELECT no, title, content, view_cnt, reg_date
				FROM board
				WHERE no = ?
				""");

		Board board = null;
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			board = new Board();

			board.setNo(rs.getInt("no"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setViewCnt(rs.getInt("view_cnt"));
			board.setRegDate(rs.getString("reg_date"));
		}

		return board;
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
		DBUtil dbutil = DBUtil.getInstance();
		Connection conn = dbutil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("""
				INSERT INTO board (title, content)
				VALUES(?, ?)
				""");

		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.executeUpdate();
	}

	@Override
	public void updateBoard(Board board) throws SQLException {
		DBUtil dbutil = DBUtil.getInstance();
		Connection conn = dbutil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("""
				UPDATE board
				SET title = ?, content = ?
				WHERE no = ?
				""");

		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getNo());
		pstmt.executeUpdate();

	}

	@Override
	public void deleteBoard(int no) throws SQLException {
		DBUtil dbutil = DBUtil.getInstance();
		Connection conn = dbutil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("""
				DELETE FROM board
				WHERE no = ?
				""");

		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}

}
