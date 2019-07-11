public class Villains {
	//Six, each one have favourite game and , can play same game again, final villain is stronger
	
	public String villainName;
	public String villainTaunt;
	public int villainGame;
	public int villainHealth;
	
	//Facing the villain
	public Villains (String name, String taunt, int preferedGame, int health){
		villainName = name;
		villainTaunt = taunt;
		villainGame = preferedGame;
		villainHealth = health;
		
	}
}