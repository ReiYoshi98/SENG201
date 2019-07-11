import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class HomebaseScreen {

	private JFrame frame;
	private GUI_MAIN manager;
	public Wizard wizard;
	Random ranNum = new Random();
	int gift;
	
	public HomebaseScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeHomeScreen(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void openHospital() {						// Method for switching to the Hospital GUI (Entering the hospital)
		manager.closeHomeScreen(this);
		manager.launchHospital();
	}
	
	public void openItemShop() {						// Method for switching to the Item Shop GUI (Entering the item shop)
		manager.closeHomeScreen(this);
		manager.launchItemShop();
	}
	
	public void openPowerupDen() {						// Method for switching to the Power up den
		manager.closeHomeScreen(this);
		manager.launchPowerup();
	}
	
	public void openVillainLair() {
		manager.closeHomeScreen(this);
		manager.launchOpenScreen();
	}
	
	public void openMapScreen() {						// Method for opening the map window
		manager.launchMapScreen();
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomebaseScreen window = new HomebaseScreen();
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
	public HomebaseScreen() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(710, 530));
		frame.getContentPane().setMinimumSize(new Dimension(710, 530));
		frame.getContentPane().setLayout(null);
		
		JLabel Message = new JLabel("<html>You are at the homebase, you can go North, West, South or East by pressing the arrow buttons.</br></html>");
		Message.setForeground(Color.WHITE);
		Message.setBounds(472, 375, 206, 67);
		frame.getContentPane().add(Message);
		if (manager.teamGifted) {
			gift = ranNum.nextInt(6) + 1;
			manager.itemArray.add(manager.shop.toItemString(gift)); // Gifted a random item out
			Message.setText("<html>Congratulations! You have been gifted an item!</br></html");
		}
		if (manager.teamRobbed) {
			if (manager.itemArray.size() > 0) {
				manager.itemArray.remove(0);
				Message.setText("<html>Oh No! An item has been robben from your inventory!</br></html>");
			}
		}
		int MIN = 0;
		int MAX = manager.CityNum;
		JProgressBar progressBar = new JProgressBar(MIN, MAX);
		progressBar.setString("");
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.BLUE);
		progressBar.setForeground(Color.YELLOW);
		progressBar.setBounds(52, 92, 178, 15);
		frame.getContentPane().add(progressBar);
		
		JButton NorthArrow = new JButton("");
		NorthArrow.addActionListener(new ActionListener() {								//Sets the North direction
			public void actionPerformed(ActionEvent e) {
				if (manager.map.get(0).toString().equals("North")) {
					openHospital();
				} 
				else if (manager.map.get(1).toString().equals("North")) {
					openItemShop();
				}
				else if (manager.map.get(2).toString().equals("North")) {
					openPowerupDen();
				}
				else if (manager.map.get(3).toString().equals("North")) {
					openVillainLair();
				}
			}
		});
		NorthArrow.setOpaque(false);
		NorthArrow.setContentAreaFilled(false);
		NorthArrow.setBackground(new Color(238, 238, 238));
		NorthArrow.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/Arrow.png")));
		NorthArrow.setBounds(304, 27, 100, 94);
		frame.getContentPane().add(NorthArrow);
		
		JButton SouthArrow = new JButton("");
		SouthArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.map.get(0).toString().equals("South")) {
					openHospital();
				} 
				else if (manager.map.get(1).toString().equals("South")) {
					openItemShop();
				}
				else if (manager.map.get(2).toString().equals("South")) {
					openPowerupDen();
				}
				else if (manager.map.get(3).toString().equals("South")) {
					openVillainLair();
				}
			}
		});
		SouthArrow.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/South_Arrow.png")));
		SouthArrow.setOpaque(false);
		SouthArrow.setContentAreaFilled(false);
		SouthArrow.setBackground(UIManager.getColor("Button.background"));
		SouthArrow.setBounds(304, 387, 100, 94);
		frame.getContentPane().add(SouthArrow);
		
		JButton WestArrow = new JButton("");
		WestArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.map.get(0).toString().equals("West")) {
					openHospital();
				} 
				else if (manager.map.get(1).toString().equals("West")) {
					openItemShop();
				}
				else if (manager.map.get(2).toString().equals("West")) {

					openPowerupDen();
				}
				else if (manager.map.get(3).toString().equals("West")) {
					openVillainLair();
				}
			}
		});
		WestArrow.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/East_Arrow.png")));
		WestArrow.setOpaque(false);
		WestArrow.setContentAreaFilled(false);
		WestArrow.setBackground(UIManager.getColor("Button.background"));
		WestArrow.setBounds(35, 201, 100, 94);
		frame.getContentPane().add(WestArrow);
		
		JButton EastArrow = new JButton("");
		EastArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.map.get(0).toString().equals("East")) {
					openHospital();
				} 
				else if (manager.map.get(1).toString().equals("East")) {
					openItemShop();
				}
				else if (manager.map.get(2).toString().equals("East")) {
					openPowerupDen();
				}
				else if (manager.map.get(3).toString().equals("East")) {
					openVillainLair();
				}
			}
		});
		EastArrow.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/West_Arrow.png")));
		EastArrow.setOpaque(false);
		EastArrow.setContentAreaFilled(false);
		EastArrow.setBackground(UIManager.getColor("Button.background"));
		EastArrow.setBounds(560, 201, 100, 94);
		frame.getContentPane().add(EastArrow);
		
		JLabel lblGoNorth = new JLabel("Go North");
		lblGoNorth.setForeground(Color.WHITE);
		lblGoNorth.setBounds(320, 135, 70, 20);
		frame.getContentPane().add(lblGoNorth);
		
		JLabel lblGoSouth = new JLabel("Go South");
		lblGoSouth.setForeground(Color.WHITE);
		lblGoSouth.setBounds(320, 355, 70, 20);
		frame.getContentPane().add(lblGoSouth);
		
		JLabel lblGoWest = new JLabel("Go West");
		lblGoWest.setForeground(Color.WHITE);
		lblGoWest.setBounds(52, 300, 70, 20);
		frame.getContentPane().add(lblGoWest);
		
		JLabel lblGoEast = new JLabel("Go East");
		lblGoEast.setForeground(Color.WHITE);
		lblGoEast.setBounds(578, 300, 70, 20);
		frame.getContentPane().add(lblGoEast);
		
		JLabel TeamName = new JLabel("");
		TeamName.setFont(new Font("Dialog", Font.BOLD, 17));
		TeamName.setBounds(303, 182, 143, 32);
		TeamName.setText(manager.TeamName);
		frame.getContentPane().add(TeamName);
		
		JLabel Hero1 = new JLabel("");
		if (manager.heroIcon != null) {
			Hero1.setIcon(new ImageIcon(HomebaseScreen.class.getResource(manager.heroIcon)));
			Hero1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
			Hero1.setBounds(222, 226, 100, 94);
		}
		frame.getContentPane().add(Hero1);
		
		JLabel Hero2 = new JLabel("");
		if (manager.heroIcon2 != null) {
			Hero2.setIcon(new ImageIcon(HomebaseScreen.class.getResource(manager.heroIcon2)));
			Hero2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
			Hero2.setBounds(316, 226, 100, 94);
		}
		frame.getContentPane().add(Hero2);
		
		JLabel hero3 = new JLabel("");
		if (manager.heroIcon3 != null) {
			hero3.setIcon(new ImageIcon(HomebaseScreen.class.getResource(manager.heroIcon3)));
			hero3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
			hero3.setBounds(407, 226, 100, 94);
		}
		frame.getContentPane().add(hero3);
		
		JLabel Balance = new JLabel("");
		Balance.setForeground(Color.WHITE);
		Balance.setBounds(200, 116, 46, 15);
		Balance.setText(Integer.toString(manager.goldCount));
		frame.getContentPane().add(Balance);
		
		JButton btnViewStats = new JButton("View Map");
		btnViewStats.setForeground(Color.WHITE);
		btnViewStats.setBackground(Color.DARK_GRAY);
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.team.heroes.contains(manager.wizard))
					openMapScreen();
				else {
					Message.setText("<html>You can only view the map if you have a wizard in your team or have purchased it at the item shop!</br></html>");
				}
			}
		});
		btnViewStats.setBounds(523, 31, 155, 26);
		frame.getContentPane().add(btnViewStats);
		
		JLabel CityNumber = new JLabel("");
		CityNumber.setForeground(Color.WHITE);
		CityNumber.setBounds(209, 410, 37, 20);
		CityNumber.setText(Integer.toString(manager.cityNumber));
		frame.getContentPane().add(CityNumber);
		
		JLabel lblNewLabel = new JLabel("5%");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(129, 141, 46, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setText(manager.itemArray.toString());
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(Color.WHITE);
		label.setBounds(158, 378, 131, 32);
		frame.getContentPane().add(label);
		
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/Home_base_Background.png")));
		BackGround.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home_base_Background.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		BackGround.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(BackGround);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
