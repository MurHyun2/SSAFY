package videoPJT;

import java.util.List;

public interface VideoReviewDao {

	void insertReview(int videoNo, String nickname, String content);

	public void editReview(int videoNo, int reviewNo, String newReview);
	
	public List<VideoReview> returnReview(int videoNo);

	public void deleteReview(int videoNo, int reviewNo);
}