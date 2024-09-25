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

	public static void main(String[] args) throws SQLException {
		DBUtil dbUtill = DBUtil.getInstance();
		Connection con = dbUtill.getConnection();
		System.out.println(con);
	}

	private static BoardDAOImpl instance = new BoardDAOImpl();

	private BoardDAOImpl() {
	}

	public static BoardDAOImpl getInstance() {
		return instance;
	}

	List<Board> bList = new ArrayList<Board>();
	int bNo = bList.isEmpty() ? 0 : bList.getFirst().getNo();

	@Override
	public Board selectBoard(int no) {
		for (Board b : bList) {
			if (b.getNo() == no)
				return b;
		}

		return null;
	};

	@Override
	public List<Board> selectBoardList() throws SQLException {
		List<Board> list = new ArrayList<>();
		
		DBUtil dbUtill = DBUtil.getInstance();
		Connection con = dbUtill.getConnection();
		String sql = "select no, title, writer, content, views from board order by no desc";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			System.out.println(no);
			String title = rs.getString("title");
			System.out.println(title);
			String writer = rs.getString("writer");
			System.out.println(writer);
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
	public void insertBoard(Board board) {
		board.setNo(++bNo);
		bList.add(board);
	};

	@Override
	public void updateBoard(int no, String title, String content) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				b.setTitle(title);
				b.setContent(content);
				return;
			}
		}
	};

	@Override
	public void deleteBoard(int no) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				bList.remove(b);
				return;
			}
		}
	}

	@Override
	public void updateViewCnt(int no) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				b.setViews(b.getViews() + 1);
				return;
			}
		}
	};

}
