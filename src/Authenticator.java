
public class Authenticator {
	public static User validate(String username, String password) {
		//there should be hashing
		if(PasswordManager.verifyPassword(username, password)) {
			return UserManager.getUser(username);
		}
		return null;
	}
}
