package videoPJT;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class VideoDaoImpl implements VideoDao {
	private List<Video> videoList = new ArrayList<>();

	private static VideoDao instance = new VideoDaoImpl();

	private VideoDaoImpl() {
		// video.json 파일을 읽어서 videoList에 추가
		try (FileReader fr = new FileReader("data/video.json"); BufferedReader br = new BufferedReader(fr);) {
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

	public static VideoDao getInstance() {
		return instance;
	}

	@Override
	public List<Video> getList() {
		return videoList;
	}

	@Override
	public Video getVideo(int no) {
		return videoList.get(no - 1);
	}

	@Override
	public void openUrl(String str) {
		try {
			// Desktop 객체 얻기
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();

				// URL 열기
				desktop.browse(new URI(str));
			} else {
				System.out.println("Desktop is not supported on this system.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
