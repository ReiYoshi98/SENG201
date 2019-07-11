import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class ItemShopScreen {
	

	private JFrame frame;
	private GUI_MAIN manager;
	public int currentItem = 0;   								// Holds the current selected item as an integer which is passed on to the item class to obtain the item name and price.
	
	public ItemShopScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {									// Closes the item shop window
		manager.closeItemShop(this);
	}
	
	public void finishedWindow() {								// Disposes the window
		frame.dispose();
	}
	
	public void goBackHome() {									// A method which closes the item shop and re-launches the home base screen (going back)
		manager.closeItemShop(this);
		manager.launchHomeScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemShopScreen window = new ItemShopScreen();
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
	public ItemShopScreen() {
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
		
		JLabel Speech = new JLabel("<html>Welcome to the item Shop!<br/>Select an item and then click buy to purchase the item</html> ");
		Speech.setVerticalTextPosition(SwingConstants.TOP);
		Speech.setBounds(37, 263, 219, 78);
		frame.getContentPane().add(Speech);
		
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
				Speech.setText("<html>You have selected Potion!<br/>It will cost 15 goid to buy the item<br/>Click buy to purchase the item</html>");
			}
		});
		Border.setBounds(389, 100, 91, 88);
		frame.getContentPane().add(Border);
		
		JLabel Border2 = new JLabel("");
		Border2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border2.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border2.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = 2;
				Speech.setText("<html>You have selected Super Potion!<br/>It will cost 30 goid to buy the item<br/>Click buy to purchase the item</html");
			}
		});
		Border2.setBounds(492, 100, 91, 88);
		frame.getContentPane().add(Border2);
		
		JLabel Border3 = new JLabel("");
		Border3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border3.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border3.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = 3;
				Speech.setText("<html>You have selected Ultimate Potion!<br/>It will cost 50 goid to buy the item<br/>Click buy to purchase the item</html");
			}
		});
		Border3.setBounds(595, 100, 90, 88);
		frame.getContentPane().add(Border3);
		
		JLabel Border4 = new JLabel("");
		Border4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border4.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border4.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = 4;
				Speech.setText("<html>You have selected Power Boost!<br/>It will cost 40 goid to buy the item<br/>Click buy to purchase the item</html");
			}
		});
		Border4.setBounds(389, 306, 91, 88);
		frame.getContentPane().add(Border4);
		
		JLabel Border5 = new JLabel("");
		Border5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border5.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border5.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border5.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = 5;
				Speech.setText("<html>You have selected Future Sight!<br/>It will cost 40 goid to buy the item<br/>Click buy to purchase the item</html");
			}
		});
		Border5.setBounds(492, 306, 91, 88);
		frame.getContentPane().add(Border5);
		
		JLabel Border6 = new JLabel("");
		Border6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Border6.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Yellow_border.png")));
				Border6.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yellow_border.png")).getImage().getScaledInstance(85, 87, Image.SCALE_SMOOTH)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Border6.setIcon(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = 6;
				Speech.setText("<html>You have selected Sheild!<br/>It will cost 60 goid to buy the item<br/>Click buy to purchase the item</html");
			}
		});
		Border6.setBounds(595, 306, 90, 88);
		frame.getContentPane().add(Border6);
		
		JLabel Items = new JLabel("");
		Items.setForeground(Color.WHITE);
		Items.setFont(new Font("Dialog", Font.BOLD, 14));
		Items.setBounds(164, 116, 195, 52);
		Items.setText(manager.itemArray.toString());
		frame.getContentPane().add(Items);
		
		JLabel Money = new JLabel("");
		Money.setForeground(Color.WHITE);
		Money.setBounds(210, 84, 33, 20);
		Money.setText(Integer.toString(manager.goldCount));
		frame.getContentPane().add(Money);
		
		JButton btnBuy = new JButton("Buy");									// Buttons to confirm the purchase of selected items
		btnBuy.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuy.setBackground(Color.CYAN);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						// If "Buy" is clicked
				if (currentItem != 0 && manager.shop.Itemprice(currentItem) <= manager.goldCount) {											// Checking if an item actually has been selected & the user has enough gold to purchase the item
					manager.itemArray.add(manager.shop.toItemString(currentItem));		// adds the item to the array from the GUI_MAIN class
					Speech.setText("<html>You have purchased " + manager.shop.toItemString(currentItem) + "<br/>The item has been strored in your iventory</html>" 
					+ manager.shop.Itemprice(currentItem) + " gold has been taken from your balance"); // Sets the speech text
					manager.goldCount -= manager.shop.Itemprice(currentItem);			// Reduces the balance by the item price
					Money.setText(Integer.toString(manager.goldCount));			// Updates the balance JLabal 
					Items.setText(manager.itemArray.toString());				// Updates the item array in the JLabel
				} else {
					Speech.setText("<html>Sorry, but you do not have <br/> gold to purchse this item. Gold can be earned by defeating the villains </html>");
				}
			}
		});
		

		btnBuy.setHorizontalTextPosition(SwingConstants.LEFT);
		btnBuy.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBuy.setBounds(32, 353, 99, 34);
		frame.getContentPane().add(btnBuy);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						// If the back button is pressed it calls this method to close the window and re-open the home base window.
				goBackHome();
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setHorizontalTextPosition(SwingConstants.LEFT);
		backBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		backBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		backBtn.setBackground(Color.DARK_GRAY);
		backBtn.setBounds(22, 24, 65, 34);
		frame.getContentPane().add(backBtn);
		
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(ItemShopScreen.class.getResource("/Images/Item_Shop_Back_Ground_png.png")));
		BackGround.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Item_Shop_Back_Ground_png.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		BackGround.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(BackGround);
	}
}
