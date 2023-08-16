import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CourseTable extends JTable {
	private final static String[] COLUMN_NAMES = {"Name", "Instructor", "Time", "Location", "Days", "Credit"};
	
	public CourseTable(List<Course> courseList) {
		super(convertCourseListToData(courseList), COLUMN_NAMES);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
	}
	
	private static String[][] convertCourseListToData(List<Course> courseList){
		int length = courseList.size();
		String[][] data = new String[length][];
		int i = 0;
		for(Course course : courseList) {
			String[] entry = {course.getName(), course.getInstructor(), course.getTimeString(), course.getLocation(), course.getWeekdaysString(), Integer.toString(course.getCredit())};
			data[i] = entry;
			++i;
		}
		return data;
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}