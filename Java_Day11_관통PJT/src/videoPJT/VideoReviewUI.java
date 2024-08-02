package videoPJT;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VideoReviewUI {

	private VideoReviewDao vrDao = VideoReviewDaoImpl.getInstance();
	Scanner sc = new Scanner(System.in);

	public void start(int no) {
		int videoNo = no;
		while (true) {
			int menuNo = menu();
			switch (menuNo) {
			case 1:
				addReviewInfo(videoNo);
				showReview(videoNo);
				continue;
			case 2:
				editReviewInfo(videoNo);
				showReview(videoNo);
				continue;
			case 3:
				deleteReviewInfo(videoNo);
				showReview(videoNo);
				continue;
			case 0: 
				return;
			default:
				System.out.println("없는 메뉴");
			}
		}
	}
	


	private int menu() {
		System.out.println("---------");
		System.out.println("1. 리뷰등록");
		System.out.println("2. 리뷰수정");
		System.out.println("3. 리뷰삭제");
		System.out.println("0. 돌아가기");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");

		return Integer.parseInt(sc.nextLine());

	}
	
	private void addReview(int videoNo, String nickname, String content) {
		vrDao.insertReview(videoNo, nickname, content);
	}
	
	private void editReviewInfo(int videoNo) {
		System.out.println("리뷰 번호를 입력하세요 : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		System.out.println("수정된 리뷰를 입력하세요 :");
		String newReview = sc.nextLine();
		vrDao.editReview(videoNo, reviewNo, newReview);
		
	}
	
	private void showReview(int videoNo) {
		List<VideoReview> list = vrDao.returnReview(videoNo);
		System.out.println("리뷰 목록:");
		
		for (VideoReview vr : list) {
			System.out.println(vr.getReviewNo() + " " + vr.getNickName() + " " + vr.getContent());
			
		}
		
	}
	
	public void addReviewInfo(int videoNo) {
		System.out.println("---------");
		System.out.print("닉네임을 입력하세요 : ");
		String nickname = sc.nextLine();
		System.out.println();
		System.out.println("내용을 입력하세요 : ");
		String content = sc.nextLine();
		System.out.println();
		System.out.println("-----------");
		addReview(videoNo, nickname, content);
		return;
	}
	
	public void deleteReviewInfo(int videoNo) {
		System.out.println("삭제할 리뷰 번호를 입력하세요 : ");
		int reviewNo = Integer.parseInt(sc.nextLine());
		vrDao.deleteReview(videoNo, reviewNo);
	}

}
