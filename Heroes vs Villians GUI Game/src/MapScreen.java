import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapScreen {

	private JFrame frame;
	private GUI_MAIN manager;
	
	
	/**
	 * Create the application.
	 */
	public MapScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */

	public void closeWindow() {
		manager.closeMapScreen(this);
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
					MapScreen window = new MapScreen();
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
	public MapScreen() {
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
		
		JLabel North = new JLabel("");
		North.setBounds(279, 12, 140, 140);
		North.setIcon(new ImageIcon(MapScreen.class.getResource(manager.northIcon)));
		North.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.northIcon)).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		frame.getContentPane().add(North);
				
		JLabel South = new JLabel("");
		South.setBounds(279, 338, 140, 140);
		South.setIcon(new ImageIcon(MapScreen.class.getResource(manager.southIcon)));
		South.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.southIcon)).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		frame.getContentPane().add(South);
				
		JLabel West = new JLabel("");
		West.setBounds(24, 170, 140, 140);
		West.setIcon(new ImageIcon(MapScreen.class.getResource(manager.westIcon)));
		West.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.westIcon)).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		frame.getContentPane().add(West);
				
		JLabel East = new JLabel("");
		East.setBounds(543, 170, 140, 140);
		East.setIcon(new ImageIcon(MapScreen.class.getResource(manager.eastIcon)));
		East.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.eastIcon)).getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH)));
		frame.getContentPane().add(East);


		JButton btnClose = new JButton("Close");
		btnClose.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnClose.setBounds(41, 60, 117, 31);
		frame.getContentPane().add(btnClose);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(MapScreen.class.getResource("/Images/Map_Background.png")));
		Background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Map_Background.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		Background.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(Background);
	}
}
