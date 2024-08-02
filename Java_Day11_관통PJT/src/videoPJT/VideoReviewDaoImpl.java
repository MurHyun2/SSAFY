package videoPJT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class VideoReviewDaoImpl implements VideoReviewDao {

	private VideoReviewDaoImpl() {
		// video.json 파일을 읽어서 videoList에 추가
		try (FileReader fr = new FileReader("data/review.json"); BufferedReader br = new BufferedReader(fr);) {
			StringBuffer sb = new StringBuffer();
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				sb.append(line);

			}
			Gson gson = new Gson();
			List<Video> reviewList = Arrays.asList(gson.fromJson(sb.toString(), Video[].class));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int reviewNo = 0;

	private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();

	private static VideoReviewDao instance = new VideoReviewDaoImpl();

	public static VideoReviewDao getInstance() {
		return instance;
	}

	@Override
	public void insertReview(int videoNo, String nickname, String content) {

		VideoReview vr = new VideoReview(videoNo, ++reviewNo, nickname, content);

		List<VideoReview> lists = videoReviewDb.get(videoNo);

		if (lists == null) {
			lists = new ArrayList<>();
			videoReviewDb.put(videoNo, lists);
		}
		lists.add(vr);

		saveReviewsToFile();

	}

	private void saveReviewsToFile() {
		try (FileWriter fw = new FileWriter("data/review.json"); BufferedWriter bw = new BufferedWriter(fw)) {
			Gson gson = new Gson();
			String json = gson.toJson(videoReviewDb);
			bw.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editReview(int videoNo, int reviewNo, String newReview) {
		List<VideoReview> lists = videoReviewDb.get(videoNo);
		lists.get(reviewNo - 1).setContent(newReview);

	}

	@Override
	public List<VideoReview> returnReview(int videoNo) {

		List<VideoReview> lists = videoReviewDb.get(videoNo);

		if (lists == null) {
			return null;
		}

		return lists;
	}

	@Override
	public void deleteReview(int videoNo, int reviewNo) {

		List<VideoReview> lists = videoReviewDb.get(videoNo);

		if (lists != null) {
			lists.remove(reviewNo - 1);
			this.reviewNo--;
		}

	}

}
