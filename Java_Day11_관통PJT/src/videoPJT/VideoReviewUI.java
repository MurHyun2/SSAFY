package videoPJT;

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
				addReviewInfo();
			case 2:
			case 3:
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
	
	public void addReviewInfo() {
		System.out.println("---------");
		System.out.print("닉네임을 입력하세요 : ");
		String nickname = sc.nextLine();
		System.out.println();
		System.out.println("내용을 입력하세요 : ");
		String content = sc.nextLine();
		System.out.println();
		System.out.println("-----------");
		addReview(videoNo, nickname, content);
	}
}
