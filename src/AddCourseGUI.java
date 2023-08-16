import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AddCourseGUI extends JFrame {
	private Student currUser;
	private List<Course> allCourses;
	private JPanel contentPane;
	private CourseTable courseTable;
	private JButton btnAdd;
	private JButton btnBack;

	public AddCourseGUI(Student student) {
		this.currUser = student;
		allCourses = CourseList.getInstance().getAllCourses();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddClick();
			}
		});
		btnAdd.setBounds(138, 364, 99, 37);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClick();
			}
		});
		btnBack.setBounds(357, 364, 99, 37);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 575, 342);
		contentPane.add(scrollPane);
		
		courseTable = new CourseTable(allCourses);
		scrollPane.setViewportView(courseTable);
		
	}
	
	private void btnAddClick() {
		int index = courseTable.getSelectedRow();
		if(index == -1) {
			return;
		}
		switch(EnrollmentManager.enrollStudentInCourse(currUser, allCourses.get(index))) {
			case 0:
				new MessageGUI("Course added successfully").setVisible(true);
				return;
			case 1:
				new MessageGUI("Add course failed. Already taking course").setVisible(true);
				return;
			case 2:
				new MessageGUI("Add course failed. Exceeding credit limit").setVisible(true);
				return;
			case 3:
				new MessageGUI("Add course failed. Schedule conflict").setVisible(true);
				return;
			default:
				return;
		}
	}
	
	private void btnBackClick() {
		this.dispose();
	}
}
