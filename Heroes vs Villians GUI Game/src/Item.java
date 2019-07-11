
public class Item {
	public int UltimatePotion = 50;
	public int SuperPotion = 30;
	public int Potion = 20;
	public int PowerBoost = 40;
	public int FutureSight = 40;
	public int Shield = 60;
	public int price;
	public String name;
	public String direction;
	public String s_potion = "Potion";
	public String s_superPotion = "Super Potion";
	public String s_ultimatePotion = "Ultimate Potion";
	public String s_powerBoost = "Power Boost";
	public String s_futureSight = "Future Sight";
	public String s_shield = "shield";
	
	public void setLocation (String shop) {
		direction = shop;
	}
	
	public int Itemprice(int item) {						// returns the item price associated with the number
		if (item == 1) {
			price = Potion;
		}
		if (item == 2) {
			price = SuperPotion;
		}
		if (item == 3) {
			price = UltimatePotion;
		}
		if (item == 4) {
			price = PowerBoost;
		}
		if (item == 5) {
			price = FutureSight;
		}
		if (item == 6) {
			price = Shield;
		}
		return price;
	}
	
	public String toItemString(int item) {					// return the item name or string associated with the number 
		if (item == 1) {
			name = s_potion;
		}
		if (item == 2) {
			name = s_superPotion;
		}
		if (item == 3) {
			name = s_ultimatePotion;
		}
		if (item == 4) {
			name = s_powerBoost;
		}
		if (item == 5) {
			name = s_futureSight;
		}
		if (item == 6) {
			name = s_shield;
		}
		return name;
	}
	}

