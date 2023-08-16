import java.io.*;
import java.util.*;

public class UserManager {
	private static final String directoryPath = "Users/";
	private static final String fileExtension = ".bin";
	
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
		String filename = directoryPath + username + fileExtension;
		return getUserFilename(filename);
	}
	
	public static List<Student> getAllStudents(){
		List<Student> studentList = new ArrayList<>();
		try {
			File dir = new File(directoryPath);
			File[] fileList = dir.listFiles();
			if(fileList == null) {
				return studentList;
			}
			for(File userFile : fileList) {
				User user = getUserFilename(directoryPath+userFile.getName());
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
		File dir = new File(directoryPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String filename = directoryPath + user.getUsername() + fileExtension;
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
