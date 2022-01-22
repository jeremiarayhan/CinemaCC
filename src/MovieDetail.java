import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MovieDetail extends JFrame implements ActionListener{
	
	private JPanel topPanel, leftPanel, rightPanel, botPanel;
	private JButton backBtn, watchBtn, ticketBtn;
	private JLabel movieTitle, movieImg, authorTxt, durationTxt, synTxt;
	private JTextArea descTxt;

	public MovieDetail(String str, String name, String author, String synopsis) {
		// TODO Auto-generated constructor stub
		ImageIcon icon = new ImageIcon(str);
		Image img = icon.getImage().getScaledInstance(128, 185, Image.SCALE_SMOOTH);
		movieImg = new JLabel(new ImageIcon(img));
		
		topPanel = initPanel(new FlowLayout(FlowLayout.LEFT),246,239,231);
		leftPanel = initPanel(new FlowLayout(FlowLayout.LEFT),246,239,231);
		rightPanel = initPanel(new GridLayout(3,1,0,40),246,239,231);
		botPanel = initPanel(new GridLayout(3,1), 246,239,231);
		
		backBtn = initButton("BACK",254,217,201,70,30);
		backBtn.setForeground(Color.white);
		watchBtn = initButton("WATCH TRAILER",193,225,210,130,30);
		watchBtn.setForeground(Color.white);
		ticketBtn = initButton("BUY TICKETS",193,225,210,130,30);
		
		movieTitle = initLabel(name,20,211,152,125);
		authorTxt = initLabel("Author : " + author,15,211,152,125);
		durationTxt = initLabel("Duration : 117 min",15,211,152,125);
		synTxt = initLabel("Synopsis : " + synopsis,15,211,152,125);
		
		
		addComponent();
		initFrame();
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		add(topPanel, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(botPanel, BorderLayout.SOUTH);
		
		topPanel.add(movieTitle);
		leftPanel.add(movieImg);
		rightPanel.add(backBtn);
		rightPanel.add(watchBtn);
		rightPanel.add(ticketBtn);
		botPanel.add(authorTxt);
		botPanel.add(durationTxt);
		botPanel.add(synTxt);
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CinemaCC");
		setResizable(true);
		setVisible(true);
	}

	public JLabel initLabel(String str, Integer size, Integer r, Integer g, Integer b) {
		JLabel label = new JLabel(str);
		label.setForeground(new Color(r,g,b));
		label.setFont(new Font("Calibri", 1, size));
		label.setBorder(new EmptyBorder(10, 10, 10, 10));
		return label;
	}
	
	public JPanel initPanel(LayoutManager lm, Integer r, Integer g, Integer b) {
		JPanel panel = new JPanel(lm);
		panel.setBackground(new Color(r, g, b, 255));
		panel.setBorder(new EmptyBorder(10, 10, 10, 20));
		return panel;
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
		String title = movieTitle.getText();
		if(e.getSource() == backBtn) {
			new MainPage();
			this.dispose();
		}else if(e.getSource() == watchBtn && title == "Five Feet Apart") {
			String video = "Assets/trailer1.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == watchBtn && title == "Avengers: Endgame") {
			String video = "Assets/trailer2.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == watchBtn && title == "Spongebob Movie: Sponge on the Run") {
			String video = "Assets/trailer3.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == watchBtn && title == "Stand By Me 2") {
			String video = "Assets/trailer4.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == watchBtn && title == "Me Before You") {
			String video = "Assets/trailer5.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == watchBtn && title == "Joker") {
			String video = "Assets/trailer6.mp4";
			new TrailerPage(video);
		}else if(e.getSource() == ticketBtn && title == "Five Feet Apart") {
			new TicketPage(title);
		}else if(e.getSource() == ticketBtn && title == "Avengers: Endgame") {
			new TicketPage(title);
		}else if(e.getSource() == ticketBtn && title == "Spongebob Movie: Sponge on the Run") {
			new TicketPage(title);
		}else if(e.getSource() == ticketBtn && title == "Stand By Me 2") {
			new TicketPage(title);
		}else if(e.getSource() == ticketBtn && title == "Me Before You") {
			new TicketPage(title);
		}else if(e.getSource() == ticketBtn && title == "Joker") {
			new TicketPage(title);
		}
	}

}
