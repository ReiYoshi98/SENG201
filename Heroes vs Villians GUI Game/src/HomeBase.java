import java.util.List;

public class HomeBase {
	public static List<String> itemArray;
	public static List<String> healingArray;

public void addItems(String item) {
	itemArray.add(item);
	System.out.println("You bought " + item + "."
			+"\nThe item will be avaliable to use in Power-Up den");
	}

public void itemUsed(String item) {
	itemArray.remove(item);
}





}