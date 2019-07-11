public class rollDiceGui {
	public int result;
	
	
	public int gameResult (int heroDice, int villainDice) {
		
		if (heroDice == villainDice) {
			result = 2;
		}
		else if (heroDice > villainDice) {
			result = 1;
		}
		else if (heroDice < villainDice) {
			result = 0;
		}
		
		return result;
	}

}