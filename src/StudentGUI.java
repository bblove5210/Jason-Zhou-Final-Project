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

public class StudentGUI extends JFrame {

	private Student currUser;
	private JPanel contentPane;
	private SchedulePanel schedulePanel;
	private JButton btnLogOut;
	private JButton btnAddCourse;
	private JButton btnDropCourse;
	private JButton btnRefresh;
	private JLabel lblCredit;

	public StudentGUI(Student student) {
		currUser = student;
		List<Course> enrolledCourses = currUser.getEnrolledCourses();
		
		setResizable(false);
		setTitle(currUser.getRealname() + "'s Schedule");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		schedulePanel = new SchedulePanel(enrolledCourses);
		schedulePanel.setBounds(23, 22, 737, 437);
		contentPane.add(schedulePanel);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogOutClick();
			}
		});
		btnLogOut.setBounds(632, 485, 128, 52);
		contentPane.add(btnLogOut);
		
		btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddCourseClick();
			}
		});
		btnAddCourse.setBounds(220, 485, 128, 52);
		contentPane.add(btnAddCourse);
		
		btnDropCourse = new JButton("Drop Course");
		btnDropCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDropCourseClick();
			}
		});
		btnDropCourse.setBounds(429, 485, 128, 52);
		contentPane.add(btnDropCourse);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnRefresh.setBounds(23, 485, 128, 52);
		contentPane.add(btnRefresh);
		
		lblCredit = new JLabel("Credit: " + currUser.getCurrentCredit() + " out of " + currUser.getCreditLimit());
		lblCredit.setBounds(23, 460, 128, 14);
		contentPane.add(lblCredit);
	}
	
	private void btnAddCourseClick() {
		new AddCourseGUI(currUser).setVisible(true);
	}
	
	private void btnDropCourseClick() {
		new DropCourseGUI(currUser).setVisible(true);
	}
	
	private void btnLogOutClick() {
		new LoginGUI().setVisible(true);
		this.dispose();
	}
	
	private void refresh() {
		contentPane.remove(schedulePanel);;
		schedulePanel = new SchedulePanel(currUser.getEnrolledCourses());
		schedulePanel.setBounds(23, 22, 737, 437);
		contentPane.add(schedulePanel);
		
		contentPane.remove(lblCredit);
		lblCredit = new JLabel("Credit: " + currUser.getCurrentCredit() + " out of " + currUser.getCreditLimit());
		lblCredit.setBounds(23, 460, 128, 14);
		contentPane.add(lblCredit);
		
		contentPane.repaint();
	}
}
