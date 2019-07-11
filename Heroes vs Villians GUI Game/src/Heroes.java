public class Heroes {
	public int heroNum;
	public String heroType;
	public int healthLevel;
	public int heroDamage;
	public String heroAbility;
	public String heroName = "";
	public boolean powerBoost;// move this to hero class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public boolean shield;// move this to hero class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public boolean futureSight;// move this to hero class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	

	
	//Setting number of heroes
	public Heroes(int numHeroes) {
		heroNum = numHeroes;
	}
	
	
	//Setting hero status
	public Heroes(String type, int health, int damage, String specialAbility, boolean boost, boolean shieldItem, boolean sight) {//need to add three more attributes
		heroType = type;
		healthLevel = health;
		heroDamage = damage;
		heroAbility = specialAbility;
		powerBoost = boost;//change
		shield = shieldItem;//change
		futureSight = sight;//change
		
	}
	
	
	//Setting the heroes' names
	public void setName(String name) {
		heroName = name;
	}
	
	
	
	public void powerUp(String decision) {// move this to hero class!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (decision == "Power boost") {
			powerBoost = true;
		}
		if (decision == "Shield") {
			shield = true;
		}
		if (decision == "Future sight") {
			futureSight = true;
		}
	}
	

	

}