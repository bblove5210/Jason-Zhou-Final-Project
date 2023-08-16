import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class ViewStudentsGUI extends JFrame {

	private Administrator currUser;
	private List<Student> allStudents;
	private StudentTable studentTable;
	private JPanel contentPane;
	private JButton btnView;
	private JButton btnBack;

	public ViewStudentsGUI(Administrator admin) {
		this.currUser = admin;
		allStudents = currUser.getStudentList();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewClick();
			}
		});
		btnView.setBounds(138, 364, 99, 37);
		contentPane.add(btnView);
		
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
		
		studentTable = new StudentTable(allStudents);
		scrollPane.setViewportView(studentTable);
	}
	
	private void btnViewClick() {
		int index = studentTable.getSelectedRow();
		if(index == -1) {
			return;
		}
		Student student = allStudents.get(index);
		new ViewStudentScheduleGUI(currUser, student).setVisible(true);
	}
	
	private void btnBackClick() {
		this.dispose();
	}

	private class StudentTable extends JTable {
		private final static String[] columnNames = {"Name", "Username", "School Year", "Currect Credit"};
		
		public StudentTable(List<Student> studentList) {
			super(convertStudentListToData(studentList), columnNames);
			setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		}
		
		private static String[][] convertStudentListToData(List<Student> studentList){
			int length = studentList.size();
			String[][] data = new String[length][];
			int i = 0;
			for(Student student : studentList) {
				String[] entry = {student.getRealname(), student.getUsername(), student.getSchoolYear().toString(), student.getCurrentCredit() + " out of " + student.getCreditLimit()};
				data[i] = entry;
				++i;
			}
			return data;
		}
		
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}
