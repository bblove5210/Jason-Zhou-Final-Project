import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateCourseGUI extends JFrame {

	private Administrator currUser;
	private JPanel contentPane;
	private JTextField txtFieldCourseName;
	private JTextField txtFieldLocation;
	private JTextField textFieldInstructor;
	private JCheckBox[] checkBoxWeekday = new JCheckBox[5];
	private JComboBox<String> comboBoxCredit;
	private JComboBox<String> comboBoxStartingHour;
	private JComboBox<String> comboBoxStartingMinute;
	private JComboBox<String> comboBoxEndingHour;
	private JComboBox<String> comboBoxEndingMinute;
	private JButton btnCreate;
	private JButton btnBack;
	
	private final int earliestHour = 8;
	private final int latestHour = 20;

	public CreateCourseGUI(Administrator admin) {
		this.currUser = admin;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseName.setBounds(55, 38, 89, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblStartingTime = new JLabel("Starting Time");
		lblStartingTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartingTime.setBounds(55, 78, 89, 14);
		contentPane.add(lblStartingTime);
		
		JLabel lblEndingTime = new JLabel("Ending Time");
		lblEndingTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndingTime.setBounds(55, 118, 89, 14);
		contentPane.add(lblEndingTime);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocation.setBounds(55, 157, 89, 14);
		contentPane.add(lblLocation);
		
		JLabel lblInstructor = new JLabel("Instructor");
		lblInstructor.setBounds(55, 194, 89, 14);
		contentPane.add(lblInstructor);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(55, 236, 46, 14);
		contentPane.add(lblDays);
		
		JLabel lblMonday = new JLabel("Mon");
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setBounds(145, 220, 46, 14);
		contentPane.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tue");
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setBounds(197, 220, 46, 14);
		contentPane.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wed");
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setBounds(244, 220, 64, 14);
		contentPane.add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thu");
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setBounds(308, 220, 46, 14);
		contentPane.add(lblThursday);
		
		JLabel lblFriday = new JLabel("Fri");
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setBounds(363, 220, 46, 14);
		contentPane.add(lblFriday);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(55, 278, 46, 14);
		contentPane.add(lblCredit);
		
		checkBoxWeekday[0] = new JCheckBox("");
		checkBoxWeekday[0].setBounds(155, 241, 21, 23);
		contentPane.add(checkBoxWeekday[0]);
		
		checkBoxWeekday[1] = new JCheckBox("");
		checkBoxWeekday[1].setBounds(208, 241, 21, 23);
		contentPane.add(checkBoxWeekday[1]);
		
		checkBoxWeekday[2] = new JCheckBox("");
		checkBoxWeekday[2].setBounds(264, 241, 21, 23);
		contentPane.add(checkBoxWeekday[2]);
		
		checkBoxWeekday[3] = new JCheckBox("");
		checkBoxWeekday[3].setBounds(320, 241, 21, 23);
		contentPane.add(checkBoxWeekday[3]);
		
		checkBoxWeekday[4] = new JCheckBox("");
		checkBoxWeekday[4].setBounds(376, 241, 21, 23);
		contentPane.add(checkBoxWeekday[4]);
		
		txtFieldCourseName = new JTextField();
		txtFieldCourseName.setBounds(145, 35, 252, 20);
		contentPane.add(txtFieldCourseName);
		txtFieldCourseName.setColumns(10);
		
		txtFieldLocation = new JTextField();
		txtFieldLocation.setBounds(145, 154, 252, 20);
		contentPane.add(txtFieldLocation);
		txtFieldLocation.setColumns(10);
		
		textFieldInstructor = new JTextField();
		textFieldInstructor.setBounds(145, 191, 252, 20);
		contentPane.add(textFieldInstructor);
		textFieldInstructor.setColumns(10);
		
		comboBoxCredit = new JComboBox<>();
		comboBoxCredit.setBounds(145, 274, 46, 22);
		contentPane.add(comboBoxCredit);
		
		comboBoxStartingHour = new JComboBox<>();
		comboBoxStartingHour.setBounds(145, 74, 46, 22);
		contentPane.add(comboBoxStartingHour);
		
		comboBoxEndingHour = new JComboBox<>();
		comboBoxEndingHour.setBounds(145, 114, 46, 22);
		contentPane.add(comboBoxEndingHour);
		
		JLabel label = new JLabel(":");
		label.setBounds(197, 77, 4, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(197, 116, 4, 14);
		contentPane.add(label_1);
		
		comboBoxStartingMinute= new JComboBox<>();
		comboBoxStartingMinute.setBounds(206, 74, 46, 22);
		contentPane.add(comboBoxStartingMinute);
		
		comboBoxEndingMinute = new JComboBox<>();
		comboBoxEndingMinute.setBounds(208, 114, 44, 22);
		contentPane.add(comboBoxEndingMinute);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateClick();
			}
		});
		btnCreate.setBounds(123, 323, 89, 23);
		contentPane.add(btnCreate);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackClick();
			}
		});
		btnBack.setBounds(267, 323, 89, 23);
		contentPane.add(btnBack);
		
		initializeComboBox();
	}
	
	private void initializeComboBox() {
		comboBoxStartingHour.addItem("");
		comboBoxStartingMinute.addItem("");
		comboBoxEndingHour.addItem("");
		comboBoxEndingMinute.addItem("");
		comboBoxCredit.addItem("");
		
		for(int i=earliestHour; i<latestHour; ++i) {
			comboBoxStartingHour.addItem(String.format("%02d", i));
			comboBoxEndingHour.addItem(String.format("%02d", i));
		}
		for(int i=0; i<60; ++i) {
			comboBoxStartingMinute.addItem(String.format("%02d", i));
			comboBoxEndingMinute.addItem(String.format("%02d", i));
		}
		for(int i=0; i<7; ++i) {
			comboBoxCredit.addItem(Integer.toString(i));
		}
	}
	
	private void btnCreateClick() {
		int startingHour = comboBoxStartingHour.getSelectedIndex()-1+earliestHour;
		int startingMinute = comboBoxStartingMinute.getSelectedIndex()-1;
		int endingHour = comboBoxEndingHour.getSelectedIndex()-1+earliestHour;
		int endingMinute = comboBoxEndingMinute.getSelectedIndex()-1;
		int credit = comboBoxCredit.getSelectedIndex()-1;
		
		if(startingHour<earliestHour || startingMinute<0 || endingHour<earliestHour || endingMinute<0 || credit<0) {
			return;
		}
		
		Boolean[] weekdays = {false, false, false, false, false};
		for(int i=0; i<5; ++i) {
			if(checkBoxWeekday[i].isSelected()) {
				weekdays[i] = true;
			}
		}
		String name = txtFieldCourseName.getText().strip();
		String location = txtFieldLocation.getText().strip();
		String instructor = textFieldInstructor.getText().strip();
		int[] startingTime = {startingHour, startingMinute};
		int[] endingTime = {endingHour, endingMinute};
		
		if(!currUser.createCourse(name, instructor, location, credit, startingTime, endingTime, weekdays)) {
			new MessageGUI("Course creation failed. Invalid details").setVisible(true);;
			return;
		}
		new MessageGUI("Course creation successful").setVisible(true);;
		this.dispose();
	}
	
	private void btnBackClick() {
		this.dispose();
	}
}
