import java.util.List;

public class Administrator extends User {
	public Administrator(String username, String realname, String password) {
		super(username, realname, password);
	}
	
	public Boolean createCourse(String name, String instructor, String location, int credit, int[] startTime, int[] endTime, Boolean[] weekdays) {
		CourseList courseList = CourseList.getInstance();
		Course.CourseBuilder courseBuilder = new Course.CourseBuilder(credit, weekdays).setInstructor(instructor).setEndTime(endTime).setStartTime(startTime).setName(name).setLocation(location);
		return courseList.createCourse(courseBuilder);
	}
		
	public void deleteCourse(Course course) {
		CourseList courseList = CourseList.getInstance();
		courseList.deleteCourse(course);
	}
	
	public List<Student> getStudentList(){
		return UserManager.getAllStudents();
	}
}
