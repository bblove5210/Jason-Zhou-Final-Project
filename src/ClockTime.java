import java.io.Serializable;

public class ClockTime implements Serializable {
	private int hour;
	private int minute;
	
	public ClockTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public static int compare(ClockTime a, ClockTime b) {
		if(a.hour < b.hour) {
			return -1;
		}
		
		if(a.hour == b.hour) {
			if(a.minute < b.minute) {
				return -1;
			}
			if(a.minute == b.minute) {
				return 0;
			}
			if(a.minute > b.minute) {
				return 1;
			}
		}
		
		return 1;
	}
	
	public String toString() {
		return String.format("%02d:%02d", hour, minute);
	}
	
	public Double toDouble() {
		return (double)hour + ((double)minute/60);
	}
}
