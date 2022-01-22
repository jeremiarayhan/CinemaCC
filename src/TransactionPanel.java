import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TransactionPanel extends JPanel{
	private JLabel titleLabel, qntLabel, priceLbl;

	public TransactionPanel(int number, String title) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(246,114,128));
		setLayout(new GridLayout(3,1));
		this.setBorder(new EmptyBorder(20, 20, 20, 20));
		initComponent(number, title);
		addComponent();
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		add(titleLabel);
		add(qntLabel);
		add(priceLbl);
	}

	private void initComponent(int number, String title) {
		// TODO Auto-generated method stub
		titleLabel = initLabel(title, 20);
		qntLabel = initLabel("Ticket Qty  : " + number, 20);
		priceLbl = initLabel("Total Price : " + number*50000, 20);
	}
	
	private JLabel initLabel(String str, Integer size) {
		JLabel label = new JLabel(str);
		label.setForeground(Color.white);
		label.setFont(new Font("Calibri", 1, size));
		return label;
	}

}
