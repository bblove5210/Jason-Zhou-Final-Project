import java.util.*;

public class CourseList {
	private static CourseList instance = null;
	
	private List<Course> completeCourseList; //contains deleted courses, used to ensure consistency after courses are deleted
	private List<Course> courseList;
	
	private CourseList() {
		completeCourseList = CourseManager.loadCourseData();
		courseList = new ArrayList<>();
		for(Course course: completeCourseList) {
			if(!course.isDeleted()) {
				courseList.add(course);
			}
		}
	}
	
	public Course getCourseByID(int id){
		if(id+1 > completeCourseList.size()) {
			return null;
		}
		
		Course course = completeCourseList.get(id);
		if(course.isDeleted()) {
			return null;
		} else {
			return course;
		}
	}
	
	public List<Course> getAllCourses(){
		return courseList;
	}
	
	public Boolean createCourse(Course.CourseBuilder courseBuilder) {
		Course newCourse = courseBuilder.build();
		if(newCourse == null) {
			return false;
		}
		completeCourseList.add(newCourse);
		courseList.add(newCourse);
		CourseManager.saveCourseData(completeCourseList);
		return true;
	}
	
	public void deleteCourse(Course course) {
		course.delete();
		courseList.remove(course);
		CourseManager.saveCourseData(completeCourseList);
	}
	
	public static CourseList getInstance() {
		if(instance == null) {
			instance = new CourseList();
			return instance;
		}
		return instance;
	}
	
	
}
