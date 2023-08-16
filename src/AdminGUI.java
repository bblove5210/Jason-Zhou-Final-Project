import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class AdminGUI extends JFrame {

	private Administrator currUser;
	private JPanel contentPane;
	private JButton btnCreateCourse;
	private JButton btnDeleteCourse;
	private JButton btnViewStudents;
	private JButton btnLogOut;

	public AdminGUI(Administrator admin) {
		this.currUser = admin;
		
		setResizable(false);
		setTitle("Admin Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateCourse = new JButton("Create Course");
		btnCreateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateCourseClick();
			}
		});
		btnCreateCourse.setBounds(103, 61, 136, 43);
		contentPane.add(btnCreateCourse);
		
		btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteCourseClick();
			}
		});
		btnDeleteCourse.setBounds(103, 129, 136, 43);
		contentPane.add(btnDeleteCourse);
		
		btnViewStudents = new JButton("View Students");
		btnViewStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewStudentsClick();
			}
		});
		btnViewStudents.setBounds(103, 196, 136, 43);
		contentPane.add(btnViewStudents);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogOutClick();
			}
		});
		btnLogOut.setBounds(126, 271, 89, 23);
		contentPane.add(btnLogOut);
	}

	private void btnCreateCourseClick() {
		new CreateCourseGUI(currUser).setVisible(true);
	}
	
	private void btnDeleteCourseClick() {
		new DeleteCourseGUI(currUser).setVisible(true);
	}
	
	private void btnViewStudentsClick() {
		new ViewStudentsGUI(currUser).setVisible(true);
	}
	
	private void btnLogOutClick() {
		new LoginGUI().setVisible(true);
		this.dispose();
	}
}
