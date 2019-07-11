public class RockScissorPaper {
	
	public int result;
	
	//0 = Rock
	//1 = Scissors
	//2 = Paper
	//
	//0 = lost
	//1 =  won
	public int gameResult(int heroMove, int villainMove) {
		//rock
		if (heroMove == 0) {
			//paper
			if (villainMove == 2) {
				//lost
				result = 0;
			}
			//scissors	
			else if (villainMove == 1) {
				//won
				result = 1;
			}
			//rock
			else if (villainMove == 0) {
				//draw
				result = 2;
			}
		}
			
		//scissors
		else if (heroMove == 1) {
			//paper
			if (villainMove == 2) {
				//won
				result = 1;
			}
			//rock
			else if (villainMove == 0) {
				//lost
				result = 0;
			}
			//scissors
			else if (villainMove == 1) {
				//draw
				result = 2;
			}
		}
		//paper
		else if (heroMove == 2) {
			//rock
			if (villainMove == 0) {
				//won
				result = 1;
			}
			//scissors
			else if (villainMove == 1) {
				//lost
				result = 0;
			}
			//paper
			else if (villainMove == 2) {
				//draw
				result = 2;
			}
		}
			
		return result;
	}
}