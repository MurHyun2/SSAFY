package videoPJT;

import java.util.List;

public interface VideoReviewDao {

	void insertReview(VideoReview review);

	List<VideoReview> selectReview(int videoNo, String nickname, String conten);

}