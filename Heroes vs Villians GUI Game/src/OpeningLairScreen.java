import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpeningLairScreen {

	private JFrame frame;
	public GUI_MAIN manager;
	
	public OpeningLairScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeOpenScreen(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void goBackHome() {
		manager.closeOpenScreen(this);
		manager.launchHomeScreen();
	}
	
	public void goVillainsLair() {
		manager.closeOpenScreen(this);
		manager.launchVillainGameGUI();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningLairScreen window = new OpeningLairScreen();
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
	public OpeningLairScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(710, 530));
		frame.getContentPane().setMinimumSize(new Dimension(730, 500));
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackHome();
			}
		});
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBack.setBounds(359, 291, 201, 59);
		frame.getContentPane().add(btnBack);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goVillainsLair();
			}
		});
		btnEnter.setBackground(Color.DARK_GRAY);
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEnter.setBounds(132, 291, 201, 59);
		frame.getContentPane().add(btnEnter);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpeningLairScreen.class.getResource("/Images/Villains_Open_Screen.png")));
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Villains_Open_Screen.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
