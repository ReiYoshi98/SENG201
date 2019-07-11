public class Hospital {
	public String direction;
	public int potion = 25;
	public int superPotion = 50;
	public int ultimatePotion = 75;
	public int level;
	
	//Sets the direction
	public void setLocation (String hospital) {
		direction = hospital;
	}

	public int healingLevel (String item) {
		if (item.equals("Potion")) {
			level = potion;
		}
		if (item.equals("Super Potion")) {
			level = superPotion;
		}
		if (item.equals("Ultimate Potion")) {
			level = ultimatePotion;
		}
		return level;
	}
	
}
