package videoPJT;

import java.util.List;
import java.util.Scanner;

public class VideoUI {
	private Scanner sc = new Scanner(System.in);

	private VideoDao videoDao = VideoDaoImpl.getInstance();
	private List<Video> videoList = videoDao.getList();

	public void start() {
		while (true) {
			int menuNo = menu();
			switch (menuNo) {
			case 1:
				videoList();
			case 0:
				exit();
				return;
			default:
				System.out.println("없는 메뉴");
			}
		}
	}

	private int menu() {
		System.out.println("---------");
		System.out.println("1. 비디오 목록");
		System.out.println("0. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");

		return Integer.parseInt(sc.nextLine());

	}

	private void exit() {

	}

	private void videoList() {
		System.out.println("비디오 목록:");
		for (Video v : videoList) {
			System.out.println(v.getNo() + " : " + v.getTitle());
		}
		System.out.println("--------------------------");

		while (true) {
			int menuNo = videoListMenu();
			switch (menuNo) {
			case 1:
				System.out.print("영상 번호 선택 : ");
				int no = Integer.parseInt(sc.nextLine());
				getVideo(no);
				// 영상 상세 정보 메서드 호출
			case 0:
				start();
			default:
				System.out.println("없는 메뉴");
			}
		}
	}

	private int videoListMenu() {
		System.out.println("---------");
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");

		return Integer.parseInt(sc.nextLine());

	}

	private void getVideo(int no) {
		while (true) {
			int menuNo = getVideoInfo(no);
			switch (menuNo) {
			case 1:
				videoDao.openUrl(videoList.get(no).getUrl());
				getVideoInfo(no);
			case 2:
				new VideoReviewUI().start(no);
			case 0:
				videoList();
			default:
				System.out.println("없는 메뉴");
			}
		}
	}

	private int getVideoInfo(int no) {
		while (true) {

			Video video = videoDao.getVideo(no);
			List<VideoReview> vReviews = VideoReviewDaoImpl.getInstance().returnReview(no);

			System.out.println("-----------");
			System.out.println("번호 : " + video.getNo());
			System.out.println("제목 : " + video.getTitle());
			System.out.println("운동 : " + video.getPart());
			System.out.println("영상 URL : " + video.getUrl());
			System.out.println("-----------");
			if (vReviews != null) {
				for (VideoReview rv : vReviews) {
					System.out.println(rv.getReviewNo() + " " + rv.getNickName() + " " + rv.getContent());
				}

				System.out.println("-----------");
			}
			System.out.println("1. 영상 재생");
			System.out.println("2. 리뷰관리");
			System.out.println("0. 이전으로");
			System.out.println("-----------");
			System.out.print("메뉴 선택 : ");

			return Integer.parseInt(sc.nextLine());
			
	
		}

	}

}
