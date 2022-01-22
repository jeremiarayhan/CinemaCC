import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class TrailerPage implements ActionListener{
	private JFrame frame;
	private JPanel botPanel;
	private JButton playBtn, stopBtn, backBtn;
	private EmbeddedMediaPlayerComponent mediaPlayer;
	private String vlcPath = "C:\\Program Files\\VideoLAN\\VLC";

	public TrailerPage(String video) {
		// TODO Auto-generated constructor stub
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
		mediaPlayer = new EmbeddedMediaPlayerComponent();
		
		initComponent();
		addComponent();
		initFrame();
		initPlay(video);
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		botPanel = new JPanel();
		
		playBtn = initButton("Play/Pause",255,133,122,100,30);
		stopBtn = initButton("Stop",255,133,122,70,30);
		backBtn = initButton("Back",255,133,122,70,30);
		
	}

	private void addComponent() {
		// TODO Auto-generated method stub
		botPanel.add(playBtn);
		botPanel.add(stopBtn);
		botPanel.add(backBtn);
		
		frame.add(mediaPlayer, BorderLayout.CENTER);
		frame.add(botPanel, BorderLayout.SOUTH);
		
	}

	private void initFrame() {
		// TODO Auto-generated method stub
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void initPlay(String video) {
		// TODO Auto-generated method stub
		mediaPlayer.getMediaPlayer().playMedia(video);
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
		boolean stop = false;
		if(e.getSource() == playBtn && stop == false) {
			mediaPlayer.getMediaPlayer().pause();
		}else if(e.getSource() == stopBtn) {
			stop = true;
			mediaPlayer.getMediaPlayer().stop();
		}if(e.getSource() == playBtn && stop == true) {
			mediaPlayer.getMediaPlayer().play();
		}else if(e.getSource() == backBtn) {
			mediaPlayer.getMediaPlayer().stop();
			frame.dispose();
		}
	}
	
}
