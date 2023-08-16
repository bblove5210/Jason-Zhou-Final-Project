import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUsername;
	private JPasswordField txtPasswordField;
	private JButton btnLogin;
	private JButton btnExit;

	public LoginGUI() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginClick();
			}
		});
		btnLogin.setBounds(172, 150, 89, 23);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitClick();
			}
		});
		btnExit.setBounds(172, 184, 89, 23);
		contentPane.add(btnExit);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setBounds(123, 66, 188, 20);
		contentPane.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(47, 69, 73, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(47, 112, 64, 14);
		contentPane.add(lblPassword);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(123, 109, 188, 20);
		contentPane.add(txtPasswordField);
	}
	
	private void btnLoginClick() {
		String username = txtFieldUsername.getText().strip();
		String password = txtPasswordField.getText();
		
		User user = Authenticator.validate(username, password);
		if(user == null) {
			new MessageGUI("Wrong username or password").setVisible(true);;
			return;
		} 
		
		if(user instanceof Student) {
			new StudentGUI((Student)user).setVisible(true);
		} else {
			new AdminGUI((Administrator)user).setVisible(true);
		}
		this.dispose();
	}
	
	private void btnExitClick() {
		this.dispose();
	}
}
