import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	public String TeamName = "";
	public int Money = 100;
	ArrayList <Heroes> heroes = new ArrayList<>();
	public ArrayList<Maps> maps = new ArrayList<Maps>();
	public int heroCount;
	
	
	//Setting the team name
	public Team(String name) {
		TeamName = name;
	}
	
	public String toString() {
		return "Your team name is now set to " + TeamName + ".";
	}
	
	//Forming the team
	public Team() {
		ArrayList <Heroes> heroes = new ArrayList<>();
		heroCount = heroes.size();
	}
	
	public void addHero(Heroes hero) {
		heroes.add(hero);
		Scanner askName = new Scanner(System.in);
		System.out.println("What would you like to name your hero?");
		String name = askName.nextLine();
		hero.setName(name);
		System.out.println(hero.heroName + " has been added to the team.");
	}
	 
	public void removeHero(Heroes hero) {
		heroes.remove(hero);
		System.out.println(hero.heroName + " has passed out, and is removed from the team.");
	}
	

}