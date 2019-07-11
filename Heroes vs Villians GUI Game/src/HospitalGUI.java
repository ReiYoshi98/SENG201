import java.awt.EventQueue;
import java.awt.Image;
import java.awt.List;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class HospitalGUI {

	private JFrame frame;
	private GUI_MAIN manager;
	public HeroScreen hero;
	Border border = BorderFactory.createLineBorder(Color.YELLOW);
	Border Dborder = BorderFactory.createLineBorder(Color.BLACK);
	Heroes currentHero;
	int currentItem;
	int itemIndex; 		// The index of where the item is located in the array
	int seconds = 0;
	
	public HospitalGUI(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeHospital(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void goBackHome() {
		manager.closeHospital(this);
		manager.launchHomeScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalGUI window = new HospitalGUI();
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
	public HospitalGUI() {
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
		
		JButton btnGoBack = new JButton("Back");
		btnGoBack.setFont(new Font("Dialog", Font.BOLD, 14));
		btnGoBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackHome();
			}
		});
		btnGoBack.setBackground(Color.DARK_GRAY);
		btnGoBack.setBounds(26, 22, 67, 33);
		frame.getContentPane().add(btnGoBack);
		
		JLabel Speech = new JLabel("<html>Welcome to the Hospital!<br/>You can use your healing items here to recover a Heroes HP! <html/> ");
		Speech.setVerticalAlignment(SwingConstants.TOP);
		Speech.setBounds(51, 270, 200, 73);
		frame.getContentPane().add(Speech);
	
		int MIN = 0;
		int MAX = 100;
		JProgressBar progressBar = new JProgressBar(MIN, MAX);
		progressBar.setVisible(false);
		progressBar.setStringPainted(true);
		progressBar.setValue(80);
		progressBar.setName("");
		progressBar.setForeground(new Color(124, 252, 0));
		progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(448, 455, 174, 15);
		frame.getContentPane().add(progressBar);
		if (20 < progressBar.getValue() && progressBar.getValue() < 51) {
			progressBar.setForeground(new Color(225, 225, 0));
		}
		if (progressBar.getValue() < 21) {
			progressBar.setForeground(new Color(225, 0, 0));
		}
		
		JLabel HealingZone = new JLabel("");
		HealingZone.setBorder(new LineBorder(new Color(240, 128, 128), 1, true));
		HealingZone.setHorizontalAlignment(SwingConstants.CENTER);
		HealingZone.setBounds(448, 278, 174, 169);
		frame.getContentPane().add(HealingZone);
		
		JLabel Hero = new JLabel("");
		Hero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Hero.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Hero.setBorder(Dborder);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				currentHero = manager.team.heroes.get(0);
				progressBar.setVisible(true);
				progressBar.setValue(currentHero.healthLevel);
				HealingZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon)));
				HealingZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
			}
		});
		Hero.setHorizontalAlignment(SwingConstants.CENTER);
		Hero.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero.setBackground(Color.GRAY);
		Hero.setBounds(31, 83, 80, 80);
		frame.getContentPane().add(Hero);
		if (manager.team.heroes.contains(manager.hero1)) {
			Hero.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon)));
			Hero.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero.setIcon(null);
		}
		
		JLabel Hero2 = new JLabel("");
		Hero2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Hero2.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Hero2.setBorder(Dborder);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (manager.HeroNum > 1) {
					currentHero = manager.team.heroes.get(1);
					progressBar.setValue(currentHero.healthLevel);
					progressBar.setVisible(true);
					HealingZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon2)));
					HealingZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero2.setHorizontalAlignment(SwingConstants.CENTER);
		Hero2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero2.setBounds(142, 83, 80, 80);
		frame.getContentPane().add(Hero2);
		if (manager.team.heroes.contains(manager.hero1)) {
			Hero2.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon2)));
			Hero2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero2.setIcon(null);
		}
		
		JLabel Hero3 = new JLabel("");
		Hero3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Hero3.setBorder(border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Hero3.setBorder(Dborder);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			if (manager.HeroNum > 2) {
				currentHero = manager.team.heroes.get(2);
				progressBar.setValue(currentHero.healthLevel);
				progressBar.setVisible(true);
				HealingZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
				HealingZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
			}
			}
		});
		Hero3.setHorizontalAlignment(SwingConstants.CENTER);
		Hero3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero3.setBounds(255, 83, 80, 80);
		frame.getContentPane().add(Hero3);
		if (manager.team.heroes.contains(manager.team.heroes)) {
			Hero3.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
			Hero3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero3.setIcon(null);
		}
		
		JLabel Name = new JLabel("");
		Name.setBounds(41, 166, 70, 15);
		if (manager.team.heroes.size() > 0) {            // The heroName of the hero
			Name.setText(manager.team.heroes.get(0).heroName);	
		};
		
		JLabel Name2 = new JLabel("");
		Name2.setBounds(152, 166, 70, 15);
		if (manager.team.heroCount > 1) {
			Name2.setText(manager.team.heroes.get(1).heroName);
		}
		frame.getContentPane().add(Name2);
		
		JLabel Name3 = new JLabel("");
		Name3.setBounds(265, 166, 70, 15);
		if (manager.team.heroCount > 2) {
			Name3.setText(manager.team.heroes.get(2).heroName);
		}
		frame.getContentPane().add(Name3);
		
		JLabel CurrentItems = new JLabel("");
		CurrentItems.setBounds(31, 217, 327, 33);
		CurrentItems.setText(manager.itemArray.toString());
		frame.getContentPane().add(CurrentItems);
		
		JLabel Border = new JLabel("");
		Border.addMouseListener(new MouseAdapter() {								// Methods for setting a yellow frame around the item when hovered over with the mouse, to allow user know this the icons are also buttons
			@Override
			public void mouseEntered(MouseEvent e) {
				Border.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {									// removes the frame when mouse leaves the area of the icon
				Border.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {								// when the icon is clicked, it will set the text of the inn-keeper speech bubble with your selected item and its price.  													
				currentItem = 1;													// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				Speech.setText("<html>You have selected Potion!<br/>Click the apply button if you would like to use this healing item</html>");
			}
		});
		Border.setBounds(384, 55, 88, 87);
		frame.getContentPane().add(Border);
		
		JLabel Border2 = new JLabel("");
		Border2.addMouseListener(new MouseAdapter() {								// Methods for setting a yellow frame around the item when hovered over with the mouse, to allow user know this the icons are also buttons
			@Override
			public void mouseEntered(MouseEvent e) {
				Border2.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {									// removes the frame when mouse leaves the area of the icon
				Border2.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {								// when the icon is clicked, it will set the text of the inn-keeper speech bubble with your selected item and its price.  													
				currentItem = 2;														// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				Speech.setText("<html>You have selected Super Potion!<br/>Click the apply button if you would like to use this healing item</html>");
			}
		});
		Border2.setBounds(490, 55, 88, 87);
		frame.getContentPane().add(Border2);
		
		JLabel Border3 = new JLabel("");
		Border3.addMouseListener(new MouseAdapter() {								// Methods for setting a yellow frame around the item when hovered over with the mouse, to allow user know this the icons are also buttons
			@Override
			public void mouseEntered(MouseEvent e) {
				Border3.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {									// removes the frame when mouse leaves the area of the icon
				Border3.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {								// when the icon is clicked, it will set the text of the inn-keeper speech bubble with your selected item and its price.  													
				currentItem = 3;													// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				Speech.setText("<html>You have selected Ultimate Potion!<br/>Click the apply button if you would like to use this healing item</html>");
			}
		});
		Border3.setBounds(590, 55, 88, 87);
		frame.getContentPane().add(Border3);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (HealingZone.getIcon() != null) 
					if (currentHero.healthLevel < 100) {
						if (manager.itemArray.contains(manager.shop.toItemString(currentItem))) {
							currentHero.healthLevel += manager.hospo.healingLevel(manager.shop.toItemString(currentItem));
							if (currentHero.healthLevel > 100) {
								currentHero.healthLevel = 100;
							}
							itemIndex = manager.itemArray.indexOf(manager.shop.toItemString(currentItem));
							manager.itemArray.remove(itemIndex);
							progressBar.setValue(currentHero.healthLevel);
							CurrentItems.setText(manager.itemArray.toString());
						} else {
							Speech.setText("<html>The selected item does not exit in your inventory <br/> Please go purchase the item at the item shop!</html>");
						}
					} else {
						Speech.setText("<html>The selected hero is already at<br/> full health. Only use the item when you need to restore your health!</html>");
				} else {
					Speech.setText("<html>You have not selected a hero<br/>to apply the item to!</html>");
				}
			}
		});
		btnApply.setHorizontalTextPosition(SwingConstants.LEFT);
		btnApply.setFont(new Font("Dialog", Font.BOLD, 14));
		btnApply.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnApply.setBackground(Color.PINK);
		btnApply.setBounds(33, 355, 99, 34);
		frame.getContentPane().add(btnApply);
		
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(HospitalGUI.class.getResource("/Images/Hospital_Background.png")));
		Background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hospital_Background.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		Background.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(Background);
	}
}
