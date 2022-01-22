import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TicketPage extends JFrame implements WindowListener{
	private JPanel topPanel, midPanel, botPanel;
	private JButton cancelBtn, buyBtn;
	private JLabel titleLabel;
	private Vector<String> listChair = new Vector<>();
//	private BufferedImage img1, img2;
	private int imageWidth = 40, imageHeight = 40;
	ImageIcon iconUser = new ImageIcon("Assets/user2.png");
	Image imgUser = iconUser.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
	JLabel userImg = new JLabel(new ImageIcon(imgUser));
	int imageX = 226, imageY = 447;
	

	public TicketPage(String title) {
		// TODO Auto-generated constructor stub
		
		initComponent();
		initLogo();
		addComponent(title);
		initFrame();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		
		g2.drawImage(imgUser, imageX, imageY, botPanel);
	}
	
	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(400, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CinemaCC");
		setResizable(false);
		setVisible(true);
		addWindowListener(this);
	}
	
	private void initLogo() {
		for(String s : listChair) {
			ImageIcon io = new ImageIcon(s);
			Image img = io.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			JLabel lab = new JLabel(new ImageIcon(img));
			midPanel.add(lab);
			lab.setBorder(new EmptyBorder(0, 2, 0, 2));
		}
	}

	private void addComponent(String title) {
		// TODO Auto-generated method stub
		topPanel.add(cancelBtn);
		topPanel.add(titleLabel);
		
		botPanel.add(buyBtn);
		botPanel.add(userImg);
		
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		
		userImg.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				imageX = e.getX();
				imageY = e.getY();
				repaint(imageX, imageY, imageWidth, imageHeight);
			}
		});
		
		buyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String quantity = JOptionPane.showInputDialog("Ticket Quantity");
				int number = Integer.parseInt(quantity);
				JOptionPane.showConfirmDialog(rootPane, "Your order was successful", "Order Confrimation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				new TransactionPanel(number, title);
				TicketPage.this.dispose();
			}
				
		});
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		topPanel = new JPanel();
		topPanel.setBackground(new Color(255,248,230));
		midPanel = new JPanel(new GridLayout(5,5));
		midPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
		midPanel.setBackground(new Color(255,248,230));
		botPanel = new JPanel();
		botPanel.setBackground(new Color(255,248,230));
		
		cancelBtn = initButton("CANCEL",203,245,219,90,30);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TicketPage.this.dispose();
			}
		});
		buyBtn = initButton("BUY",203,245,219,90,30);
		
		titleLabel = initLabel("Drag to Buy Ticket",30,110,164,173);
		
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
		listChair.add("Assets/chair.png");
	}

	
	public JButton initButton(String str, Integer r, Integer g, Integer b, Integer width, Integer height) {
		JButton btn = new JButton(str);
		btn.setBackground(new Color(r,g,b));
		btn.setPreferredSize(new Dimension(width, height));
		return btn;
	}
	
	public JLabel initLabel(String str, Integer size, Integer r, Integer g, Integer b) {
		JLabel label = new JLabel(str);
		label.setForeground(new Color(r,g,b));
		label.setFont(new Font("Calibri", 1, size));
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		return label;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Frame cannot be closed", "Warning", JOptionPane.OK_CANCEL_OPTION);
		
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
