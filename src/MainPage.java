import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame{
	private JPanel topPanel, midPanel;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private Vector<String> listFiles = new Vector<>();
	private Vector<String> listLogo = new Vector<>();
	
	public MainPage() {
		// TODO Auto-generated constructor stub
		
		initComponent();
		initImage();
		initLogo();
		addComponent();
		initFrame();
	}

	
	
	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(325, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CinemaCC");
		setResizable(false);
		setVisible(true);
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		add(topPanel, BorderLayout.NORTH);
		add(midPanel, BorderLayout.CENTER);
		topPanel.add(menuBar);
		JScrollPane pane = new JScrollPane(midPanel);
		add(pane, BorderLayout.CENTER);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		topPanel = new JPanel();
		topPanel.setBackground(new Color(252,236,220,255));
		midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(3,2));
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(252,236,220,255));
		menuItem = new JMenuItem("User");
		listFiles.add("Assets/poster1.jpg");
		listFiles.add("Assets/poster2.jpg");
		listFiles.add("Assets/poster3.jpg");
		listFiles.add("Assets/poster4.jpg");
		listFiles.add("Assets/poster5.jpg");
		listFiles.add("Assets/poster6.jpg");
		listLogo.add("Assets/logo.png");
		listLogo.add("Assets/user.png");
	}
	
	private void initLogo() {
		for(String s : listLogo) {
			ImageIcon io = new ImageIcon(s);
			Image img = io.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH);
			JLabel lab = new JLabel(new ImageIcon(img));
			menuBar.add(lab);
			lab.setBorder(new EmptyBorder(10, 10, 10, 10));
			lab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lab.addMouseListener(new MouseListener() {
				
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
					new UserPage();
					MainPage.this.dispose();
				}
			});
		}
	}

	private void initImage() {
		for(String s : listFiles) {
			ImageIcon io = new ImageIcon(s);
			Image img = io.getImage().getScaledInstance(125, 185, Image.SCALE_SMOOTH);
			JLabel lab = new JLabel(new ImageIcon(img));
			midPanel.add(lab);
			lab.setBorder(new EmptyBorder(10, 10, 10, 10));
			lab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lab.addMouseListener(new MouseListener() {
				
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
					if(s == "Assets/poster1.jpg") {
						String name = "Five Feet Apart";
						String author = "Rachael Lippincott";
						String synopsis = "A pair of teenagers with cystic fibrosis meet in a hospital and fall in love, though their disease means they must avoid close physical contact.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}else if(s == "Assets/poster2.jpg") {
						String name = "Avengers: Endgame";
						String author = "Stan Lee";
						String synopsis = "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}else if(s == "Assets/poster3.jpg") {
						String name = "Spongebob Movie: Sponge on the Run";
						String author = "Tim Hill";
						String synopsis = "When SpongeBob SquarePants' beloved pet snail Gary goes missing, a path of clues leads SpongeBob and his best friend Patrick to the powerful King Poseidon, who has Gary held captive in the Lost City of Atlantic City. On their mission to save Gary, SpongeBob and the Bikini Bottom gang team up for a heroic and hilarious journey, where they discover nothing is stronger than the power of friendship.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}else if(s == "Assets/poster4.jpg") {
						String name = "Stand By Me 2";
						String author = "Takashi Yamazaki & Ryuichi Yagi";
						String synopsis = "Film celebrating the 50th anniversary of \"Doraemon.\" This 3DCG animation recreates an episode about Nobita and his grandma from the original work. STAND BY ME DORAEMON director Yamazaki Takashi returns to helm this sequel with Yagi Ryuichi as co-director. Nobita finds a teddy bear hand sewn by his beloved grandma. The memories trigger a torrent of tears for Nobita, who asks Doraemon if they can use the time machine to visit the past.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}else if(s == "Assets/poster5.jpg") {
						String name = "Me Before You";
						String author = "Thea Sharrock";
						String synopsis = "Young and quirky Louisa \"Lou\" Clark (Emilia Clarke) moves from one job to the next to help her family make ends meet. Her cheerful attitude is put to the test when she becomes a caregiver for Will Traynor (Sam Claflin), a wealthy young banker left paralyzed from an accident two years earlier. Will's cynical outlook starts to change when Louisa shows him that life is worth living. As their bond deepens, their lives and hearts change in ways neither one could have imagined.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}else if(s == "Assets/poster6.jpg") {
						String name = "Joker";
						String author = "Todd Phillips";
						String synopsis = "Forever alone in a crowd, failed comedian Arthur Fleck seeks connection as he walks the streets of Gotham City. Arthur wears two masks -- the one he paints for his day job as a clown, and the guise he projects in a futile attempt to feel like he's part of the world around him. Isolated, bullied and disregarded by society, Fleck begins a slow descent into madness as he transforms into the criminal mastermind known as the Joker.";
						new MovieDetail(s,name,author,synopsis);
						MainPage.this.dispose();
					}
				}
			});
		}
	}

	
	

}
