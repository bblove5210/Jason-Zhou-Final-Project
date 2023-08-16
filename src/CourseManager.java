import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class CourseManager {
	private static final String FILENAME = "CourseData.bin";
	
	public static List<Course> loadCourseData() {
		try {
			FileInputStream filein = new FileInputStream(FILENAME);
			ObjectInputStream istream = new ObjectInputStream(filein);
			List<Course> courseList = (ArrayList<Course>) istream.readObject();
			Course.setNewCourseID((Integer)istream.readObject());
			istream.close();
			return courseList;
		} catch(Exception e) {
			return new ArrayList<Course>();
		}
	}
	
	public static void saveCourseData(List<Course> courseList){
		try{
			FileOutputStream fileout = new FileOutputStream(FILENAME);
			ObjectOutputStream ostream = new ObjectOutputStream(fileout);
			ostream.writeObject(courseList);
			ostream.writeObject(Integer.valueOf(Course.getNewCourseID()));
			ostream.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
