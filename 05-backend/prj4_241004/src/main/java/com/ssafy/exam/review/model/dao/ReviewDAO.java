package  com.ssafy.exam.review.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.review.model.Review;

public interface ReviewDAO {

	//등록하기
	void insertReview(Review review)throws SQLException;
	
	//수정하기
	void updateReview(Review review)throws SQLException;
	
	//삭제하기
	void deleteReview(int no)throws SQLException; 
	
	//비디오 번호로 리뷰 가져오기
	Review selectReviewByNo(int no)throws SQLException;
	
	//비디오 리뷰 전체 가져오기.
	List<Review> selectAllReviews(int videoNo) throws SQLException;

}
