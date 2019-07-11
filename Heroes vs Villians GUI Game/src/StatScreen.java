import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class StatScreen {

	private JFrame frame;
	private GUI_MAIN manager;
	private final JLabel lblNewLabel = new JLabel("Stat Image");
	
	/**
	 * Create the application.
	 */
	public StatScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void closeWindow() {
		manager.closeStatScreen(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatScreen window = new StatScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public StatScreen() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(710, 530));
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnClose.setBounds(39, 24, 117, 31);
		frame.getContentPane().add(btnClose);
		lblNewLabel.setIcon(new ImageIcon(StatScreen.class.getResource("/Images/Hero_Stats__updated_.png")));
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Stats__updated_.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(0, 0, 708, 506);
		frame.getContentPane().add(lblNewLabel);
	}
}
