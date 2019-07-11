
import java.util.Random;
/**
 * Class guessTheNumberGui
 * processes the guessing the number game
 * @category
 *
 */
public class guessTheNumberGui {
	public int result;
	public int villainNum;
	Random ranNum = new Random();
	
	public int gameResult(int heroGuess, int villainAnswer) {
		
		boolean won = false;
		boolean lost = false;
		
		villainNum = villainAnswer;
		
		while (!lost && !won) {
			//hero lost
			if (heroGuess != villainNum) {
				result = 0;
				lost = true;
			}
			//hero got it right
			else if (heroGuess == villainNum) {
				result = 1;
				won = true;
			}
		}
		
		return result;
	}

}