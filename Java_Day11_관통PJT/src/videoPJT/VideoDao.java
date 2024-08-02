package videoPJT;

import java.util.List;

public interface VideoDao {
	List<Video> getList();

	Video getVideo(int no);

	void openUrl(String str);
}
