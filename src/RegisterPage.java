import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class RegisterPage extends JFrame implements ActionListener{

	
	private JPanel topPanel, midPanel, botPanel, genderPanel;
	private JLabel regLabel, nameLabel, emailLabel, passLabel, phoneLabel, dobLabel, genderLabel, cityLabel, agreeLabel;
	private JButton submitBtn, backBtn;
	private JTextField nameField, emailField, phoneField;
	private JPasswordField passField;
	private JDateChooser dobCal;
	private JRadioButton maleBtn, femaleBtn;
	private JComboBox<String> cityBox;
	private String[] cityList = {"--Select city--","Jakarta", "Bogor", "Depok", "Tanggerang", "Bekasi", "Bandung"};
	private JCheckBox agreeBox;
	private ButtonGroup genderGroup;
	
	public RegisterPage() {
		
		// TODO Auto-generated constructor stub
		topPanel = initPanel(new FlowLayout(), 238, 227, 221);
		midPanel = initPanel(new GridLayout(7,2), 238, 227, 221);
		botPanel = initPanel(new FlowLayout(), 238, 227, 221);
		genderPanel = initPanel(new FlowLayout(), 238, 227, 221);
		topPanel.setBorder(new EmptyBorder(10, 0, 0, 110));

		
		
		regLabel = initLabel("Register", 15, 103, 96, 95);
		regLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		regLabel.setBorder(new EmptyBorder(0, 40, 0, 0));
		nameLabel = initLabel("Name", 15, 217, 149, 132);
		emailLabel = initLabel("Email", 15, 217, 149, 132);
		passLabel = initLabel("Password", 15, 217, 149, 132);
		phoneLabel = initLabel("Phone Number", 15, 217, 149, 132);
		dobLabel = initLabel("DOB", 15, 217, 149, 132);
		genderLabel = initLabel("Gender", 15, 217, 149, 132);
		cityLabel = initLabel("City", 15, 217, 149, 132);
		agreeLabel = initLabel("I Agree to the Terms and Conditions", 11, 217, 149, 132);
		
		nameField = initField(); nameField.setToolTipText("Must be between 5 - 20 characters");
		emailField = initField();
		phoneField = initField();
		passField = new JPasswordField();
		
		submitBtn = initButton("Submit", 247, 200, 187, 100, 30);
		backBtn = initButton("BACK", 103, 96, 95, 70, 30);
		backBtn.setForeground(Color.white);
		
		dobCal = new JDateChooser();
		
		genderGroup = new ButtonGroup();
		maleBtn = initRadioButton("Male");
		femaleBtn = initRadioButton("Female");
		
		cityBox = new JComboBox<>(cityList);
		
		agreeBox = new JCheckBox();
		
		addComponent();
		initFrame();
	}
	
	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		
		topPanel.add(backBtn);
		topPanel.add(regLabel);
		backBtn.addActionListener(this);
		
		
		midPanel.add(nameLabel);
		midPanel.add(nameField);
		midPanel.add(emailLabel);
		midPanel.add(emailField);
		midPanel.add(passLabel);
		midPanel.add(passField);
		midPanel.add(phoneLabel);
		midPanel.add(phoneField);
		midPanel.add(dobLabel);
		midPanel.add(dobCal);
		midPanel.add(genderLabel);
		midPanel.add(genderPanel);
		midPanel.add(cityLabel);
		midPanel.add(cityBox);
		
		genderGroup.add(maleBtn);
		genderGroup.add(femaleBtn);
		genderPanel.add(maleBtn);
		genderPanel.add(femaleBtn);
		
		botPanel.add(agreeBox);
		botPanel.add(agreeLabel);
		botPanel.add(submitBtn);
		submitBtn.addActionListener(this);
	}

	public JRadioButton initRadioButton(String str) {
		JRadioButton rad = new JRadioButton(str);
		rad.setBackground(new Color(238, 227, 221));
		rad.setFont(new Font("Calibri", 0, 13));
		rad.setForeground(Color.BLACK);
		return rad;
	}
	
	public JTextField initField() {
		JTextField tf = new JTextField();
		tf.setPreferredSize(new Dimension(150, 30));
		return tf;
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
	
	public void errorMessage(String str) {
		JOptionPane.showMessageDialog(null, str, "Invalid Input",JOptionPane.WARNING_MESSAGE);
	
	}
	
	public void ValidateData() {
		String name = nameField.getText();
		String pass = passField.getText();
		String email = emailField.getText();
		String phone = phoneField.getText();
		
		if (name.length() < 5 || name.length() > 20 || name.isEmpty()) {
			errorMessage("Name must be between 5 - 20");
		} else if (pass.length() < 5 && !pass.contains("[0-9a-zA-Z]")) {
			errorMessage("Password must be at least 5 and alphanumeric");
		} else if (!email.contains("@")) {
			errorMessage("Email must be in correct format");
		} else if (!phone.startsWith("+62")) {
			errorMessage("Phone number must begin with '+62'");
		} else if (!maleBtn.isSelected() && !femaleBtn.isSelected()) {
			errorMessage("Please choose your gender!");
		} else if (!agreeBox.isSelected()) {
			errorMessage("Check the terms and condition");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submitBtn) {
			ValidateData();
			new LoginPage();
		}else if (e.getSource() == backBtn) {
			new LoginPage();
			this.dispose();
		}
	}

}
