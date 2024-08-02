package videoPJT;

public interface UserDao {
	User getUser(String id, String password);

	boolean insertUser(String id, String password, String nickname);

	boolean deleteUser(String id, String password);

	boolean updateUser(String id, String password, String changePassword, String nickname);
}
