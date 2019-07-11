import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gameCleared {

	private JFrame frame;
	public GUI_MAIN manager;	

	public gameCleared(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeCleared(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void playAgain() {
		manager.closeCleared(this);
		manager.launchMainScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameCleared window = new gameCleared();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gameCleared() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(710, 530));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPlayAgain = new JButton("PLAY AGAIN");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAgain();
			}
		});
		btnPlayAgain.setBackground(Color.DARK_GRAY);
		btnPlayAgain.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPlayAgain.setForeground(Color.WHITE);
		btnPlayAgain.setBounds(373, 406, 158, 44);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.setFont(new Font("Dialog", Font.BOLD, 15));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBounds(194, 406, 158, 44);
		frame.getContentPane().add(btnClose);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(gameCleared.class.getResource("/Images/gameClearedScreen.png")));
		label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gameClearedScreen.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(label);
	}
}
