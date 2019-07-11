import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class HeroScreen {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private GUI_MAIN manager;
	public int heroCount = 0;
	public Heroes heroType1;								// Variables storing the type of hero which links to our hero class from the commandLine 
	public Heroes heroType2;
	public Heroes heroType3;
	public String name1;									// Variables storing the name of the hero. 
	public String name2;
	public String name3;
	Team currentTeam = new Team();
	Heroes type1 = new Attacker();							// Adding all the subclass hero classes from our commandLine class to the Hero GUI class
	Heroes type2 = new Attacker_Two();
	Heroes type3 = new Defender();
	Heroes type4 = new Defender_Two();
	Heroes type5 = new Wizard();
	Heroes type6 = new Guardian();
	
	public HeroScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeHerocreen(this);
	}
	
	public void finishedWindow() {
		frame.dispose();
	}

	public void openStatBox() {
		manager.launchStatScreen();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeroScreen window = new HeroScreen();
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
	public HeroScreen() {
		initialize();
	}

	/**))
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setName("fdd");
		frame.setMinimumSize(new Dimension(710, 530));
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(550, 400));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Selected_1 = new JLabel("");
		Selected_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() != null) {
					Selected_1.setIcon(null);
					heroCount -= 1;
				}
			}
		});
		Selected_1.setMaximumSize(new Dimension(90, 90));
		Selected_1.setHorizontalAlignment(SwingConstants.CENTER);
		Selected_1.setBounds(242, 306, 87, 80);
		frame.getContentPane().add(Selected_1);
		
		JLabel Selected_2 = new JLabel("");
		Selected_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_2.getIcon() != null) {
					Selected_2.setIcon(null);
					manager.heroIcon2 = "";
					heroCount -= 1;
				}
			}
		});
		Selected_2.setMaximumSize(new Dimension(90, 90));
		Selected_2.setHorizontalAlignment(SwingConstants.CENTER);
		Selected_2.setBounds(371, 306, 87, 80);
		frame.getContentPane().add(Selected_2);
		
		JLabel Selected_3 = new JLabel("");
		Selected_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_3.getIcon() != null) {
					Selected_3.setIcon(null);
					manager.heroIcon2 = "";
					heroCount -= 1;
				}
			}
		});
		Selected_3.setMaximumSize(new Dimension(90, 90));
		Selected_3.setHorizontalAlignment(SwingConstants.CENTER);
		Selected_3.setBounds(489, 306, 87, 80);
		frame.getContentPane().add(Selected_3);
		
		JLabel Hero1 = new JLabel("");
		Hero1.setForeground(Color.WHITE);
		Hero1.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero1.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero1.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero1.addMouseListener(new MouseAdapter() {							// Using the mouse adapter, when any of the heroes get clicked, it updates the empty frames as the image of the clicked hero
			@Override														// By using set icon on the empty JLabel.			
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type1;
					manager.heroIcon = "/Images/Hero_Example.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_Example.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Example.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type1;
					manager.heroIcon2 = "/Images/Hero_Example.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_Example.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Example.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type1;
					manager.heroIcon3 = "/Images/Hero_Example.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_Example.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Example.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero1.setText("Attacker");
		Hero1.setBounds(6, 99, 105, 129);
		Hero1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_Example.png")));
		Hero1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Example.png")).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		Hero1.setMaximumSize(new Dimension(90, 90));
		Hero1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Hero1);
		
		JLabel Hero2 = new JLabel("");
		Hero2.setForeground(Color.WHITE);
		Hero2.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero2.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero2.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type2;
					manager.heroIcon = "/Images/Hero_4.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_4.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_4.png")).getImage().getScaledInstance(85, 90, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type2;
					manager.heroIcon2 = "/Images/Hero_4.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_4.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_4.png")).getImage().getScaledInstance(85, 90, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type2;
					manager.heroIcon3 = "/Images/Hero_4.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_4.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_4.png")).getImage().getScaledInstance(85, 90, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero2.setText("Attacker Two");
		Hero2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_4.png")));
		Hero2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_4.png")).getImage().getScaledInstance(85, 90, Image.SCALE_SMOOTH)));
		Hero2.setMaximumSize(new Dimension(90, 90));
		Hero2.setHorizontalAlignment(SwingConstants.CENTER);
		Hero2.setBounds(329, 109, 115, 129);
		frame.getContentPane().add(Hero2);
		
		JLabel Hero3 = new JLabel("");
		Hero3.setForeground(Color.WHITE);
		Hero3.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero3.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero3.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type3;
					manager.heroIcon = "/Images/Hero_2 That works.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_2 That works.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_2 That works.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type3;
					manager.heroIcon2 = "/Images/Hero_2 That works.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_2 That works.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_2 That works.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type3;
					manager.heroIcon3 = "/Images/Hero_2 That works.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_2 That works.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_2 That works.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero3.setText("Attacker Two");
		Hero3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_2 That works.png")));
		Hero3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_2 That works.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		Hero3.setMaximumSize(new Dimension(90, 90));
		Hero3.setHorizontalAlignment(SwingConstants.CENTER);
		Hero3.setBounds(104, 110, 112, 116);
		frame.getContentPane().add(Hero3);
		
		JLabel Hero4 = new JLabel("");
		Hero4.setForeground(Color.WHITE);
		Hero4.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero4.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero4.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type4;
					manager.heroIcon = "/Images/Hero_3.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_3.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_3.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type4;
					manager.heroIcon2 = "/Images/Hero_3.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_3.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_3.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type4;
					manager.heroIcon3 = "/Images/Hero_3.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_3.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_3.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero4.setText("Defender");
		Hero4.setBounds(214, 111, 104, 124);
		Hero4.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_3.png")));
		Hero4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_3.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
		Hero4.setMaximumSize(new Dimension(90, 90));
		Hero4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Hero4);
		
		JLabel Hero5 = new JLabel("");
		Hero5.setForeground(Color.WHITE);
		Hero5.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero5.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero5.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type5;
					manager.heroIcon = "/Images/Hero_5.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_5.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_5.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type5;
					manager.heroIcon2 = "/Images/Hero_5.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_5.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_5.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type5;
					manager.heroIcon3 = "/Images/Hero_5.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_5.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_5.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero5.setText("Wizard");
		Hero5.setBounds(456, 111, 104, 115);
		Hero5.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_5.png")));
		Hero5.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_5.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		Hero5.setMaximumSize(new Dimension(90, 90));
		Hero5.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Hero5);
		
		JLabel Hero6 = new JLabel("");
		Hero6.setForeground(Color.WHITE);
		Hero6.setFont(new Font("Dialog", Font.BOLD, 9));
		Hero6.setHorizontalTextPosition(SwingConstants.CENTER);
		Hero6.setVerticalTextPosition(SwingConstants.BOTTOM);
		Hero6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {					
				if (Selected_1.getIcon() == null) {
					heroCount = 1;
					heroType1 = type6;
					manager.heroIcon = "/Images/Hero_6.png";
					Selected_1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_6.png")));
					Selected_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_6.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_2.getIcon() == null) {
					heroCount = 2;
					heroType2 = type6;
					manager.heroIcon = "/Images/Hero_6.png";
					Selected_2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_6.png")));
					Selected_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_6.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				} else if (Selected_3.getIcon() == null) {
					heroCount = 3;
					heroType3 = type6;
					manager.heroIcon = "/Images/Hero_6.png";
					Selected_3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_6.png")));
					Selected_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_6.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
				}
			}
		});
		Hero6.setText("Guardian");
		Hero6.setBounds(586, 107, 90, 122);
		Hero6.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_6.png")));
		Hero6.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_6.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		Hero6.setMaximumSize(new Dimension(90, 90));
		Hero6.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Hero6);
		

		
		JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setForeground(Color.RED);
		ErrorMessage.setFont(new Font("Dialog", Font.BOLD, 10));
		ErrorMessage.setBounds(24, 360, 189, 26);
		frame.getContentPane().add(ErrorMessage);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setColumns(10);
		textField.setBounds(241, 409, 95, 19);
		frame.getContentPane().add(textField);
		
		JLabel NameError = new JLabel("");
		NameError.setForeground(Color.RED);
		NameError.setFont(new Font("Dialog", Font.BOLD, 13));
		NameError.setBounds(35, 380, 178, 19);
		frame.getContentPane().add(NameError);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBounds(361, 409, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBounds(488, 409, 97, 19);
		frame.getContentPane().add(textField_2);
		
		JLabel lblEnterTheNames = new JLabel("Enter hero names:");
		lblEnterTheNames.setForeground(Color.WHITE);
		lblEnterTheNames.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEnterTheNames.setBounds(85, 405, 152, 26);
		frame.getContentPane().add(lblEnterTheNames);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(Color.DARK_GRAY);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean done = false;
				if (heroCount == manager.HeroNum) {								// If the number of selected heroes match the earlier selection in the setup screen
					if (heroCount == 1 && manager.hero1Set) {					// If the hero count is set 1 & Checking if the text field is empty	
						heroType1.setName(name1);								// set the hero name as the content in the name box// Checking if the text field is empty
						manager.team.heroes.add(heroType1);
						manager.hero1 = heroType1;
						done = true;											// If the hero count was 1, then selection is complete
					} else { 
						NameError.setText("Please Enter Name");				//	Else, print error message
					}
					if (heroCount == 2 && manager.hero1Set) {									//	If the hero count is set to 2
						heroType1.setName(name1);
						manager.team.heroes.add(heroType1);
						manager.hero1 = heroType1;
							if (manager.hero2Set) {
								heroType2.setName(name2);
								manager.team.heroes.add(heroType2);
								manager.hero2 = heroType2;
								done = true;									// Checking all text fields to make sure they are not empty 
							}
					} else { 
						NameError.setText("Please Enter Name");				// Otherwise selection is incomplete
					}
					if (heroCount == 3 && manager.hero1Set) {
						heroType1.setName(name1);
						manager.team.heroes.add(heroType1);
						manager.hero1 = heroType1;
						if (manager.hero2Set) {
							heroType2.setName(name2);
							manager.team.heroes.add(heroType2);
							manager.hero2 = heroType2;
							if (manager.hero3Set) {
								heroType3.setName(name3);
								manager.team.heroes.add(heroType3);
								manager.hero3 = heroType3;
								done = true;
							}
						}
					} else { 
						NameError.setText("Please Enter Name");
						} 
				} else {
					ErrorMessage.setText("You can only select " + manager.HeroNum + " heroes");	//	If hero count does not match initial selection number an Error message is printed. 
					}
			if (done) {
				//manager.team = currentTeam;
				manager.wizard = type5;
				closeWindow();
			}
			}
			});
		btnGo.setBounds(561, 44, 115, 37);
		frame.getContentPane().add(btnGo);
		
		JButton btnViewStats = new JButton("View Hero Stats");
		btnViewStats.setForeground(Color.WHITE);
		btnViewStats.setBackground(Color.DARK_GRAY);
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openStatBox();
			}
		});
		btnViewStats.setBounds(528, 245, 155, 26);
		frame.getContentPane().add(btnViewStats);
		
		JButton NameSet1 = new JButton("Set");
		NameSet1.setBackground(Color.DARK_GRAY);
		NameSet1.setForeground(Color.WHITE);
		NameSet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Selected_1.getIcon() != null && !textField.getText().equals("")) {
					if (textField.getText().length() > 0 && textField.getText().length() < 15) {
						manager.hero1Set = true;
						name1 = textField.getText();
						ErrorMessage.setText("");
					} else {
						ErrorMessage.setText("Name must be between 1 and 15 characters long");
					}
				} else {
					ErrorMessage.setText("Name or Hero not set");
			}
			}
		});
		NameSet1.setBounds(241, 428, 95, 19);
		frame.getContentPane().add(NameSet1);
		
		JButton NameSet2 = new JButton("Set");
		NameSet2.setBackground(Color.DARK_GRAY);
		NameSet2.setForeground(Color.WHITE);
		NameSet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Selected_2.getIcon() != null && !textField_1.getText().equals("")) {
					if (textField_1.getText().length() > 0 && textField_1.getText().length() < 15) {
						manager.hero2Set = true;
						name2 = textField.getText();
						ErrorMessage.setText("");
					} else {
						ErrorMessage.setText("Name must be between 1 and 15 characters long");
					}
				} else {
					ErrorMessage.setText("Name or Hero not set");
			}
			}
		});
		NameSet2.setBounds(362, 428, 95, 19);
		frame.getContentPane().add(NameSet2);
		
		JButton NameSet3 = new JButton("Set");
		NameSet3.setBackground(Color.DARK_GRAY);
		NameSet3.setForeground(Color.WHITE);
		NameSet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Selected_3.getIcon() != null && !textField_2.getText().equals("")) {
					if (textField_2.getText().length() > 0 && textField_2.getText().length() < 15) {
						manager.hero3Set = true;
						name3 = textField.getText();
						ErrorMessage.setText("");
					} else {
						ErrorMessage.setText("Name must be between 1 and 15 characters long");
						}
				} else {
					ErrorMessage.setText("Name or Hero not set");
			}
			}
		});
		NameSet3.setBounds(488, 428, 95, 19);
		frame.getContentPane().add(NameSet3);
		
		JLabel Teamname = new JLabel("");
		Teamname.setForeground(Color.WHITE);
		Teamname.setBounds(114, 245, 75, 26);
		Teamname.setText(manager.TeamName);
		frame.getContentPane().add(Teamname);
		
		JLabel HeroNumber = new JLabel((String) null);
		HeroNumber.setForeground(Color.WHITE);
		HeroNumber.setBounds(158, 276, 31, 26);
		HeroNumber.setText(Integer.toString(manager.HeroNum));
		frame.getContentPane().add(HeroNumber);
		
		JLabel CityNumber = new JLabel((String) null);
		CityNumber.setForeground(Color.WHITE);
		CityNumber.setBounds(147, 306, 31, 26);
		CityNumber.setText(Integer.toString(manager.CityNum));
		frame.getContentPane().add(CityNumber);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Hero_Selection.png")));
		Background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Hero_Selection.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		Background.setBounds(0, 0, 708, 504);
		frame.getContentPane().add(Background);
	}
}
