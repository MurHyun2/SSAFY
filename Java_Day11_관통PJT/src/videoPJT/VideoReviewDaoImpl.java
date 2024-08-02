package videoPJT;

import java.io.BufferedReader;
import java.io.FileReader;
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
			videoList = Arrays.asList(gson.fromJson(sb.toString(), Video[].class));

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
		
		VideoReview vr = new VideoReview(videoNo, reviewNo++, nickname, content);
		
		List<VideoReview> lists = videoReviewDb.get(videoNo);
		
		if (lists == null) {
			lists = new ArrayList<>();
			videoReviewDb.put(videoNo, lists);
		}
		lists.add(vr);
		
	}
	
	@Override
	public List<VideoReview> selectReview(int videoNo){
		return null;
	}
	

}
