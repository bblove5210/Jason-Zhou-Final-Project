import java.io.*;
import java.util.Scanner;

public class PasswordManager {
	private static final String filename = "password.txt";
	
	public static Boolean verifyPassword(String username, String password) {
		String userPassword = getPassword(username);
		if(userPassword != null) {
			return password.equals(userPassword);
		}
		return false;
	}
	
	private static String getPassword(String username) {
		File passwordFile = new File(filename);
		String userPassword = null;
		try {
			Scanner scanner = new Scanner(passwordFile);
			while(scanner.hasNextLine()) {
				String[] data = scanner.nextLine().split(",");
				if(data[0].equals(username)) {
					scanner.close();
					userPassword = data[1];
					break;
				}
			}
		} catch(Exception e) {
			return null;
		}
		return userPassword;
	}
}
