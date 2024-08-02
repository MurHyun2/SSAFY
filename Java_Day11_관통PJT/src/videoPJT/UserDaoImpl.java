package videoPJT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class UserDaoImpl implements UserDao {
	List<User> users = new ArrayList<>();

	private static UserDao instance = new UserDaoImpl();

	private UserDaoImpl() {
		// video.json 파일을 읽어서 videoList에 추가
		try (FileReader fr = new FileReader("data/user.json"); BufferedReader br = new BufferedReader(fr);) {
			StringBuffer sb = new StringBuffer();
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				sb.append(line);

			}
			Gson gson = new Gson();
			users = Arrays.asList(gson.fromJson(sb.toString(), User[].class));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public static UserDao getUserDaoImpl() {
		return instance;
	}


	// 유저 로그인
	@Override
	public User getUser(String id, String password) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPassword().equals(password)) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}

	// 유저 회원가입
	@Override
	public boolean insertUser(String id, String password, String nickname) {
		for (int i = 0; i < users.size(); i++) {

			if (!(users.get(i).getId().equals(id))) {
				User user = new User(id, password, nickname);
				users.add(user);

				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("data/ref-copy.json")));) {
					Gson gson = new Gson();
					bw.write(gson.toJson(users));

				} catch (Exception e) {
					e.printStackTrace();
				}

				return true;
			}
		}

		return false;
	}

	// 유저 회원탈퇴
	@Override
	public boolean deleteUser(String id, String password) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPassword().equals(password)) {
				users.remove(i);

				try (BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("data/ref-copy.json")));) {
					Gson gson = new Gson();
					bw.write(gson.toJson(users));

				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;

	}

	// 유저 업데이트
	@Override
	public boolean updateUser(String id, String password, String changePassword, String nickname) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id) && users.get(i).getPassword().equals(password)) {
				users.get(i).setPassword(changePassword);
				users.get(i).setNickname(nickname);
				
				try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/ref-copy.json")));) {
					Gson gson = new Gson();
					bw.write(gson.toJson(users));

				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

}
