import java.io.*;
import java.util.*;

public class Student extends User {
	private transient List<Course> enrolledCourses = new ArrayList<>();
	private int creditLimit;
	private transient int currentCredit = 0;
	private SchoolYear schoolYear;
	
	public Student(String username, String realname, String password, int creditLimit, SchoolYear schoolYear) {
		super(username, realname, password);
		this.creditLimit = creditLimit;
		this.schoolYear = schoolYear;
	}
		
	public void addCourse(Course course) {
		enrolledCourses.add(course);
		currentCredit += course.getCredit();
	}
	
	public void dropCourse(Course course) {
		enrolledCourses.remove(course);
		currentCredit -= course.getCredit();
	}
	
	public List<Course> getEnrolledCourses(){
		return enrolledCourses;
	}
	public int getCurrentCredit() {
		return currentCredit;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public SchoolYear getSchoolYear() {
		return schoolYear;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException{
		//custom serialization, not shown on the sequence diagram
		out.defaultWriteObject();
		List<Integer> courseIDList = new ArrayList<>();
		for(Course course : enrolledCourses) {
			courseIDList.add(course.getCourseID());
		}
		out.writeObject(courseIDList);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		//custom serialization, not shown on the sequence diagram
		in.defaultReadObject();
		this.enrolledCourses = new ArrayList<Course>();
		this.currentCredit = 0;
		List<Integer> courseIDList = (ArrayList<Integer>)in.readObject();
		CourseList courseList = CourseList.getInstance();
		for(Integer courseID : courseIDList) {
			Course course = courseList.getCourseByID(courseID);
			if(course != null) {
				this.enrolledCourses.add(course);
				this.currentCredit += course.getCredit();
			}
		}
	}
}
