import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverScreen {

	private JFrame frame;
	public GUI_MAIN manager;	

	public GameOverScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeGameover(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void playAgain() {
		manager.closeGameover(this);
		manager.launchMainScreen();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverScreen window = new GameOverScreen();
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
	public GameOverScreen() {
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
		
		JButton btnEndGame = new JButton("END GAME");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnEndGame.setBackground(Color.DARK_GRAY);
		btnEndGame.setForeground(Color.WHITE);
		btnEndGame.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEndGame.setBounds(185, 308, 169, 58);
		frame.getContentPane().add(btnEndGame);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAgain();
			}
		});
		btnRestart.setForeground(Color.WHITE);
		btnRestart.setFont(new Font("Dialog", Font.BOLD, 18));
		btnRestart.setBackground(Color.DARK_GRAY);
		btnRestart.setBounds(379, 308, 169, 58);
		frame.getContentPane().add(btnRestart);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(OpeningLairScreen.class.getResource("/Images/Game_Over_Screen.png")));
		label.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Game_Over_Screen.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		label.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(label);
	}

}
