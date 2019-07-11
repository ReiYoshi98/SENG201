import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

public class VillainGameGUI {

	private JFrame frame;
	private GUI_MAIN manager;
	public int result = 4;
	public int villainGame;
	public Heroes currentHero;  			// The current hero which is in battle
	Border border = BorderFactory.createLineBorder(Color.YELLOW);
	Border Dborder = BorderFactory.createLineBorder(Color.BLACK);
	public int currentGame; // A number which indicates the current game acting as a switch
	public boolean roundFinished = true; // A switch which sets weather the round of the battle has been finished or not
	Random ranNum = new Random();	
	int vRSP = ranNum.nextInt(3);		// The random number use for Rock, paper, scissors // Also used to decide what the game may be changed to (gameChange)
	String villainsMove; 				// String set for the future sight power boost
	int vNum = ranNum.nextInt(10) + 1;  // The random number used for Guess the number 
	int vDice = ranNum.nextInt(6) + 1;	// The random number used for Dice roll
	int gameChange; // The numbers to 100 used for the chance of the villain changing the game
	int counter = 0;					// Counter for guess the number
	int heroGuess;
	boolean AttackBtnEnabled = false;
	boolean AttackMade = false;
	boolean secondMoveMade = false;
	public int heroIndex;
	public String currentItem;          // A string used for item recognition 
	boolean powerBoost = false;			// Activates the power boosts 
	boolean futureSight = false;
	boolean shield = false; 
	
	public void openGameover() {						// Method for switching to the Game Over Screen
		manager.closeVillainGameGUI(this);
		manager.launchGameover();
	}
	
	public VillainGameGUI(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeVillainGameGUI(this);
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
					VillainGameGUI window = new VillainGameGUI();
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
	public VillainGameGUI() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<Villains> villainList = manager.villainSet(manager.CityNum);
		Villains currentVillain = villainList.get(manager.cityNumber-1);
		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(710, 530));
		frame.getContentPane().setMinimumSize(new Dimension(710, 530));
		frame.getContentPane().setLayout(null);
		
		JLabel VillainName = new JLabel("");
		VillainName.setForeground(Color.WHITE);
		VillainName.setFont(new Font("Dialog", Font.BOLD, 14));
		VillainName.setBounds(478, 147, 126, 15);
		frame.getContentPane().add(VillainName);
		
		JLabel lblHeroMove = new JLabel("");
		lblHeroMove.setForeground(Color.WHITE);
		lblHeroMove.setMinimumSize(new Dimension(87, 87));
		lblHeroMove.setBounds(259, 209, 91, 77);
		frame.getContentPane().add(lblHeroMove);
		
		JLabel Speech = new JLabel("<html>Choose a move to attack Villain!</br></html>");
		Speech.setForeground(Color.WHITE);
		Speech.setVerticalAlignment(SwingConstants.TOP);
		Speech.setBounds(415, 38, 224, 77);
		frame.getContentPane().add(Speech);
		
		JComboBox cboMoves = new JComboBox();
		cboMoves.setForeground(Color.WHITE);
		cboMoves.setBackground(Color.DARK_GRAY);
		cboMoves.setEnabled(false);
		cboMoves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHeroMove.setText("");
			}
		});
		if (currentVillain.villainGame == 0) {
			currentGame = 0;
			cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 1:", "Rock", "Scissors", "Papers"}));
		}
		else if (currentVillain.villainGame == 1) {
			cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 2:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
			currentGame = 1;
		}
		else if (currentVillain.villainGame == 2) {
			cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 3:", "Roll"}));
			currentGame = 2;
		}
		cboMoves.setBounds(127, 410, 91, 25);
		frame.getContentPane().add(cboMoves);
		
		int MIN = 0;
		int MAX = 150;
		
		JComboBox secondNumber = new JComboBox();
		secondNumber.setForeground(Color.WHITE);
		secondNumber.setBackground(Color.DARK_GRAY);
		secondNumber.setBounds(219, 410, 91, 25);
		secondNumber.setVisible(false);
		secondNumber.setEnabled(false);
		secondNumber.setModel(new DefaultComboBoxModel(new String[] {"Second Guess:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		frame.getContentPane().add(secondNumber);
		
		JLabel lblVillainMove = new JLabel("");
		lblVillainMove.setForeground(Color.WHITE);
		lblVillainMove.setMinimumSize(new Dimension(87, 87));
		lblVillainMove.setBounds(387, 209, 91, 77);
		frame.getContentPane().add(lblVillainMove);
		
		JLabel lblResult = new JLabel("");
		lblResult.setFont(new Font("Dialog", Font.BOLD, 14));
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(267, 179, 211, 36);
		frame.getContentPane().add(lblResult);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton GameOver = new JButton("END GAME:");
		GameOver.setFont(new Font("Dialog", Font.BOLD, 15));
		GameOver.setBackground(Color.ORANGE);
		GameOver.setBounds(85, 118, 211, 50);
		GameOver.setEnabled(false);
		GameOver.setVisible(false);
		
		
		JProgressBar VillainHealth = new JProgressBar(MIN, MAX);
		VillainHealth.setStringPainted(true);
		VillainHealth.setValue(150);
		VillainHealth.setName("");
		VillainHealth.setForeground(new Color(124, 252, 0));
		VillainHealth.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		VillainHealth.setBackground(Color.LIGHT_GRAY);
		VillainHealth.setBounds(478, 383, 133, 15);
		frame.getContentPane().add(VillainHealth);
		
		JButton btnAttack = new JButton("Attack");
		
		JLabel FutureText = new JLabel("");
		FutureText.setFont(new Font("Dialog", Font.BOLD, 14));
		FutureText.setForeground(Color.WHITE);
		FutureText.setVerticalAlignment(SwingConstants.TOP);
		FutureText.setBounds(267, 271, 186, 63);
		frame.getContentPane().add(FutureText);
		
		JLabel Gamechanged = new JLabel("");
		Gamechanged.setVerticalAlignment(SwingConstants.TOP);
		Gamechanged.setForeground(Color.WHITE);
		Gamechanged.setBounds(383, 135, 268, 27);
		frame.getContentPane().add(Gamechanged);
		btnAttack.setBounds(127, 437, 91, 26);
		frame.getContentPane().add(btnAttack);
		
		
		JButton btnPlayNextRound = new JButton("Play Next Round");
		btnPlayNextRound.setBackground(Color.DARK_GRAY);
		btnPlayNextRound.setForeground(Color.WHITE);
		btnPlayNextRound.setEnabled(false);
		btnPlayNextRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameChange = ranNum.nextInt(100);
				if (gameChange < 30) { 		// A 20% chance the villain will change the game (20% x 66% of the game being different)
					if (vRSP != currentGame) {
						currentGame = vRSP;     // The rock, paper scissors game random number generator is used to select the new game mode.
						if (currentGame == 0) {
							cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 1:", "Rock", "Scissors", "Papers"}));
						}
						if (currentGame == 1) {
							cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 2:", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
						}
						if (currentGame == 2) {
							cboMoves.setModel(new DefaultComboBoxModel(new String[] {"Game 3:", "Roll"}));
						}
						lblVillainMove.setIcon(null);
						lblVillainMove.setText(null);
						lblHeroMove.setIcon(null);
						lblHeroMove.setText(null);
						Gamechanged.setText("<html>The game has been changed by the villain!</br></html>");
					}							
				}
				Speech.setText("Choose a move!");
				if (!lblResult.getText().equals("Wrong, go higher!") || !lblResult.getText().equals("Wrong, go lower!")) {
					lblVillainMove.setText(null);
					lblHeroMove.setText(null);
					counter = 0;
					btnAttack.setEnabled(true);
					cboMoves.setEnabled(true);
					secondNumber.setEnabled(false);
					btnPlayNextRound.setEnabled(false);
					FutureText.setText(null);
					if (currentGame == 1) {
						cboMoves.setSelectedIndex(0);
						secondNumber.setSelectedIndex(0);
					}
					result = 4;
					;
				}
			}
		});
					
			//////////////////////////////////////////////////////////////
			/////////////////////////createEvents
			/////////////////////////////////////////////////////////////
			
			JButton btnActivate = new JButton("USE");
			btnActivate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (currentItem.equals("Future Sight")) {
						if (currentHero.futureSight) {
							Speech.setText("<html>You have activated the Shield!</br><html>");
							if (currentGame == 0) {
								if (vRSP == 0) {
									villainsMove = "Rock";
								}
								else if (vRSP == 1) {
									villainsMove = "Scissors";
								}
								else if (vRSP == 2) {
									villainsMove = "Paper";
								}
								FutureText.setText("<html>" + "The villain is going to use " + "</br>" +villainsMove + "</html>");
							}
							else if (currentGame == 1) {
								villainsMove = Integer.toString(vNum);
								FutureText.setText("<html>" + "The villain is going to use " + "</br>" + villainsMove + "</html>");
							}
							else if (currentGame == 2) {
								villainsMove = Integer.toString(vDice);
								FutureText.setText(",html>" + "The villain will roll a " + "</br>" + villainsMove + "</html>");
							}
						} else { 
							Speech.setText("<html>You do not hold this item</br><html>");
						}
						currentHero.futureSight = false; // Hero looses ability
					}
					if (currentItem.equals("Power Boost")) {
						if (currentHero.powerBoost) {
							Speech.setText("<html>" + "You have activated the Power Boost!" + "</br>" + "the item will be active in the next round!" + "<html>");
						} else {
							Speech.setText("<html>You do not hold this item</br><html>");
						}
					}
					if (currentItem.equals("Shield")) {
						if (currentHero.shield) {
							Speech.setText("<html>You have activated the Shield! You can take a hit without damage the item will be active in the next round!</br><html>");
							currentHero.healthLevel += 20;
						} else {
							Speech.setText("<html>You do not hold this item</br><html>");
						}
					}
				}
			});
			btnActivate.setForeground(Color.WHITE);
			btnActivate.setEnabled(false);
			btnActivate.setBackground(Color.DARK_GRAY);
			btnActivate.setBounds(2, 345, 84, 26);
			frame.getContentPane().add(btnActivate);
		btnPlayNextRound.setBounds(287, 442, 161, 25);
		frame.getContentPane().add(btnPlayNextRound);
		
		JLabel HeroName = new JLabel("");
		HeroName.setForeground(Color.WHITE);
		HeroName.setFont(new Font("Dialog", Font.BOLD, 14));
		HeroName.setBounds(127, 147, 126, 15);
		frame.getContentPane().add(HeroName);
		
		JProgressBar Herohealth = new JProgressBar(0, 100);
		Herohealth.setStringPainted(true);
		Herohealth.setValue(100);
		Herohealth.setName("");
		Herohealth.setForeground(new Color(124, 252, 0));
		Herohealth.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		Herohealth.setBackground(Color.LIGHT_GRAY);
		Herohealth.setBounds(108, 383, 138, 15);
		frame.getContentPane().add(Herohealth);
		
		JLabel lblItemMessage = new JLabel("");
		lblItemMessage.setBounds(6, 99, 293, 16);
		frame.getContentPane().add(lblItemMessage);
		
		
		JLabel lblFightingHero = new JLabel("");
		lblFightingHero.setBounds(108, 195, 161, 176);
		frame.getContentPane().add(lblFightingHero);
		
		JLabel lblVillain = new JLabel("");
		lblVillain.setBounds(451, 175, 186, 176);
		if (currentVillain.villainName.equals("Rook")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/villain4.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/villain4.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
			
		}
		if (currentVillain.villainName.equals("Queen")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/villain3.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/villain3.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
		}
		if (currentVillain.villainName.equals("King")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/villain6.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/villain6.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
		}
		if (currentVillain.villainName.equals("Bishop")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/Villain1.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Villain1.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
		}
		if (currentVillain.villainName.equals("Knight")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/villain5.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/villain5.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
		}
		if (currentVillain.villainName.equals("Pawn")) {
			lblVillain.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/Villain2.png")));
			lblVillain.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Villain2.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			VillainName.setText(currentVillain.villainName);
			VillainHealth.setValue(currentVillain.villainHealth);
		}
		frame.getContentPane().add(lblVillain);

		
		JLabel lblGameNumPrinter = new JLabel("");
		lblGameNumPrinter.setBounds(38, 335, 61, 16);
		frame.getContentPane().add(lblGameNumPrinter);
		
		
		JButton NextCity = new JButton("Next City");
		NextCity.setBackground(Color.YELLOW);
		NextCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		NextCity.setVisible(false);
		NextCity.setBounds(550, 442, 117, 25);
		frame.getContentPane().add(NextCity);
		
		
		JLabel Hero = new JLabel("");
		Hero.setHorizontalTextPosition(SwingConstants.CENTER);
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
				if (manager.team.heroes.contains(manager.hero1)) {
					heroIndex = manager.team.heroes.indexOf(manager.hero1);
					currentHero = manager.team.heroes.get(heroIndex);
					if (manager.heroIcon != null) {
						btnAttack.setEnabled(true);
						cboMoves.setEnabled(true);
						lblFightingHero.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon)));
						lblFightingHero.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
						Herohealth.setValue(currentHero.healthLevel);
					}
				} else {
					Speech.setText("There is no hero here");
				}
			}
		});
		
		JLabel villainSpeech = new JLabel("");
		villainSpeech.setFont(new Font("Dialog", Font.BOLD, 10));
		villainSpeech.setVerticalAlignment(SwingConstants.TOP);
		villainSpeech.setBounds(584, 196, 96, 36);
		villainSpeech.setText("<html>" + currentVillain.villainTaunt + "</br>" + "<html>");
		frame.getContentPane().add(villainSpeech);
		
		Hero.setHorizontalAlignment(SwingConstants.CENTER);
		Hero.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero.setBackground(Color.GRAY);
		Hero.setBounds(97, 35, 74, 71);
		frame.getContentPane().add(Hero);
		if (manager.team.heroes.contains(manager.hero1)) {
			Hero.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon)));
			Hero.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero.setIcon(null);
		}
				
		JLabel Hero2 = new JLabel("");
		Hero2.setMinimumSize(new Dimension(80, 78));
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
				if (manager.team.heroes.contains(manager.hero2)) {
					heroIndex = manager.team.heroes.indexOf(manager.hero2);
					currentHero = manager.team.heroes.get(heroIndex);
					Herohealth.setValue(currentHero.healthLevel);
					if (manager.heroIcon2 != null) {
						btnAttack.setEnabled(true);
						cboMoves.setEnabled(true);
						lblFightingHero.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon2)));
						lblFightingHero.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
						Herohealth.setValue(currentHero.healthLevel);
					}
				} else {
				Speech.setText("There is no hero here");
			}
			}
		});
		Hero2.setHorizontalAlignment(SwingConstants.CENTER);
		Hero2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero2.setBounds(183, 34, 80, 71);
		frame.getContentPane().add(Hero2);
		if (manager.team.heroes.contains(manager.hero2)) {
			Hero2.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon2)));
			Hero2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon2)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero2.setIcon(null);
		}	
				
		JLabel Hero3 = new JLabel("");
		Hero3.setMinimumSize(new Dimension(8078, 80));
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
				if (manager.team.heroes.contains(manager.hero3)) {
					heroIndex = manager.team.heroes.indexOf(manager.hero3);
					currentHero = manager.team.heroes.get(heroIndex);
					Herohealth.setValue(currentHero.healthLevel);
						if (manager.heroIcon3 != null) {
							btnAttack.setEnabled(true);
							cboMoves.setEnabled(true);
							lblFightingHero.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
							lblFightingHero.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
							Herohealth.setValue(currentHero.healthLevel);
						}
				} else {
					Speech.setText("There is no hero here");
				}
			}
		});
		Hero3.setHorizontalAlignment(SwingConstants.CENTER);
		Hero3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Hero3.setBounds(275, 34, 80, 71);
		frame.getContentPane().add(Hero3);
		if (manager.team.heroes.contains(manager.hero3)) {
			Hero3.setIcon(new ImageIcon(HeroScreen.class.getResource(manager.heroIcon3)));
			Hero3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(manager.heroIcon3)).getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH)));
		} else {
			Hero3.setIcon(null);
		}	
		
		
		//Execute Games
		btnAttack.setForeground(Color.WHITE);
		btnAttack.setBackground(Color.DARK_GRAY);
		btnAttack.setEnabled(false);
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create random numbers for Games
				Random ranNum = new Random();		
				/////////////////////////
				//RockScissorsPaper Game1
				//////////////////////////
				RockScissorPaper RSP = new RockScissorPaper();
				guessTheNumberGui GTN = new guessTheNumberGui();
				rollDiceGui RTD = new rollDiceGui();
				secondNumber.setEnabled(false);
				secondNumber.setVisible(false);
				//Create random number for RockScissorsPaper	
				Gamechanged.setText(null);
				if (currentHero.powerBoost) {
					currentHero.heroDamage += 50;
				}
				
				if (currentGame == 0) {	
					if (!cboMoves.getSelectedItem().toString().equals("Game 1:")) {
						AttackMade = true;
						if (cboMoves.getSelectedItem().toString().equals("Rock")) {
							lblHeroMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/rock.png")));
							lblHeroMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rock.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							int userMove = 0;
							//set icon
							if (vRSP == 0) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/rock__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rock__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 1) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/scissors__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scissors__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 2) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/paper__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paper__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							result = RSP.gameResult(userMove, vRSP);
									
							if (result == 0) {
								//print result label
								lblResult.setText("lost");
								currentHero.healthLevel -= 20;
							}
									
							else if (result == 1) {
								//print result label
								lblResult.setText("won");
								currentVillain.villainHealth -= 50;
							}
									
							if (result == 2) {
								//print draw on the result label)
								lblResult.setText("Draw");
								//clear move labels
							}
						}
						if (cboMoves.getSelectedItem().toString().equals("Scissors")) {
							lblHeroMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/scissors.png")));
							lblHeroMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scissors.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							int userMove = 1;
							if (vRSP == 0) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/rock__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rock__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 1) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/scissors__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scissors__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 2) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/paper__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paper__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							result = RSP.gameResult(userMove, vRSP);
									
							if (result == 2) {
								//print draw on the result label
								lblResult.setText("Draw");
								//clear move labels
							}
									
							else if (result == 1) {
								//print result label
								lblResult.setText("won");
								currentVillain.villainHealth -= 50;
								//villain progress bar - 50
							}
									
							else if (result == 0) {
								//print result label
								lblResult.setText("lost");
								currentHero.healthLevel -= 20;
								//hero progress bar - 20
							}
						}
						if (cboMoves.getSelectedItem().toString().equals("Papers")) {
							lblHeroMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/paper.png")));
							lblHeroMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paper.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							int userMove = 2;
							if (vRSP == 0) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/rock__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rock__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 1) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/scissors__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/scissors__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							else if (vRSP == 2) {
								lblVillainMove.setIcon(new ImageIcon(HomebaseScreen.class.getResource("/Images/paper__2_.png")));
								lblVillainMove.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/paper__2_.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
							}
									
							result = RSP.gameResult(userMove, vRSP);
									
							if (result == 2) {
								//print draw on the result label
								lblResult.setText("Draw");
								//clear move labels
							}
									
							else if (result == 1) {
								//print result label
								lblResult.setText("won");
								currentVillain.villainHealth -= 50;
							}
									
							else if (result == 0) {
								//print result label
								lblResult.setText("lost");
								currentHero.healthLevel -= 20;
								}
						}
				} else {
					Speech.setText("You have not selected a move");
				}
			}
				/////////////////////////////////
				//Guess the number
				/////////////////////////////////
				
			if (currentGame == 1) {
				if (!cboMoves.getSelectedItem().toString().equals("Game 2:")) {
					AttackMade = true;
					heroGuess = Integer.valueOf(cboMoves.getSelectedItem().toString());
					//result = GTN.gameResult(heroGuess, vNum);
							
					//hero move icon
					lblHeroMove.setText(Integer.toString(heroGuess));
					counter += 1;
					if (heroGuess == vNum) {
						lblResult.setText("Won!");
						currentVillain.villainHealth -= 50;
						lblVillainMove.setText(Integer.toString(vNum));
						vNum = ranNum.nextInt(10) + 1;
						btnPlayNextRound.setEnabled(true);
						result = 1;
					} 
					else if (heroGuess != vNum) {
						btnPlayNextRound.setEnabled(false);
						secondNumber.setEnabled(true);
						secondNumber.setVisible(true);
						Speech.setText("Take another guess with the second option box!");
						cboMoves.setEnabled(false);
						if (heroGuess < vNum) {
							lblResult.setText("Wrong, go higher!");
							result = 3;
						}							
						else if (heroGuess > vNum) {
							lblResult.setText("Wrong, go lower!");
							result = 3;
						} 
						if (counter >= 2) {
							if (!secondNumber.getSelectedItem().toString().equals("Second Guess:")) {
								heroGuess = Integer.valueOf(secondNumber.getSelectedItem().toString());
								lblHeroMove.setText(Integer.toString(heroGuess));
								if (heroGuess == vNum) {
									lblResult.setText("Won!");
									currentVillain.villainHealth -= 50;
									lblVillainMove.setText(Integer.toString(vNum));
									vNum = ranNum.nextInt(10) + 1;
									btnPlayNextRound.setEnabled(true);
									result = 1;
								}
								else {
									lblResult.setText("Lost!");
									Speech.setText("Your number was wrong again!");
									lblVillainMove.setText(Integer.toString(vNum));
									btnPlayNextRound.setEnabled(true);
									currentHero.healthLevel -= 20;
									result = 0;
								}
							} 
							else {
								Speech.setText("You have not selected a move!");
						}
						}
					}
				} else {
					Speech.setText("You have not selected a move!");
				}
			}
							
					
				/////////////////////////////////
				//Roll the dice
				/////////////////////////////////
				//Create random number for RollDice
				
			if (currentGame == 2) {
				if (!cboMoves.getSelectedItem().toString().equals("Game 3:")) {
					AttackMade = true;
					int hDice = ranNum.nextInt(6) + 1;
					lblHeroMove.setText(Integer.toString(hDice));
					lblVillainMove.setText(Integer.toString(vDice));
					if (cboMoves.getSelectedItem().toString().equals("Roll")) {

						result = RTD.gameResult(hDice, vDice);
							
						if (result == 2) {
							lblResult.setText("Draw");
						}
								
						else if (result == 1) {
							lblResult.setText("won");
							currentVillain.villainHealth -= 50;
						}
								
						else if (result == 0) {
							lblResult.setText("lost");
							currentHero.healthLevel -= 20;
						}					
					}	
				} else { 
					Speech.setText("You have not Selected an attack!");
				}
			}
			if (AttackMade  && result != 3) {
				VillainHealth.setValue(currentVillain.villainHealth);
				Herohealth.setValue(currentHero.healthLevel);
				vRSP = ranNum.nextInt(3);
				vDice = ranNum.nextInt(6) + 1;
			}
			
			if (result == 1 || result == 0 || result == 2) {
				if (result == 0 && currentHero.shield) {
					currentHero.shield = false;		// Power gets deactivated after use
				}
				if (result == 1 && currentHero.powerBoost) {
					currentHero.powerBoost = false; // Power gets deactivated after use
				}
				btnAttack.setEnabled(false);
				btnPlayNextRound.setEnabled(true);
			}
			if (currentVillain.villainHealth < 1) {						// The villains health hits 0, it is defeated and the next city button if activated
				Speech.setText("Villain has been Defeated!, you have earned a reward of 50 gold!");
				manager.goldCount += 50;
				lblVillain.setIcon(null);
				NextCity.setVisible(true);
				btnAttack.setEnabled(false);
				btnPlayNextRound.setEnabled(false);
				villainSpeech.setText("<html>Noooo! I have been defeated!</br></html>");
				manager.defeatedVillains += 1;
				if (manager.defeatedVillains == manager.CityNum) {
					Speech.setText("<html>You have defeated the super villain, the last city has been completed!</br><html>");
				}
			}	
			if (currentHero.healthLevel < 1) {
				Speech.setText("<html>The hero has been defeated by the villain, select another hero to battle!</br><html>");
				btnAttack.setEnabled(false);
				btnPlayNextRound.setEnabled(false);
				lblFightingHero.setIcon(null);
				cboMoves.setEnabled(false);
				secondNumber.setEnabled(false);
				if (manager.team.heroes.indexOf(currentHero) == 0) {
					Hero.setIcon(null);
					manager.heroIcon = null;
				}
				else if (manager.team.heroes.indexOf(currentHero) == 1) {
					Hero2.setIcon(null);
					manager.heroIcon2 = null;
				}
				else if (manager.team.heroes.indexOf(currentHero) == 2) {
					Hero3.setIcon(null);
					manager.heroIcon3 = null;
				}
				
				manager.HeroNum -= 1;
				if (manager.HeroNum == 0) {
					lblFightingHero.setIcon(null);
					GameOver.setEnabled(true);
					GameOver.setVisible(true);
					btnAttack.setEnabled(false);
					btnPlayNextRound.setEnabled(false);
					Speech.setText("<html>You have been defeated by the villains,and no more heroes to continue the battle</br></html>");
					openGameover();
				} else {
					cboMoves.setSelectedIndex(0);
					secondNumber.setSelectedIndex(0);
					manager.team.heroes.remove(currentHero);
					currentHero = manager.team.heroes.get(0);
				}
		}
		}
		});		
		
		Border Dborder = BorderFactory.createLineBorder(Color.BLACK);
		Border Nborder = BorderFactory.createLineBorder(Color.YELLOW);
		
		JLabel lblShield = new JLabel("");
		//Border is black by default
		lblShield.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblShield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblShield.setBorder(Nborder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblShield.setBorder(Dborder);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = "Shield";
				btnActivate.setEnabled(true);
				Speech.setText("<html>You have selected " + currentItem + "</br>Click use to activate this item, the item can only be activated if the hero is equipped with the power up!</html>");
			}
		});	
		
		lblShield.setBackground(Color.GRAY);
		lblShield.setMinimumSize(new Dimension(35, 45));
		lblShield.setBounds(15, 272, 61, 62);
		frame.getContentPane().add(lblShield);
		
		JLabel lblFutureSight = new JLabel("");
		lblFutureSight.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFutureSight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFutureSight.setBorder(Nborder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFutureSight.setBorder(Dborder);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = "Future Sight";
				btnActivate.setEnabled(true);
				Speech.setText("<html>You have selected " + currentItem + "</br>Click use to activate this item, the item can only be activated if the hero is equipped with the power up!</html>");
			}
		});	
		lblFutureSight.setMinimumSize(new Dimension(49, 45));
		lblFutureSight.setBounds(15, 204, 61, 57);
		frame.getContentPane().add(lblFutureSight);
		
		
		JLabel lblPowerUp = new JLabel("");
		lblPowerUp.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblPowerUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPowerUp.setBorder(Nborder);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPowerUp.setBorder(Dborder);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				currentItem = "Power Boost";
				btnActivate.setEnabled(true);
				Speech.setText("<html>You have selected " + currentItem + "</br>Click use to activate this item, the item can only be activated if the hero is equipped with the power up!</html>");
			}
		});	
		lblPowerUp.setMinimumSize(new Dimension(40, 45));
		lblPowerUp.setBounds(16, 134, 60, 58);
		frame.getContentPane().add(lblPowerUp);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(85, 0, 256, 37);
		label_1.setText(manager.TeamName);
		frame.getContentPane().add(label_1);
		
		JLabel PowerMessage = new JLabel("");
		PowerMessage.setFont(new Font("Dialog", Font.BOLD, 13));
		PowerMessage.setForeground(Color.WHITE);
		PowerMessage.setBounds(112, 147, 203, 25);
		frame.getContentPane().add(PowerMessage);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(VillainGameGUI.class.getResource("/Images/VillainLair.png")));
		Background.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VillainLair.png")).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH)));
		Background.setBounds(0, 0, 700, 500);
		frame.getContentPane().add(Background);
	}
}
