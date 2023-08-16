import java.util.*;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ViewStudentScheduleGUI extends JFrame {

	private Administrator currUser;
	private Student currStudent;
	private JPanel contentPane;
	private SchedulePanel schedulePanel;
	private JLabel lblCredit;
	private JButton btnBack;

	public ViewStudentScheduleGUI(Administrator admin, Student student) {
		this.currUser = admin;
		this.currStudent = student;
		List<Course> schedule = currStudent.getEnrolledCourses();
		
		setResizable(false);
		setTitle(currStudent.getRealname() + "'s Schedule");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		schedulePanel = new SchedulePanel(schedule);
		schedulePanel.setBounds(23, 22, 737, 437);
		contentPane.add(schedulePanel);
		
		lblCredit = new JLabel("Credit: " + currStudent.getCurrentCredit() + " out of " + currStudent.getCreditLimit());
		lblCredit.setBounds(23, 460, 128, 14);
		contentPane.add(lblCredit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClick();
			}
		});
		btnBack.setBounds(328, 485, 128, 52);
		contentPane.add(btnBack);
	}
	private void btnBackClick() {
		this.dispose();
	}
}
