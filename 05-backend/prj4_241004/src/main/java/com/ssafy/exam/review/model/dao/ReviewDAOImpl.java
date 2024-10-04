package  com.ssafy.exam.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.exam.review.model.Review;
import com.ssafy.exam.util.DBUtil;

public  class ReviewDAOImpl implements ReviewDAO	 {

	//C : InsertReview
	//R : getReviews(전체)
	//    getReview(하나)
	//U : updateReview(수정) 
	//D : deleteReview(삭제)
	public static void main(String[] args) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		System.out.println(con);
	}
	
	//싱글턴 
	private static ReviewDAO instance = new ReviewDAOImpl();
	public ReviewDAOImpl() {}
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	
	//리뷰 등록하
	@Override
	public void insertReview(Review review) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		//db 연결하기. 
		Connection con = dbUtil.getConnection();
		
		//확인
		String sql = "insert into review( video_no, writer, review_content) values(?, ?, ?)";
	
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, review.getVideoNo());
		pstmt.setString(2, review.getWriter());
		pstmt.setString(3, review.getContent());
	
		pstmt.executeUpdate();
	}
	//특정 비디오 모든 리뷰 조회 
	@Override
	public List<Review> selectAllReviews(int videoNo) throws SQLException {
		List<Review> list = new ArrayList<>();
		
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		//videoNo로 해당 비디오의 모든 리뷰를 가져오기. 
		String sql = "select review_no, video_no, review_content, writer, view_cnt, reg_date from Review where video_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, videoNo); // 비디오 번호 보내기. 
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int reviewNo = rs.getInt("review_no");
			String reviewContent = rs.getString("review_content");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("view_cnt");
			String regDate = rs.getString("reg_date");
			
			Review review = new Review();
			

			review.setReviewNo(reviewNo);
			review.setVideoNo(videoNo);
			review.setContent(reviewContent);
			review.setWriter(writer);
			review.setViewCnt(viewCnt);
			review.setRegDate(regDate);
			
			System.out.print(review.toString());
			list.add(review);
		}
		return list;
		
	}

	
	//리뷰 1개 선택
	@Override
	public Review selectReviewByNo(int reviewNo) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();
		String sql = "select review_no, video_no, review_content, writer, view_cnt, reg_date from review where review_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, reviewNo);
		
		

		// SQL문 실행하기 : select(executeQuery), select절 이외(executeUpdate)
		ResultSet rs = pstmt.executeQuery();

		// 1개밖에 없으면 if, 무조건 있다는 전제는 if문을 안써도 됨.
		if (rs.next()) {
			int videoNo = rs.getInt("video_no");
			String content = rs.getString("review_content");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("view_cnt");
			String regDate = rs.getString("reg_date");
			
			Review review = new Review();
			
			review.setReviewNo(reviewNo);
			review.setVideoNo(videoNo);
			review.setContent(content);
			review.setWriter(writer);
			review.setViewCnt(viewCnt);
			review.setRegDate(regDate);
			
			return review;
		}
		return null;
		
	}
	//리뷰 삭제
	@Override
	public void deleteReview(int no) throws SQLException {
		DBUtil dbUtil = DBUtil.getInstance();
		//db 연결
		Connection con = dbUtil.getConnection();
		//확인
		String sql = "delete from review where review_no=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}
	//리뷰 수정. 
	@Override
	public void updateReview(Review review) throws SQLException{
		DBUtil dbUtil = DBUtil.getInstance();
		Connection con = dbUtil.getConnection();

		String sql = "update review set review_content =? where review_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, selectReviewByNo(no).getTitle());
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getReviewNo());
		pstmt.executeUpdate();
	}

}
