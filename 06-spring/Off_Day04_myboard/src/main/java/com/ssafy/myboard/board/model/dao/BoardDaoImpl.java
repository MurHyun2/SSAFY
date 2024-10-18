package com.ssafy.myboard.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ssafy.myboard.board.config.MyBatisConfig;
import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;
import com.ssafy.myboard.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {

	private final String NS = "com.ssafy.myboard.board.model.dao.BoardDao.";

	private SqlSessionFactory sqlFactory;

	public BoardDaoImpl() {
		sqlFactory = MyBatisConfig.getFactory();
	}

	@Override
	public List<Board> selectBoardAll() {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			return sqlSession.selectList(NS + "selectBoardAll");
		}
//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				SELECT no, title, content, view_cnt, reg_date
//				FROM board
//				ORDER BY no DESC
//				""");
//
//		List<Board> list = new ArrayList<>();
//		ResultSet rs = pstmt.executeQuery();
//		while (rs.next()) {
//			Board board = new Board();
//			board.setNo(rs.getInt("no"));
//			board.setTitle(rs.getString("title"));
//			board.setContent(rs.getString("content"));
//			board.setViewCnt(rs.getInt("view_cnt"));
//			board.setRegDate(rs.getString("reg_date"));
//
//			list.add(board);
//		}
//
//		return list;
	}

	@Override
	public Board selectBoardOne(int no) {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			return sqlSession.selectOne(NS + "selectBoardOne", no);
		}

//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				SELECT no, title, content, view_cnt, reg_date
//				FROM board
//				WHERE no = ?
//				""");
//
//		Board board = null;
//		pstmt.setInt(1, no);
//		ResultSet rs = pstmt.executeQuery();
//
//		if (rs.next()) {
//			board = new Board();
//
//			board.setNo(rs.getInt("no"));
//			board.setTitle(rs.getString("title"));
//			board.setContent(rs.getString("content"));
//			board.setViewCnt(rs.getInt("view_cnt"));
//			board.setRegDate(rs.getString("reg_date"));
//		}
//
//		return board;
	}

	@Override
	public void insertBoard(Board board) {
		try (SqlSession sqlSession = sqlFactory.openSession(true)) {
			sqlSession.insert(NS + "insertBoard", board);
		}
//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				INSERT INTO board (title, content)
//				VALUES(?, ?)
//				""");
//
//		pstmt.setString(1, board.getTitle());
//		pstmt.setString(2, board.getContent());
//		pstmt.executeUpdate();
//
//		int no = -1;
//
//		// DBUtil 인스턴스 생성 및 DB 연결
//		try (PreparedStatement pstmt2 = conn.prepareStatement("SELECT LAST_INSERT_ID() AS last_no FROM dual");
//				ResultSet rs = pstmt2.executeQuery()) {
//
//			// 결과 값 추출
//			if (rs.next()) {
//				board.setNo(rs.getInt("last_no"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace(); // 예외 처리
//			throw e;
//		}
	}

	@Override
	public void insertBoardFile(BoardFile boardFile) {
		try (SqlSession sqlSession = sqlFactory.openSession(true)) {
			sqlSession.insert(NS + "insertBoardFile", boardFile);
		}
		
//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				INSERT INTO board_file (file_path, ori_name, system_name, no)
//				VALUES(?, ?, ?, ?)
//				""");
//
//		pstmt.setString(1, boardFile.getFilePath());
//		pstmt.setString(2, boardFile.getOriName());
//		pstmt.setString(3, boardFile.getSystemName());
//		pstmt.setInt(4, boardFile.getNo());
//		pstmt.executeUpdate();
	}

	@Override
	public void updateBoard(Board board) {
		try (SqlSession sqlSession = sqlFactory.openSession(true)) {
			sqlSession.update(NS + "updateBoard", board);
		}
		
//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				UPDATE board
//				SET title = ?, content = ?
//				WHERE no = ?
//				""");
//
//		pstmt.setString(1, board.getTitle());
//		pstmt.setString(2, board.getContent());
//		pstmt.setInt(3, board.getNo());
//		pstmt.executeUpdate();
	}

	@Override
	public void deleteBoard(int no) {
		try (SqlSession sqlSession = sqlFactory.openSession(true)) {
			sqlSession.delete(NS + "deleteBoard", no);
		}
//		DBUtil dbutil = DBUtil.getInstance();
//		Connection conn = dbutil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("""
//				DELETE FROM board
//				WHERE no = ?
//				""");
//
//		pstmt.setInt(1, no);
//		pstmt.executeUpdate();
	}

	@Override
	public BoardFile selectBoardFileByNo(int no) {
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			return sqlSession.selectOne(NS + "selectBoardFileByNo", no);
		}
		
//		DBUtil dbutil = DBUtil.getInstance();
//		BoardFile boardFile = null;
//
//		// try-with-resources를 사용해 리소스 자동 해제
//		try (Connection conn = dbutil.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(
//						"SELECT file_no, file_path, ori_name, system_name, no FROM board_file WHERE no = ?")) {
//
//			pstmt.setInt(1, no);
//			try (ResultSet rs = pstmt.executeQuery()) {
//				if (rs.next()) {
//					// BoardFile 객체를 생성하고 값 설정
//					boardFile = new BoardFile();
//					boardFile.setFileNo(rs.getInt("file_no"));
//					boardFile.setFilePath(rs.getString("file_path"));
//					boardFile.setOriName(rs.getString("ori_name"));
//					boardFile.setSystemName(rs.getString("system_name"));
//					boardFile.setNo(rs.getInt("no"));
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace(); // 예외 로그 출력
//			throw e; // 예외 다시 던지기
//		}
//
//		return boardFile;
	}

}
