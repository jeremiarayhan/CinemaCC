import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.jna.NativeLibrary;



public class LoginPage extends JFrame implements ActionListener {

	private JPanel topPanel, midPanel, botPanel;
	private JLabel topLabel, emailLabel, passLabel, regLabel;
	private JTextField emailField;
	private JPasswordField passField;
	private JButton submitBtn, regBtn;
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
		topPanel = initPanel(new FlowLayout(), 251, 203, 177); 
		midPanel = initPanel(new GridLayout(2, 2), 251, 203, 177);
		botPanel = initPanel(new GridLayout(2, 1), 251, 203, 177);
		
		topLabel = initLabel("Login", 40,148,86,73);
		topLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		emailLabel = initLabel("Email", 20,148,86,73);
		passLabel = initLabel("Password", 20,148,86,73);
		regLabel = initLabel("Register", 15,148,86,73);
		
		emailField = new JTextField();
		passField = new JPasswordField();
		
		submitBtn = initButton("Submit",219,107,90, 100, 30);
		regBtn = initButton("Register Here",251, 203, 177, 100, 30);
		regBtn.setBorderPainted(false);
		
		addComponent();
		initFrame();
	}
	
	
	public void initFrame() {
		// TODO Auto-generated method stub
		setSize(350, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		
		topPanel.add(topLabel);
		
		midPanel.add(emailLabel);
		midPanel.add(emailField);
		midPanel.add(passLabel);
		midPanel.add(passField);
		
		emailField.setPreferredSize(new Dimension(100, 20));
		passField.setPreferredSize(new Dimension(100, 20));
		
		botPanel.add(submitBtn);
		botPanel.add(regBtn);
	}

	public JPanel initPanel(LayoutManager lm, Integer r, Integer g, Integer b) {
		JPanel panel = new JPanel(lm);
		panel.setBackground(new Color(r, g, b, 255));
		panel.setBorder(new EmptyBorder(10, 10, 10, 20));
		return panel;
	}
	
	public JLabel initLabel(String str, Integer size, Integer r, Integer g, Integer b) {
		JLabel label = new JLabel(str);
		label.setForeground(new Color(r,g,b));
		label.setFont(new Font("Calibri", 1, size));
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		return label;
	}
	
	public JButton initButton(String str, Integer r, Integer g, Integer b, Integer width, Integer height) {
		JButton btn = new JButton(str);
		btn.setBackground(new Color(r,g,b));
		btn.setPreferredSize(new Dimension(width, height));
		btn.addActionListener(this);
		return btn;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submitBtn) {
			validateData();
			new MainPage();
			this.dispose();
			
		} else if(e.getSource() == regBtn) {
			new RegisterPage();
			this.dispose();
		}
	}

	private void validateData() {
		String email = emailField.getText();
		String pass = passField.getText();
		
		if (email.isEmpty()) {
			errorMessage("Email must not be empty");
		} else if (pass.isEmpty()) {
			errorMessage("Password must not be empty");
		} 
	}
	
	public void errorMessage(String str) {
		JOptionPane.showMessageDialog(null, str, "Invalid Input",JOptionPane.WARNING_MESSAGE);
	
	}
}
