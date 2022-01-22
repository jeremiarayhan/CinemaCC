import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class WelcomePage extends JFrame implements MouseListener {
	
	private JPanel bgrPanel;
	private JLabel nextImg, nextLbl;
	private String vlcPath = "C:\\Program Files\\VideoLAN\\VLC";
	private String audioPath = "Assets\\music.mp3";
	private EmbeddedMediaPlayer player;
	

	
	public WelcomePage() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		player = new MediaPlayerFactory().newEmbeddedMediaPlayer();
		player.prepareMedia(audioPath);
		bgrPanel = new JPanel();
		
		nextImg = initNext("Assets\\next.png");
		nextLbl = new JLabel("NEXT");
		nextLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		setBackground();
		addComponent();
		initFrame();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WelcomePage();
	}
	
	private void setBackground() {
		try {
			bgrPanel = new JPanel(new BorderLayout()) {
				Image img = ImageIO.read(new File("Assets/wp3.png"));
				
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(img, 0, 0, 325, 500, null);
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addComponent() {
		// TODO Auto-generated method stub
		player.play();
		add(bgrPanel);
		bgrPanel.add(nextImg, BorderLayout.SOUTH);
		nextImg.addMouseListener(this);
		nextLbl.addMouseListener(this);
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		setSize(325, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("CinemaCC");
		setResizable(true);
		setVisible(true);
	}

	public JLabel initNext(String str) {
		ImageIcon iconNxt = new ImageIcon(str);
		Image img = iconNxt.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(img));
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return label;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextImg) {
			new LoginPage();
			this.dispose();
			player.stop();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
