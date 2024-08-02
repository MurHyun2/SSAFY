package videoPJT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

public class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();
    private static final String FILE_PATH = "data/user.json";
    
    private static UserDao instance = new UserDaoImpl();

    private UserDaoImpl() {
        loadUsersFromFile();
    }

    public static UserDao getUserDaoImpl() {
        return instance;
    }

    private void loadUsersFromFile() {
        try (FileReader fr = new FileReader(FILE_PATH);
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            Gson gson = new Gson();
            users = Arrays.asList(gson.fromJson(sb.toString(), User[].class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean saveUsersToFile() {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_PATH)))) {
            Gson gson = new Gson();
            bw.write(gson.toJson(users));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUser(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean insertUser(String id, String password, String nickname) {
        // 중복 ID 검사
        for (User existingUser : users) {
            if (existingUser.getId().equals(id)) {
                return false; // ID가 중복되면 false 반환
            }
        }

        // 새로운 사용자 추가
        User newUser = new User(id, password, nickname);
        users.add(newUser);

        // JSON 파일에 사용자 리스트 기록
        return saveUsersToFile();
    }

    @Override
    public boolean deleteUser(String id, String password) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                iterator.remove();
                return saveUsersToFile(); // 파일에 기록
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(String id, String password, String changePassword, String nickname) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                user.setPassword(changePassword);
                user.setNickname(nickname);
                return saveUsersToFile(); // 파일에 기록
            }
        }
        return false;
    }
}
