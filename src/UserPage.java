import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserPage extends JFrame implements WindowListener{
	private JPanel topPanel, midPanel, botPanel;
	private JMenuBar menuBar;
	private JMenuItem logoMenu, userMenu;
	private JLabel userLabel;
	private JButton tranBtn, updateBtn, soutBtn;

	public UserPage() {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		initComponent();
		addComponent();
		initFrame();
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(400, 500);
		setTitle("CinemaCC");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		topPanel.add(menuBar);
		menuBar.add(logoMenu);
		menuBar.add(userMenu);
		
		midPanel.add(userLabel);
		midPanel.add(tranBtn);
		midPanel.add(updateBtn);
		
		botPanel.add(soutBtn);
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		topPanel = new JPanel();
		topPanel.setBackground(new Color(252,236,220));
		midPanel = new JPanel(new GridLayout(3,1));
		midPanel.setBorder(new EmptyBorder(0, 0, 100, 0));
		midPanel.setBackground(new Color(234,230,223));
		botPanel = new JPanel();
		botPanel.setBackground(new Color(234,230,223));
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(252,236,220));
		ImageIcon icon = new ImageIcon("Assets/logo.png");
		Image img = icon.getImage().getScaledInstance(70, 40, Image.SCALE_SMOOTH);
		logoMenu = new JMenuItem(new ImageIcon(img));
		logoMenu.setBorder(new EmptyBorder(0, 0, 0, 180));
		logoMenu.setBackground(new Color(252,236,220));
		logoMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoMenu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new MainPage();
				UserPage.this.dispose();
			}
		});
		
		ImageIcon icon2 = new ImageIcon("Assets/user.png");
		Image img2 = icon2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		userMenu = new JMenuItem(new ImageIcon(img2));
		userMenu.setBackground(new Color(252,236,220));
		
		userLabel = initLabel("Clarissa",30,212,169,158);
		tranBtn = initButton("Transactions",234,230,223,500,50);
		tranBtn.setForeground(new Color(212,169,158));
		tranBtn.setFont(new Font("Calibri", 1, 25));
		tranBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TransactionPage();
				UserPage.this.dispose();
			}
		});
		updateBtn = initButton("Update Account",234,230,223,500,50);
		updateBtn.setForeground(new Color(212,169,158));
		updateBtn.setFont(new Font("Calibri", 1, 25));
		soutBtn = new JButton("SIGN OUT");
		soutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new LoginPage();
				UserPage.this.dispose();
			}
		});
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
		return btn;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Cannot close the frame", "Warning", JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
