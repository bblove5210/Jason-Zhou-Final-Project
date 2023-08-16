import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class DeleteCourseGUI extends JFrame {

	private Administrator currUser;
	private JPanel contentPane;
	private List<Course> allCourses;
	private CourseTable courseTable;
	private JButton btnDelete;
	private JButton btnBack;

	public DeleteCourseGUI(Administrator admin) {
		this.currUser = admin;
		this.allCourses = CourseList.getInstance().getAllCourses();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 575, 342);
		contentPane.add(scrollPane);
		
		courseTable = new CourseTable(allCourses);
		scrollPane.setViewportView(courseTable);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClick();
			}
		});
		btnDelete.setBounds(138, 364, 99, 37);
		contentPane.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClick();
			}
		});
		btnBack.setBounds(357, 364, 99, 37);
		contentPane.add(btnBack);
	}
	
	private void btnDeleteClick() {
		int index = courseTable.getSelectedRow();
		currUser.deleteCourse(allCourses.get(index));
		new MessageGUI("Course deleted successfully").setVisible(true);
		this.dispose();
	}
	
	private void btnBackClick() {
		this.dispose();
	}
}
