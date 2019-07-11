
import java.awt.Window;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GUI_MAIN {
	// System objects
	String TeamName; // The team name
	int CityNum; // number of cities
	int HeroNum; // number of heroes
	int goldCount = 100; // the amount of gold the team has (Money) which is initialized as 100
	boolean nameSet = false; // sets true once the name is set
	boolean cityNumberSet = false; // sets true once the name is set
	boolean heroNumberSet = false; // sets true once the hero number is set
	boolean hero1Set = false; // sets true once the hero name is set
	boolean hero2Set = false; // sets true once the hero name is set
	boolean hero3Set = false; 
	int cityNumber = 1; // A variable which keeps record of the current city number
	ArrayList<String> itemArray = new ArrayList<String>(); // Initializing the array which holds all the items through out the game;
	String heroIcon = ""; // The icon string for the hero selected in the hero screen. We can use this string to set the same icon in other application windows.
	String heroIcon2 = "";
	String heroIcon3 = "";
	Heroes hero1;
	Heroes hero2;
	Heroes hero3;
	Heroes wizard;
	Team team = new Team(); 			// Holds the team which is selected in the hero screen
	Item shop = new Item();				// Holds the items of the team
	Hospital hospo = new Hospital();	// Contains the information for healing items
	List<String> map;					// A list which contains a list of directions 
	String northIcon;			// Strings for setting the icons in the correct location for the changing map
	String southIcon;
	String westIcon;
	String eastIcon;
	ArrayList <Villains> villains = new ArrayList<>();// The list of villains to defeat
	Villains pawn = new Pawn();
	Villains knight = new Knight();
	Villains rook = new Rook();
	Villains bishop = new Bishop();
	Villains queen = new Queen();
	Villains king = new King();
	int defeatedVillains = 0;
	Random random = new Random();
	int randomNum;			// Used for the random events
	boolean teamGifted = false;
	boolean teamRobbed = false;
	
	// Launches the set up screen
	public void launchMainScreen() {	
		map = randomizeMap();// Launches the set up screen GUI
		setMap(map);
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	// Closes the set up screen() {
	public void closeMainScreen(SetupScreen window) {			// Closes the set up screen, then launches the Hero screen 
		window.finishedWindow();
		launchHeroScreen();
	}
	
	// Getter of the team name
	public String getName() {									// Return the team name when called upon in other GUI's
		return TeamName;
	}
	
	// Setter of the team name
	public void setName(String newName) {						// Setting a name 
		TeamName = newName;
	}
				
	public int getNumCity() {									// Returns the number of city when called upon in other GUI's
		return CityNum;
	}
	
	public void setNumCity(int num) {							// Sets the number of city 
		CityNum = num;
	}
	
	public void setHeroNum(int num) {							// Sets the number of heroes for the team
		HeroNum = num;
	}
	
	public void launchHeroScreen() { 							// Launching the hero selection screen
		// Robbing and gifting conditions here
		randomNum = random.nextInt(100);
		if (randomNum < 5) {	// 5% chance of being robbed
			teamRobbed = true;
		}
		if (randomNum > 90) {		// 10% chance of being gifted an item
			teamGifted = true;
		}
		HeroScreen HeroWindow = new HeroScreen(this);
	}
	
	// Closes the set up screen() {
	public void closeHerocreen(HeroScreen window) {				// Closes the hero screen then opens the first city window 
		window.finishedWindow();
		launchHomeScreen();
	}
	
	public void launchStatScreen() {							// Launches the hero info screen
		StatScreen windowBox = new StatScreen(this);
	}
	
	
	public void closeStatScreen(StatScreen window) {			// Closes the hero information screen from the hero screen window 
		window.finishedWindow();
	}
	
	public void launchHomeScreen() { 							// Launches the home base screen
		HomebaseScreen homeScreen = new HomebaseScreen(this);
	}
	
	public void closeHomeScreen(HomebaseScreen window) {		//	closes the home base screen when going other directions
		window.finishedWindow();
	}
	
	public void launchHospital() {								//  Launches the hospital screen
		HospitalGUI hospital = new HospitalGUI(this);
	}
	
	public void closeHospital(HospitalGUI window) {				// Closes the hospital screen and goes back to the home base
		window.finishedWindow();
	}
	
	public void launchItemShop() {								// Launches the item shop screen
		ItemShopScreen shop = new ItemShopScreen(this);
	}
	
	public void closeItemShop(ItemShopScreen window) {			// Closes the item Shop screen and goes back to the home base
		window.finishedWindow();
	}
	
	public void launchPowerup() {			// Launches the power up den screen
		PowerUpDenGUI powerup = new PowerUpDenGUI(this);
	}
	public void closePowerup(PowerUpDenGUI window) {			// Closes the power up den screen
		window.finishedWindow();
	}
	
	public void launchMapScreen() {
		MapScreen map = new MapScreen(this);
	}
	
	public void closeMapScreen(MapScreen window) {
		window.finishedWindow();
	}
	
	public void launchOpenScreen() {
		OpeningLairScreen opening = new OpeningLairScreen(this);
	}
	
	public void closeOpenScreen(OpeningLairScreen window) {
		window.finishedWindow();
	}
	
	public void launchGameover() {
		GameOverScreen over = new GameOverScreen(this);
	}
	
	public void closeGameover(GameOverScreen window) {
		window.finishedWindow();
	}
	
	public List<String> randomizeMap() {
		List<String> randomArray;
		String[] array = new String[] {"North", "West", "East", "South"};
		List<String> map = Arrays.asList(array);
		Collections.shuffle(map);
		randomArray = map;
		return randomArray;
	}
	
	public void setMap(List<String> l) {
		if (l.get(0).toString().equals("North")) {			//	Builds the map
			northIcon = "/Images/Hospital_House.png";
		}
		if (l.get(1).toString().equals("North")) {
			northIcon = "/Images/Item_Shop_house.png";
		}
		if (l.get(2).toString().equals("North")) {
			northIcon = "/Images/Power_up_den_House.png";
		}
		if (l.get(3).toString().equals("North")) {
			northIcon = "/Images/Villains_Lair.png";
		}
		
		if (l.get(0).toString().equals("South")) {
			southIcon = "/Images/Hospital_House.png";
		} 
		if (l.get(1).toString().equals("South")) {
			southIcon = "/Images/Item_Shop_house.png";
		}
		if (l.get(2).toString().equals("South")) {
			southIcon = "/Images/Power_up_den_House.png";
		}
		if (l.get(3).toString().equals("South")) {
			southIcon = "/Images/Villains_Lair.png";
		}
		
		if (l.get(0).toString().equals("West")) {
			westIcon = "/Images/Hospital_House.png";
		} 
		if (l.get(1).toString().equals("West")) {
			westIcon = "/Images/Item_Shop_house.png";
		}
		if (l.get(2).toString().equals("West")) {
			westIcon = "/Images/Power_up_den_House.png";
		}
		if (l.get(3).toString().equals("West")) {
			westIcon = "/Images/Villains_Lair.png";
		}
		
		if (l.get(0).toString().equals("East")) {
			eastIcon = "/Images/Hospital_House.png";
		} 
		if (l.get(1).toString().equals("East")) {
			eastIcon = "/Images/Item_Shop_house.png";
		}
		if (l.get(2).toString().equals("East")) {
			eastIcon = "/Images/Power_up_den_House.png";
		}
		if (l.get(3).toString().equals("East")) {
			eastIcon = "/Images/Villains_Lair.png";
		}
	}
	
	public void launchVillainGameGUI() {								// Launches the game screen
		VillainGameGUI villainGame = new VillainGameGUI(this);
	}
	
	public void closeVillainGameGUI(VillainGameGUI window) {			// Closes the game screen
		if (CityNum > defeatedVillains) {
			map = randomizeMap();// Launches the set up screen GUI
			setMap(map);
			cityNumber += 1;
			if (HeroNum != 0) {
				launchHomeScreen();
			}
		}
		else {
			launchCleared();
		}
		window.finishedWindow();
	}
	
	public ArrayList <Villains> villainSet(int number) {
		if (number == 3) {
			villains.add(rook);
			villains.add(queen);
			villains.add(king);
		}
		if (number == 4) {
			villains.add(bishop);
			villains.add(rook);
			villains.add(queen);
			villains.add(king);
		}
		if (number == 5) {
			villains.add(knight);
			villains.add(bishop);
			villains.add(rook);
			villains.add(queen);
			villains.add(king);
		}
		if (number == 6) {
			villains.add(pawn);
			villains.add(knight);
			villains.add(bishop);
			villains.add(rook);
			villains.add(queen);
			villains.add(king);
		}
		return villains;
	}
	
	public void launchCleared() {
		gameCleared cleared = new gameCleared(this);
	}
	
	public void closeCleared(gameCleared window) {
		window.finishedWindow();
	}
	
	public static void main(String[] args) {					
		GUI_MAIN start = new GUI_MAIN();
		start.launchMainScreen();
	}
}
			
		