import java.io.*;
import java.util.*;

public class UserManager {
	private static final String DIRECTORY_PATH = "Users/";
	private static final String FILE_EXTENSION = ".bin";
	
	private static User getUserFilename(String filename) {
		try {
			FileInputStream filein = new FileInputStream(filename);
			ObjectInputStream istream = new ObjectInputStream(filein);
			User user = (User)istream.readObject();
			istream.close();
			return user;
		} catch(Exception e) {
			return null;
		}
	}
	
	public static User getUser(String username) {
		String filename = DIRECTORY_PATH + username + FILE_EXTENSION;
		return getUserFilename(filename);
	}
	
	public static List<Student> getAllStudents(){
		List<Student> studentList = new ArrayList<>();
		try {
			File dir = new File(DIRECTORY_PATH);
			File[] fileList = dir.listFiles();
			if(fileList == null) {
				return studentList;
			}
			for(File userFile : fileList) {
				User user = getUserFilename(DIRECTORY_PATH+userFile.getName());
				if(user instanceof Student) {
					studentList.add((Student)user);
				}
			}
			return studentList;
		} catch(Exception e) {
			System.out.println(e);
			return studentList;
		}
	}
		
	public static void saveProfile(User user) {
		File dir = new File(DIRECTORY_PATH);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String filename = DIRECTORY_PATH + user.getUsername() + FILE_EXTENSION;
		try {
			FileOutputStream fileout = new FileOutputStream(filename);
			ObjectOutputStream ostream = new ObjectOutputStream(fileout);
			ostream.writeObject(user);
			ostream.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
