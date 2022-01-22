

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BuyTickets extends JFrame {
	
	private JPanel topPanel, midPanel, botPanel;
	private JButton cancelBtn, buyBtn;
	private JLabel titleLabel;
	private BufferedImage image;
	public AffineTransform af = new AffineTransform();

	public BuyTickets() {
		// TODO Auto-generated constructor stub
		midPanel = new JPanel(new GridLayout());
		topPanel = new JPanel();
		botPanel = new JPanel();
		
		cancelBtn = initButton("CANCEL",203,245,219,80,25 );
		cancelBtn.setForeground(Color.white);
		cancelBtn.setFont(new Font("Calibri", 1, 20));
		buyBtn = new JButton("BUY");
		
		titleLabel = initLabel("Drag to Buy Ticket",20,71,195,208);
		
		try {
			image = ImageIO.read(new File("src/Assets/chair.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		addComponent();
		initFrame();
	}
	
	
	private void addComponent() {
		// TODO Auto-generated method stub
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		add(botPanel, BorderLayout.SOUTH);
		
		topPanel.add(cancelBtn);
		topPanel.add(titleLabel);
		
		
		
		
		botPanel.add(buyBtn);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 30, 30, 40, 40, null);
		g2.setTransform(af);
		
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(350, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		return btn;
	}

	public void paintSeat(Graphics g) {
		ImageIcon icon = new ImageIcon("src/Assets/chair.png");
		Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.drawImage(img, 0, 0, null);
	}
	
	public void paintUser(Graphics g) {
		ImageIcon icon = new ImageIcon("src/Assets/user2.png");
		Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.drawImage(img, 0, 0, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BuyTickets();
	}

}
