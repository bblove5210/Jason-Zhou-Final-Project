import java.util.*;

public class EnrollmentManager {
	public static int enrollStudentInCourse(Student student, Course course) {
		//for convenience, the returned int value is used to indicate the result
		int enrollmentResult = checkEligibility(student, course);
		if(enrollmentResult != 0) {
			return enrollmentResult;
		}
		student.addCourse(course);
		UserManager.saveProfile(student);
		return 0;
	}
	
	public static void dropStudentfromCourse(Student student, Course droppedCourse) {
		student.dropCourse(droppedCourse);
		UserManager.saveProfile(student);
	}
	
	private static int checkEligibility(Student student, Course course) {
		if(checkIsTakingCourse(student, course)) {
			return 1;
		}
		if(checkMaxCredit(student, course)) {
			return 2;
		}
		if(checkScheduleConflict(student, course)) {
			return 3;
		}
		return 0;
	}
	
	private static Boolean checkIsTakingCourse(Student student, Course newCourse) {
		List<Course> schedule = student.getEnrolledCourses();
		if(schedule.contains(newCourse)) {
			return true;
		}
		return false;
	}
	
	private static Boolean checkScheduleConflict(Student student, Course newCourse) {
		List<Course> schedule = student.getEnrolledCourses();
		for(Course course : schedule) {
			if(course.checkConflict(newCourse)) {
				return true;
			}
		}
		return false;
	}
	
	private static Boolean checkMaxCredit(Student student, Course newCourse) {
		if(newCourse.getCredit() + student.getCurrentCredit() > student.getCreditLimit()) {
			return true;
		}
		return false;
	}
}
