public class PowerUp_den {
	public String direction;
	public boolean powerBoost = false;
	public boolean shield = false;
	public boolean futureSight = false;
	
	//Sets the direction
	public void setLocation (String powerUp) {
	direction = powerUp;
	}
	
	public void powerUp(String decision) {
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