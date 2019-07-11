import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PowerUpDenGUI {

	private JFrame frame;
	private GUI_MAIN manager;
	Border border = BorderFactory.createLineBorder(Color.YELLOW);
	Border Dborder = BorderFactory.createLineBorder(Color.BLACK);
	Heroes currentHero;
	int currentItem;
	int itemIndex; 		// The index of where the item is located in the array
	String boost1;
	String boost2;
	String boost3;
	
	public PowerUpDenGUI(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closePowerup(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}
	
	public void goBackHome() {
		manager.closePowerup(this);
		manager.launchHomeScreen();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PowerUpDenGUI window = new PowerUpDenGUI();
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
	public PowerUpDenGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(700, 500));
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
		btnGoBack.setBounds(30, 5, 67, 33);
		frame.getContentPane().add(btnGoBack);
		
		JLabel Speech = new JLabel("<html>Welcome to the Power up Den!<br/>You can use your power up items here to apply a power up to a hero! <html/> ");
		Speech.setVerticalAlignment(SwingConstants.TOP);
		Speech.setBounds(41, 262, 200, 73);
		frame.getContentPane().add(Speech);
		
		JLabel PowerZone = new JLabel("");
		PowerZone.setHorizontalAlignment(SwingConstants.CENTER);
		PowerZone.setBorder(new LineBorder(new Color(240, 128, 128), 1, true));
		PowerZone.setBounds(451, 269, 174, 169);
		frame.getContentPane().add(PowerZone);
		
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
				PowerZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon)));
				PowerZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
			}
		});
		
		Hero.setHorizontalAlignment(SwingConstants.CENTER);
		Hero.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero.setBackground(Color.GRAY);
		Hero.setBounds(31, 57, 80, 80);
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
					PowerZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon2)));
					PowerZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero2.setHorizontalAlignment(SwingConstants.CENTER);
		Hero2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero2.setBounds(142, 57, 80, 80);
		frame.getContentPane().add(Hero2);
		if (manager.team.heroes.contains(manager.hero2)) {
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
				PowerZone.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
				PowerZone.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
			}
			}
		});
		Hero3.setHorizontalAlignment(SwingConstants.CENTER);
		Hero3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero3.setBounds(255, 57, 80, 80);
		frame.getContentPane().add(Hero3);
		if (manager.team.heroes.contains(manager.hero3)) {
			Hero3.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
			Hero3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero3.setIcon(null);
		}
		JLabel Name = new JLabel("");
		Name.setBounds(41, 141, 70, 15);
		if (manager.team.heroes.size() > 0) {            // The heroName of the hero
			Name.setText(manager.hero1.heroName);	
		}
		frame.getContentPane().add(Name);
		
		JLabel Name2 = new JLabel("");
		Name2.setBounds(152, 141, 70, 15);
		if (manager.team.heroCount > 1) {
			Name2.setText(manager.hero2.heroName);
		}
		frame.getContentPane().add(Name2);
		
		JLabel Name3 = new JLabel("");
		Name3.setBounds(265, 141, 70, 15);
		if (manager.team.heroCount > 2) {
			Name3.setText(manager.hero3.heroName);
		}
		frame.getContentPane().add(Name3);
		
		JLabel CurrentItems = new JLabel("");
		CurrentItems.setForeground(Color.WHITE);
		CurrentItems.setBounds(31, 176, 327, 33);
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
				currentItem = 4;													// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				boost1 = manager.shop.toItemString(currentItem);
				Speech.setText("<html>You have selected Power Boost!<br/>Click the apply button if you would like to equip this Power up item</html>");
			}
		});
		Border.setBounds(387, 45, 88, 87);
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
				currentItem = 5;														// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				boost2 = manager.shop.toItemString(currentItem);
				Speech.setText("<html>You have selected Future Sight!<br/>Click the apply button if you would like to use this Power up item</html>");
			}
		});
		Border2.setBounds(487, 45, 88, 87);
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
				currentItem = 6;													// Sets the current item code as 1 which can be used to obtain the price or name of the item from the item class.
				boost3 = manager.shop.toItemString(currentItem);
				Speech.setText("<html>You have selected Shield!<br/>Click the apply button if you would like to use this Power up item</html>");
			}
		});
		Border3.setBounds(592, 45, 88, 87);
		frame.getContentPane().add(Border3);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (PowerZone.getIcon() != null) { 
					if (manager.itemArray.contains(manager.shop.toItemString(currentItem))) {
						if (manager.shop.toItemString(currentItem) == boost1) {
							currentHero.powerBoost = true;
						}
						if (manager.shop.toItemString(currentItem) == boost2) {
							currentHero.futureSight = true;
						}
						if (manager.shop.toItemString(currentItem) == boost3) {
							currentHero.shield = true;
						}
						currentHero.powerUp(manager.shop.toItemString(currentItem));
						itemIndex = manager.itemArray.indexOf(manager.shop.toItemString(currentItem));
						manager.itemArray.remove(itemIndex);
						CurrentItems.setText(manager.itemArray.toString());
						Speech.setText("<html>" + "Your selected hero has" + "</br>" + " been equiped with " + manager.shop.toItemString(currentItem)+ "</br>" + " You can acitivate this item during a fight with the villains" + "</html>");
					} else {
						Speech.setText("<html>The selected item does not exit in your inventory <br/> Please go purchase the item at the item shop!</html>");
					}
			} else {
					Speech.setText("<html>You have not selected a hero to apply a power up item to!</br></html>");
				}
			}
		});
		btnApply.setHorizontalTextPosition(SwingConstants.LEFT);
		btnApply.setFont(new Font("Dialog", Font.BOLD, 14));
		btnApply.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnApply.setBackground(Color.ORANGE);
		btnApply.setBounds(33, 355, 99, 34);
		frame.getContentPane().add(btnApply);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(PowerUpDenGUI.class.getResource("/Images/Power_up_den_background.png")));
		Background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Power_up_den_background.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		Background.setBounds(0, 0, 698, 486);
		frame.getContentPane().add(Background);
	}

}
