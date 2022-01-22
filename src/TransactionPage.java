import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TransactionPage extends JFrame implements WindowListener{
	private JPanel midPanel;
	private JLabel titleLabel;
	private JButton backBtn;

	public TransactionPage() {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		initComponent();
		addComponent();
		initFrame();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(3,1));
		midPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		titleLabel = initLabel("Transaction History", 30, 184,80,66);
		backBtn = initButton("BACK",210,162,149,70,30);
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		midPanel.add(new TransactionPanel(3, "Avengers: Endgame"));
		midPanel.add(new TransactionPanel(1, "Stand by Me 2"));
		
		add(titleLabel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(backBtn, BorderLayout.SOUTH);
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(400, 500);
		setTitle("CinemaCC");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
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
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UserPage();
				TransactionPage.this.dispose();
			}
		});
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
