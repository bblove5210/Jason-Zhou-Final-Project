import java.util.*;
import java.io.*;

public class Tester {
	public static void generateUsers() {
		User s1 = new Student("qz2166", "Qihang Zhou", "12345", 18, SchoolYear.JUNIOR);
		User s2 = new Student("js3839", "Joe Smith", "12345", 20, SchoolYear.SENIOR);
		User s3 = new Student("wg4728", "William Green", "12345", 16, SchoolYear.FRESHMAN);
		User s4 = new Student("ah3830", "Adam Harris", "12345", 12, SchoolYear.SOPHOMORE);
		User a = new Administrator("admin", "Admin", "admin");

		UserManager.saveProfile(s1);
		UserManager.saveProfile(s2);
		UserManager.saveProfile(s3);
		UserManager.saveProfile(s4);
		UserManager.saveProfile(a);
	}

	public static void generateCourses() {
		Administrator user = (Administrator) Authenticator.validate("admin", "admin");
		user.createCourse("CSCI-UA 470", "Hasan Aljabbouli", 4,  new int[] {17, 45}, new int[] {19, 50}, new Boolean[] {true,false,true,false,false});
		user.createCourse("CSCI-UA 201", "Douglas Moody", 4,  new int[] {17, 45}, new int[] {19, 50}, new Boolean[] {false,true,false,true,false});
		user.createCourse("CORE-UA 539", "Crystal Parikh", 4,  new int[] {12, 30}, new int[] {13, 45}, new Boolean[] {true,false,true,false,false});
		user.createCourse("PHYS-UA 71", "Javad Shabani", 2,  new int[] {12, 30}, new int[] {15, 30}, new Boolean[] {true,false,true,false,false});
		user.createCourse("PHYS-UA 210", "Michael Blanton", 4,  new int[] {12, 30}, new int[] {13, 45}, new Boolean[] {false,true,false,true,false});
		user.createCourse("MATH-UA 343", "", 4,  new int[] {15, 30}, new int[] {16, 45}, new Boolean[] {false,true,false,true,false});
	}

	public static void printAllCourses() {
		CourseList courseList = CourseList.getInstance();
		for(Course course : courseList.getAllCourses()) {
			System.out.println(String.format("%2d: %s" , course.getCourseID(), course.getName()));
		}
	}

	public static void main(String[] args) throws IOException {

//		generateUsers();
//		generateCourses();

//		printAllCourses();
//				
//		Student user = (Student)Authenticator.validate("qz2166", "12345");
//		CourseList courseList = CourseList.getInstance();
//		//EnrollmentManager.enrollStudentInCourse(user, courseList.getCourseByID(5));
//		EnrollmentManager.dropStudentfromCourse(user, courseList.getCourseByID(0));
//		for(Course course : user.getEnrolledCourses()) {
//			System.out.println(course.getCourseID());
//		}

//		new ScheduleGUI(user).setVisible(true);
	}
}
