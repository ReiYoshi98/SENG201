import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Window.Type;
import javax.swing.JTextPane;
import java.awt.Dimension;

public class SetupScreen {

	private JFrame frmSetupScreen;
	private JTextField txtCharactersLong;
	private GUI_MAIN manager;
	
	public SetupScreen(GUI_MAIN incomingManager) {
		manager = incomingManager;
		initialize();
		frmSetupScreen.setVisible(true);
	}
	
	public void closeWindow() {
		manager.closeMainScreen(this);
	}
	
	public void finishedWindow() {
		frmSetupScreen.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmSetupScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupScreen = new JFrame();
		frmSetupScreen.getContentPane().setBackground(Color.GRAY);
		frmSetupScreen.setMinimumSize(new Dimension(710, 530));
		frmSetupScreen.setResizable(false);
		frmSetupScreen.setSize(new Dimension(550, 400));
		frmSetupScreen.setPreferredSize(new Dimension(600, 400));
		frmSetupScreen.setTitle("Setup Screen");
		frmSetupScreen.setBounds(100, 100, 550, 400);
		frmSetupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupScreen.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToHeroes = new JLabel("Welcome to Heroes vs Villains!");
		lblWelcomeToHeroes.setFont(new Font("Dialog", Font.BOLD, 15));
		lblWelcomeToHeroes.setBounds(221, 24, 262, 29);
		frmSetupScreen.getContentPane().add(lblWelcomeToHeroes);
		
		JLabel lblNameYourTeam = new JLabel("Name your heroes team:");
		lblNameYourTeam.setBounds(76, 92, 190, 15);
		frmSetupScreen.getContentPane().add(lblNameYourTeam);
		
		txtCharactersLong = new JTextField();
		txtCharactersLong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setName(txtCharactersLong.getText());
			}
		});
		
		JLabel errorText = new JLabel("");
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Dialog", Font.PLAIN, 9));
		errorText.setBounds(232, 65, 184, 15);
		frmSetupScreen.getContentPane().add(errorText);
		txtCharactersLong.setForeground(Color.LIGHT_GRAY);
		txtCharactersLong.setBounds(73, 119, 165, 19);
		frmSetupScreen.getContentPane().add(txtCharactersLong);
		txtCharactersLong.setColumns(10);
		
		JLabel lblHowManyCities = new JLabel("How many cities do you wish to explore?");
		lblHowManyCities.setBounds(73, 198, 299, 19);
		frmSetupScreen.getContentPane().add(lblHowManyCities);
		
		JLabel lblHowManyHeroes = new JLabel("How many heroes do you want in your team?");
		lblHowManyHeroes.setBounds(78, 309, 367, 19);
		frmSetupScreen.getContentPane().add(lblHowManyHeroes);
		
		JLabel lblTeamName = new JLabel("Team Name");
		lblTeamName.setBackground(Color.ORANGE);
		lblTeamName.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				manager.setName(lblTeamName.getText());
			}
		});
		lblTeamName.setForeground(Color.BLACK);
		lblTeamName.setBounds(459, 124, 89, 15);
		frmSetupScreen.getContentPane().add(lblTeamName);
		
		JLabel lblCityNumber = new JLabel("City Number");
		lblCityNumber.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				manager.setNumCity(Integer.valueOf(lblCityNumber.getText()));
			}
		});
		lblCityNumber.setForeground(Color.BLACK);
		lblCityNumber.setBounds(459, 231, 89, 15);
		frmSetupScreen.getContentPane().add(lblCityNumber);
		
		JLabel lblHeroNumber = new JLabel("Hero number");
		lblHeroNumber.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				manager.setHeroNum(Integer.valueOf(lblHeroNumber.getText()));
			}
		});
		lblHeroNumber.setForeground(Color.BLACK);
		lblHeroNumber.setBounds(459, 352, 104, 15);
		frmSetupScreen.getContentPane().add(lblHeroNumber);
		
		JLabel Tick1 = new JLabel("");
		Tick1.setBounds(559, 119, 49, 29);
		frmSetupScreen.getContentPane().add(Tick1);
		
		JLabel Tick2 = new JLabel("");
		Tick2.setBounds(559, 228, 49, 29);
		frmSetupScreen.getContentPane().add(Tick2);
		
		JLabel Tick3 = new JLabel("");
		Tick3.setBounds(559, 349, 49, 29);
		frmSetupScreen.getContentPane().add(Tick3);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (2 < txtCharactersLong.getText().length() && txtCharactersLong.getText().length() < 11) {
					lblTeamName.setText(txtCharactersLong.getText());
					manager.nameSet = true;
					Tick1.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Green-Tick-PNG-Picture.png")));
					Tick1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Green-Tick-PNG-Picture.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
					errorText.setText("");
				} else {
					errorText.setText("Must be between 2 to 10 Characters");
				}
			}
		});
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.GRAY);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblCityNumber.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.setMinorTickSpacing(1);
		slider.setValue(3);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinimum(3);
		slider.setMaximum(6);
		slider.setBounds(73, 228, 267, 29);
		frmSetupScreen.getContentPane().add(slider);
		
		btnNewButton.setFont(new Font("DejaVu Sans Light", Font.BOLD, 9));
		btnNewButton.setBounds(370, 121, 49, 19);
		frmSetupScreen.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("OK");
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCityNumber.setText(lblCityNumber.getText());
				Tick2.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Green-Tick-PNG-Picture.png")));
				Tick2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Green-Tick-PNG-Picture.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
				manager.CityNum = Integer.valueOf(lblCityNumber.getText());
				manager.cityNumberSet = true;
			}
		});
		button.setFont(new Font("DejaVu Sans Light", Font.BOLD, 9));
		button.setBounds(370, 228, 49, 19);
		frmSetupScreen.getContentPane().add(button);
		
		JButton button_1 = new JButton("OK");
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHeroNumber.setText(lblHeroNumber.getText());
				Tick3.setIcon(new ImageIcon(HeroScreen.class.getResource("/Images/Green-Tick-PNG-Picture.png")));
				Tick3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Green-Tick-PNG-Picture.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
				manager.HeroNum = Integer.valueOf(lblHeroNumber.getText());
				manager.heroNumberSet = true;
			}
		});
		button_1.setFont(new Font("DejaVu Sans Light", Font.BOLD, 9));
		button_1.setBounds(370, 349, 49, 19);
		frmSetupScreen.getContentPane().add(button_1);
		
		JSlider slider_1 = new JSlider();
		slider_1.setBackground(Color.GRAY);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblHeroNumber.setText(Integer.toString(slider_1.getValue()));
			}
		});
		slider_1.setValue(1);
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(1);
		slider_1.setMaximum(3);
		slider_1.setBounds(78, 349, 267, 29);
		frmSetupScreen.getContentPane().add(slider_1);
		
		JLabel ErrorText = new JLabel("");
		ErrorText.setFont(new Font("Dialog", Font.BOLD, 14));
		ErrorText.setForeground(Color.RED);
		ErrorText.setBounds(79, 421, 277, 27);
		frmSetupScreen.getContentPane().add(ErrorText);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manager.nameSet && manager.cityNumberSet && manager.heroNumberSet) {
					closeWindow();
				} else {
					ErrorText.setText("Settings imcomplete");
				}
			}
		});
		btnEnter.setBounds(417, 421, 184, 35);
		frmSetupScreen.getContentPane().add(btnEnter);
	}
}
