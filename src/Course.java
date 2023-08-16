import java.io.Serializable;

public class Course implements Serializable{
	private int courseID;
	private String name;
	private String instructor;
	private String location;
	private int credit;
	private ClockTime startTime;
	private ClockTime endTime;
	private Boolean[] weekdays = new Boolean[5];
	private Boolean deleted = false;
	
	private static int newCourseID = 0;
		
	public Course(CourseBuilder builder) {
		this.name = builder.name;
		this.instructor = builder.instructor;
		this.credit = builder.credit;
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.weekdays = builder.weekdays;
		this.location = builder.location;
		this.courseID = newCourseID;
		
		++newCourseID;
	}
	
	public Boolean checkConflict(Course other) {
		Boolean sameday = false;
		for(int i=0; i<5; ++i) {
			if(this.getWeekdays()[i] & other.getWeekdays()[i]) {
				sameday = true;
				break;
			}
		}
		if(!sameday) {
			return false;
		}
		
		if( (ClockTime.compare(this.startTime, other.endTime)<0) & (ClockTime.compare(other.startTime, this.endTime)<0) ) {
			return true;
		}
		return false;
	}
	
	public String getWeekdaysString() {
		String[] stringArray = {"Mon", "Tue", "Wed", "Thu", "Fri"};
		for(int i=0; i<5; ++i) {
			if(!weekdays[i]) {
				stringArray[i] = "";
			}
		}
		return stringArray[0] + stringArray[1] + stringArray[2] + stringArray[3] + stringArray[4];
	}
	
	public void delete() {
		deleted = true;
	}
	
	public String getName() {
		return name;
	}
	public String getInstructor() {
		return instructor;
	}
	public int getCredit() {
		return credit;
	}
	public ClockTime getStartTime() {
		return startTime;
	}
	public ClockTime getEndTime() {
		return endTime;
	}
	public Boolean[] getWeekdays() {
		return weekdays;
	}
	public int getCourseID() {
		return courseID;
	}
	public String getTimeString() {
		return String.format(startTime.toString() + "-" + endTime.toString());
	}
	public Boolean isDeleted() {
		return deleted;
	}
	
	public static int getNewCourseID() {
		return newCourseID;
	}
	public static void setNewCourseID(int ID) {
		newCourseID = ID;
	}
	
	public String toString() {
		return String.format("Course Name: %s \nInstructor: %s \nCredit: %d \nTime: %s \nDay: %s \nLocation: %s", name, instructor, credit, getTimeString(), getWeekdaysString(), location);
	}
	
	public String getLocation() {
		return location;
	}

	public static class CourseBuilder {
		//not really necessary, mostly used for handling incompatible attributes
		private String name;
		private String instructor = "TBA";
		private String location = "TBA";
		private int credit;
		private ClockTime startTime;
		private ClockTime endTime;
		private Boolean[] weekdays;
		
		public CourseBuilder(int credit, Boolean[] weekdays) {
			this.credit = credit;
			this.weekdays = weekdays;
		}
		
		public CourseBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public CourseBuilder setInstructor(String instructor) {
			if(instructor.equals("")) {
				return this;
			}
			this.instructor = instructor;
			return this;
		}
		
		public CourseBuilder setStartTime(int[] startTime) {
			this.startTime = new ClockTime(startTime[0], startTime[1]);
			return this;
		}
		
		public CourseBuilder setEndTime(int[] endTime) {
			this.endTime = new ClockTime(endTime[0], endTime[1]);
			return this;
		}
		
		public CourseBuilder setLocation(String location){
			if(location.equals("")) {
				return this;
			}
			this.location = location;
			return this;
		}
		
		public Course build() {
			if(validateAttributes()) {
				return new Course(this);
			}
			return null;
		}
		
		private Boolean validateAttributes() {
			if(ClockTime.compare(startTime, endTime) >= 0) {
				return false;
			}
			if(name == "") {
				return false;
			}
			if(!(weekdays[0]||weekdays[1]||weekdays[2]||weekdays[3]||weekdays[4])) {
				return false;
			}
			return true;
		}
	}
}
