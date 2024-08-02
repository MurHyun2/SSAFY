package videoPJT;

import java.util.Scanner;

public class UserUI {
	private Scanner sc = new Scanner(System.in);

	private UserDao userDao = UserDaoImpl.getUserDaoImpl();
	private String ID = "";

	public void start() {
		while (true) {
			if (ID == "") {
				int menuNo = menu();
				switch (menuNo) {
				case 1:
					loginInfo();
					continue;
				case 2:
					if (signInInfo() == false)
						System.out.println("등록 실패!");
					else
						System.out.println("등록 성공!");
					continue;
				case 0:
					return;
				default:
					System.out.println("없는 메뉴");
				}
			} else {
				int menuNo = loginMenu();
				switch (menuNo) {
				case 1:
					
					if (updateInfo() == false)
						System.out.println("수정 실패!");
					else
						System.out.println("수정 성공!");
					continue;
				case 2:
					if (deleteInfo() == false)
						System.out.println("탈퇴 실패!");
					else
						System.out.println("탈퇴 성공!");
					ID = "";
					continue;
				case 0:
					ID = "";
					continue;
				default:
					System.out.println("없는 메뉴");
				}
			}
		}
	}

	private int menu() {
		System.out.println("---------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");

		return Integer.parseInt(sc.nextLine());
	}

	private int loginMenu() {
		System.out.println("---------");
		System.out.println("1. 회원정보 수정");
		System.out.println("2. 회원 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");

		return Integer.parseInt(sc.nextLine());
	}

	private void login(String id, String password) {
		try {
			ID = userDao.getUser(id, password).getId();
		} catch (Exception e) {
			System.out.println("비밀번호 오류!");
		}
	}

	private void loginInfo() {
		System.out.println("---------");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		System.out.println("-----------");

		login(id, password);
	}

	private boolean signIn(String id, String password, String nickname) {
		return userDao.insertUser(id, password, nickname);
	}

	private boolean signInInfo() {
		System.out.println("---------");
		System.out.println("회원 가입 중");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		System.out.print("NICKNAME : ");
		String nickname = sc.nextLine();
		System.out.println("-----------");

		return signIn(id, password, nickname);
	}
	


	private boolean update(String id, String password, String changePassword, String nickname) {
		return userDao.updateUser(id, password, changePassword, nickname);
	}

	private boolean updateInfo() {
		System.out.println("---------");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		System.out.print("CHANGE PASSWORD : ");
		String changePassword = sc.nextLine();
		System.out.print("NICKNAME : ");
		String nickname = sc.nextLine();
		System.out.println("-----------");
		
		return update(id, password, changePassword, nickname);
	}

	private boolean delete(String id, String password) {
		return userDao.deleteUser(id, password);
	}

	private boolean deleteInfo() {
		System.out.println("---------");
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("PASSWORD : ");
		String password = sc.nextLine();
		System.out.println("-----------");
		
		return delete(id, password);
	}
}
