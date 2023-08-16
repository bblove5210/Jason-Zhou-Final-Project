import javax.swing.*;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.color.*;
import java.util.*;
import java.awt.Color;
import java.awt.FontMetrics;

public class SchedulePanel extends JPanel {
	List<Course> schedule;
	
	public SchedulePanel(List<Course> schedule) {
		this.schedule = schedule;
		
	}
	
	public void paintComponent(Graphics g) {
		drawSchedule(g);
	}	
	
	private void drawSchedule(Graphics g) {
		int startingTime = 8;
		int endingTime = 20;
		int xScheduleOrigin = 40;
		int yScheduleOrigin = 30;
		int xScheduleEnd = getWidth()-xScheduleOrigin;
		int yScheduleEnd = getHeight();
		int dayWidth = (xScheduleEnd - xScheduleOrigin)/5;
		int hourHeight = (yScheduleEnd - yScheduleOrigin)/(endingTime - startingTime);
		
		//drawing outline
		int totalHours = endingTime-startingTime;
		for(int i=0; i<=totalHours; ++i) {
			g.setColor(Color.gray);
			int yHourMark = yScheduleOrigin + i*hourHeight;
			g.drawLine(xScheduleOrigin, yHourMark, xScheduleEnd, yHourMark);
			
			g.setColor(Color.black);
			drawCenteredString(g, String.format("%02d", i+startingTime)+":00", new Rectangle( 0, (int)(yScheduleOrigin + (i-0.5)*hourHeight), xScheduleOrigin, hourHeight));
		}
		
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		for(int i=0; i<5; ++i) {
			drawCenteredString(g, days[i], new Rectangle(xScheduleOrigin+i*dayWidth, 0, dayWidth, yScheduleOrigin));
		}

		//drawing courses
		for(Course course : schedule) {
			int timeBegin = (int)(yScheduleOrigin + (course.getStartTime().toDouble()-9)*hourHeight);
			int timeEnd = (int)(yScheduleOrigin + (course.getEndTime().toDouble()-9)*hourHeight);
			
			for(int j=0;j<5;++j) {
				if(course.getWeekdays()[j]) {
					g.setColor(Color.lightGray);
					int dayBegin = xScheduleOrigin + j*dayWidth;
					g.fillRect(dayBegin, timeBegin + yScheduleOrigin, dayWidth, timeEnd-timeBegin);
					g.setColor(Color.black);
					g.drawRect(dayBegin, timeBegin + yScheduleOrigin, dayWidth, timeEnd-timeBegin);
					
					drawCenteredString(g, course.getName(), new Rectangle(dayBegin, timeBegin + yScheduleOrigin, dayWidth, hourHeight/2));
					drawCenteredString(g, course.getStartTime().toString() + "-" + course.getEndTime().toString(), new Rectangle(dayBegin, timeBegin + yScheduleOrigin + hourHeight/2, dayWidth, hourHeight/2));
				}
			}
		}
	}
		
	//this method modified version of https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
	private void drawCenteredString(Graphics g, String text, Rectangle rect) { 
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(getFont());
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Draw the String
	    g.drawString(text, x, y);
	}
}
