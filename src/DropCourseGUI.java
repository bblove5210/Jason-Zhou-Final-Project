import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DropCourseGUI extends JFrame {

	private Student currUser;
	private JPanel contentPane;
	private List<Course> currCourses;
	private JComboBox<String> comboBox;

	public DropCourseGUI(Student student) {
		this.currUser = student;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 385, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDrop = new JButton("Drop");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDropClick();
			}
		});
		btnDrop.setBounds(76, 136, 89, 23);
		contentPane.add(btnDrop);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClick();
			}
		});
		btnBack.setBounds(203, 136, 89, 23);
		contentPane.add(btnBack);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(40, 63, 286, 22);
		contentPane.add(comboBox);
		updateComboBox();
		
	}
	
	private void updateComboBox() {
		currCourses = currUser.getEnrolledCourses();
		comboBox.removeAllItems();
		comboBox.addItem("");
		for(Course course : currCourses) {
			comboBox.addItem(course.getName());
		}
	}
	
	private void btnDropClick() {
		int index = comboBox.getSelectedIndex() - 1;
		if(index == -1) {
			return;
		}
		EnrollmentManager.dropStudentfromCourse(currUser, currCourses.get(index));
		new MessageGUI("Course dropped successfully").setVisible(true);
		updateComboBox();
	}
	
	private void btnBackClick() {
		this.dispose();
	}
}
