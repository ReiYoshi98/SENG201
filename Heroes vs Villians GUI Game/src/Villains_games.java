
import java.util.Random;
import java.util.Scanner;

public class Villains_games {
	
	
	public Team teamPlaying;
	public boolean victory = false;
	
	
	
	
	public void teamUpdate(Team team) {
		
	}

	
	
	
	public void game_Result(boolean result) {
		victory = result;
	}
	
	
	
	
	public boolean return_Result() {
		return victory;
	}
	
	
	
	
	public void setTeam(Team team) {
		teamPlaying = team;
	}
	
	
	
	
	public void villains_games(int gameNum, Heroes currentHero, Team currentTeam, Villains currentVillain) {
		
		
		
		//power boost, shield, 

		boolean defeat = false;

		GAME:
		while (!victory && !defeat) {
			

			
			//Rock scissors paper
			GAME1:
			while (gameNum == 1) {
				
				// start
				Random randomRSP = new Random();
				
				Scanner userRSP = new Scanner(System.in);
					
				int userNum, comNum;
					
				System.out.println("Enter move:"
						+ "\n0. Rock"
						+ "\n1. Paper"
						+ "\n2. Scissors");
				userNum = userRSP.nextInt();
				//computer makes move
				comNum = randomRSP.nextInt(2);
				
				boolean playing = true;
				
				
				//Attacker two's special skill
				Random attackerTwo_damage = new Random();
				int doubleDamage = attackerTwo_damage.nextInt(100);
				
				
					
				// playing
				GAME1plying:
				while (playing) {
				//same move
					
					
					//special skills (Attacker two)
					if (currentHero.heroType.equals("Attacker_two")) {
						if (doubleDamage <= 25) {
							System.out.println(doubleDamage);
							currentVillain.villainHealth -= 50;
							System.out.println("The hero did a quick attack.");
						}
					}
					
					//future sight item
					if (currentHero.futureSight) {
						System.out.println("The hero used the future sight item");
						if (comNum == 0) {
							System.out.println("The villain's move is Rock");
							currentHero.futureSight = false;
						}
						
						else if (comNum == 1) {
							System.out.println("The villain's move is Paper");
							currentHero.futureSight = false;
						}
						
						else if (comNum == 2) {
							System.out.println("The villain's move is Scissors");
							currentHero.futureSight = false;
						}
					}
					
					
					
					if (userNum == comNum) {
						if (userNum == 0) {
							System.out.println("Both Rock");
						}
								
						else if (userNum == 1) {
							System.out.println("Both Paper");
						}
								
						else if (userNum == 2) {
							System.out.println("Both Scissors");
						}
						
						//Restart
						continue GAME1;	
					}
						
					
							
					// win or loss
					//user : rock
					if (userNum == 0) {
						if (comNum == 1) {
							System.out.println("You : rock, Com : paper"
									+ "\nlost");
							
							//shield used (dodges an attack)
							if (currentHero.shield) {
								System.out.println("The hero used the shield item");
								currentHero.shield = false;
								continue GAME1;
							}
							
							
							currentHero.healthLevel -= 20;
							System.out.println("The hero has taken -20 damage");
							
							if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
								currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
								
								if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
									defeat = true; // You are defeated
									continue GAME;
								}
								
								
								else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
									
									Scanner newHero = new Scanner(System.in);
									System.out.println("--------- Current team: " + currentTeam + " ---------"
											+ "\nchoose the new one");
									String heroNew = newHero.nextLine();
									
									CHOOSNEW:
									for (Heroes h : currentTeam.heroes) {
										if (h.heroName.equals(heroNew)) {
											currentHero = h; // new hero is selected to battle
											continue GAME;
										}
										else {
											System.out.println("type again");
											continue CHOOSNEW;
										}
									}
									
								}
							}
							
							playing = false;
							break GAME1plying;
						}//if lost by rock
							
						
						
						
						//won checks if villain is killed and changes the game by 30%
						else {
							System.out.println("You : rock, Com : scissors"
									+ "\nwon");
							currentVillain.villainHealth -= 50;
							
							
							if (currentHero.powerBoost) {
								System.out.println("You used the powerboost item (Did an additional damage of 50)");
								currentVillain.villainHealth -= 50;
							}
							
							
							if (currentVillain.villainHealth <= 0) {  
								victory = true; //Once the heros kills the villain, it is victory.
								System.out.println("You have defeated the villain!!");
								continue GAME;
							}
							
							playing = false;
							continue GAME1plying;
									
						}
						
						
						
						
					}//user = rock
							
					
					
					
					
					
					
					//user : paper
					if (userNum == 1) {
						if (comNum == 0) {
							System.out.println("You : paper, Com : rock"
									+ "\nwon");
							currentVillain.villainHealth -= 50;
							
							if (currentHero.powerBoost) {
								System.out.println("You used the powerboost item (Did an additional damage of 50)");
								currentVillain.villainHealth -= 50;
							}
							
							if (currentVillain.villainHealth <= 0) {  
								victory = true; //Once the heros kills the villain, it is victory.
								System.out.println("You have defeated the villain!!");
								continue GAME;
							}
							
							
							playing = false;
							break GAME1plying;
									
						}
								
						else {
							System.out.println("You : paper, Com : scissors"
									+ "\nlost");
							
							//shield used (dodges an attack)
							if (currentHero.shield) {
								System.out.println("The hero used the shield item");
								currentHero.shield = false;
								continue GAME1;
							}
							
							
							currentHero.healthLevel -= 20;
							System.out.println("The hero has taken -20 damage");
							
							
							
							if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
								currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
								
								if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
									defeat = true; // You are defeated
									continue GAME;
								}
								
								
								else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
									
									Scanner newHero = new Scanner(System.in);
									System.out.println("--------- Current team: " + currentTeam + " ---------"
											+ "\nchoose the new one");
									String heroNew = newHero.nextLine();
									
									CHOOSNEW:
									for (Heroes h : currentTeam.heroes) {
										if (h.heroName.equals(heroNew)) {
											currentHero = h; // new hero is selected to battle
											continue GAME;
										}
										else {
											System.out.println("type again");
											continue CHOOSNEW;
										}
									}
									
								}
							}
							
							
							playing = false;
							break GAME1plying;
						}
					}
							
					
					
					
					
					
					
					
					
					
					
							
					//user : scissors
					if (userNum == 2) {
						if (comNum == 0) {
							System.out.println("You : scissors, Com : rock"
									+ "\nlost");
							
							//shield used (dodges an attack)
							if (currentHero.shield) {
								System.out.println("The hero used the shield item");
								currentHero.shield = false;
								continue GAME1;
							}
							
							
							currentHero.healthLevel -= 20;
							System.out.println("The hero has taken -20 damage");
							
							
							if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
								currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
								
								if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
									defeat = true; // You are defeated
									continue GAME;
								}
								
								
								else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
									
									Scanner newHero = new Scanner(System.in);
									System.out.println("--------- Current team: " + currentTeam + " ---------"
											+ "\nchoose the new one");
									String heroNew = newHero.nextLine();
									
									CHOOSNEW:
									for (Heroes h : currentTeam.heroes) {
										if (h.heroName.equals(heroNew)) {
											currentHero = h; // new hero is selected to battle
											continue GAME;
										}
										else {
											System.out.println("type again");
											continue CHOOSNEW;
										}
									}
									
								}
							}
							
							
							playing = false;
							break GAME1plying;
						}
								
						else {
							System.out.println("You : scissors, Com : paper"
									+ "\nwon");
							currentVillain.villainHealth -= 50;
							
							if (currentHero.powerBoost) {
								System.out.println("You used the powerboost item (Did an additional damage of 50)");
								currentVillain.villainHealth -= 50;
							}
							
							if (currentVillain.villainHealth <= 0) {  
								victory = true; //Once the heros kills the villain, it is victory.
								System.out.println("You have defeated the villain!!");
								continue GAME;
							}
							
							playing = false;
							break GAME1plying;
						}
								
					}
				}
				
				
				
				
				
				
				
				//should decide which game is next
				System.out.println("Villain may change the game now");
				int randomGame;
				Random randomGN = new Random();
				randomGame = randomGN.nextInt(9) + 1; // Generates a random number between 1-3
				if (randomGame <= 3 && randomGame != gameNum) { //30% chance of the game changing.
					gameNum = randomGame;
					System.out.println("Villain has changed the game1.");
					continue GAME;
				} // Changes the game if the random number is either 2 or 3, otherwise the preferred game is continued.
				
				else {
					continue GAME1;
				}
				
				
				
				
			}
				
				
				
			
			
			
			
			
			
			
			
			//Guess the number game
			GAME2:
			while (gameNum == 2) {
				
				
				
				Random randomNum = new Random();
				Scanner userGuess = new Scanner(System.in);
					
				int guess, comAnswer;
					
				comAnswer = randomNum.nextInt(10) + 1;
				
				boolean playing = true;
				
				
				//Attacker two's special skill
				Random attackerTwo_damage = new Random();
				int doubleDamage = attackerTwo_damage.nextInt(100);
				
				
				
				GAME2playing:
				while (playing) {

					boolean guessedRight = false;
					
					
					//special skills (Attacker two)
					if (currentHero.heroName.equals("Attacker_two")) {
						if (doubleDamage <= 25) {
							currentVillain.villainHealth -= 50;
							System.out.println("The hero did a quick attack.");
						}
					}
					
					
					//future sight item
					if (currentHero.futureSight) {
						System.out.println("The villain is thinking of " + comAnswer + "!");
						currentHero.futureSight = false;
					}
					
					
					
					if (comAnswer > 5 && comAnswer < 11) {
						System.out.println("Higher (6 ~ 10)");
						guess = userGuess.nextInt();
							
						int inCorrectHigher = 0;
						
						
						while (!guessedRight || inCorrectHigher < 2) {
							
							if (guess == comAnswer) {
								System.out.println("You guessed right");
								currentVillain.villainHealth -= 50;
								
								if (currentHero.powerBoost) {
									System.out.println("You used the powerboost item (Did an additional damage of 50)");
									currentVillain.villainHealth -= 50;
								}
								
								if (currentVillain.villainHealth <= 0) {  
									victory = true; //Once the heros kills the villain, it is victory.
									System.out.println("You have defeated the villain!!");
									continue GAME;
								}
								
								
								guessedRight = true;
								playing = false;
								continue GAME2playing;
							}
								
							else {
								System.out.println("Incorrect H");
								inCorrectHigher += 1;
								if (inCorrectHigher == 2) {
									
									
									//shield used (dodges an attack)
									if (currentHero.shield) {
										System.out.println("The hero used the shield item");
										currentHero.shield = false;
										continue GAME2;
									}
									
									
									currentHero.healthLevel -= 20;
									System.out.println("The hero has taken -20 damage");
									
									if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
										currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
										
										if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
											defeat = true; // You are defeated
											continue GAME;
										}
										
										
										else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
											
											Scanner newHero = new Scanner(System.in);
											System.out.println("--------- Current team: " + currentTeam + " ---------"
													+ "\nchoose the new one");
											String heroNew = newHero.nextLine();
											
											CHOOSNEW:
											for (Heroes h : currentTeam.heroes) {
												if (h.heroName.equals(heroNew)) {
													currentHero = h; // new hero is selected to battle
													continue GAME;
												}
												else {
													System.out.println("type again");
													continue CHOOSNEW;
												}
											}
											
										}
									}
									
									playing = false;
									continue GAME2playing;
								}
								playing = false;
								continue GAME2playing;
							}
						}
							
					}
					
					
					else if (comAnswer > 0 && comAnswer < 6) {
						System.out.println("Lower (1 ~ 5)");
						guess = userGuess.nextInt();
							
						int inCorrectLower = 0;
						
						
						while (!guessedRight || inCorrectLower < 2) {
							if (guess == comAnswer) {
								System.out.println("You guessed right");
								currentVillain.villainHealth -= 50;
								
								if (currentHero.powerBoost) {
									System.out.println("You used the powerboost item (Did an additional damage of 50)");
									currentVillain.villainHealth -= 50;
								}
								
								if (currentVillain.villainHealth <= 0) {  
									victory = true; //Once the heros kills the villain, it is victory.
									System.out.println("You have defeated the villain!!");
									continue GAME;
								}
								
								guessedRight = true;
								playing = false;
								continue GAME2playing;
							}
							
							
							
							
							else {
								System.out.println("Incorrect L");
								inCorrectLower += 1;
								if (inCorrectLower == 2) {
									
									
									//shield used (dodges an attack)
									if (currentHero.shield) {
										System.out.println("The hero used the shield item");
										currentHero.shield = false;
										continue GAME2;
									}
									
									
									currentHero.healthLevel -= 20;
									System.out.println("The hero has taken -20 damage");
									
									
									
									
									
									if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
										currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
										
										if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
											defeat = true; // You are defeated
											continue GAME;
										}
										
										
										else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
											
											Scanner newHero = new Scanner(System.in);
											System.out.println("--------- Current team: " + currentTeam + " ---------"
													+ "\nchoose the new one");
											String heroNew = newHero.nextLine();
											
											CHOOSNEW:
											for (Heroes h : currentTeam.heroes) {
												if (h.heroName.equals(heroNew)) {
													currentHero = h; // new hero is selected to battle
													continue GAME;
												}
												else {
													System.out.println("type again");
													continue CHOOSNEW;
												}
											}
											
										}
									}
									
									
									playing = false;
									continue GAME2playing;
								}
								playing = false;
								continue GAME2playing;
							}
							
							
						}
					}
				}
					
				
				
				
				
				
				
				
					
				//should decide which game is next
				System.out.println("Villain may change the game now");
				int randomGame;
				Random randomGN = new Random();
				randomGame = randomGN.nextInt(9) + 1; // Generates a random number between 1-10
				if (randomGame <= 3 && randomGame != gameNum) { //30% chance of the game changing.
					gameNum = randomGame;
					System.out.println("Villain has changed the game2.");
					continue GAME;
					
				} // Changes the game if the random number is either 2 or 3, otherwise the preferred game is continued.
				
				else {
					continue GAME2;
				}
					
					
			}//game2
				
				
				
				
				
				
				
			
			//Game 3 Roll the dice
			GAME3:
			while (gameNum == 3) {
				
				System.out.println("You and the villain will roll the dice and the higher one wins");
				
				int userDice, comDice;
				Random userRandomDice = new Random();
				Random comRandomDice = new Random();
				userDice = userRandomDice.nextInt(5) + 1;
				comDice = comRandomDice.nextInt(5) + 1;
				System.out.println("Here");
				
				
				//Attacker two's special skill
				Random attackerTwo_damage = new Random();
				int doubleDamage = attackerTwo_damage.nextInt(100);
				
				
				
				boolean playing = true;
				
				GAME3plying:
				while (playing) {
					
					//special skills (Attacker two)
					if (currentHero.heroName.equals("Attacker_two")) {
						if (doubleDamage <= 25) {
							currentVillain.villainHealth -= 50;
							System.out.println("The hero did a quick attack.");
						}
					}
					
					
					
					if (comDice == userDice) {
						System.out.println("Got same number. Again");
						continue GAME3;
					}
					
					
					else if (comDice < userDice) {
						System.out.println("You: " + userDice + "\nVillain: " + comDice + "\nYou won");
						
						currentVillain.villainHealth -= 50;
						
						if (currentHero.powerBoost) {
							System.out.println("You used the powerboost item (Did an additional damage of 50)");
							currentVillain.villainHealth -= 50;
						}
						
						if (currentVillain.villainHealth <= 0) {  
							victory = true; //Once the heros kills the villain, it is victory.
							System.out.println("You have defeated the villain!!");
							continue GAME;
						}
						
						playing = false;
						continue GAME3plying;
						
					}
					
						
					if (userDice > comDice) {
						System.out.println("You: " + userDice + "\nVillain: " + comDice + "\nYou lost");
						
						
						//shield used (dodges an attack)
						if (currentHero.shield) {
							System.out.println("The hero used the shield item");
							currentHero.shield = false;
							continue GAME3;
						}
						
						
						currentHero.healthLevel -= 20;
						System.out.println("The hero has taken -20 damage");
						
						
						if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
							currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
							
							if (currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
								defeat = true; // You are defeated
								continue GAME;
							}
							
							
							else if (currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
								
								Scanner newHero = new Scanner(System.in);
								System.out.println("--------- Current team: " + currentTeam + " ---------"
										+ "\nchoose the new one");
								String heroNew = newHero.nextLine();
								
								CHOOSNEW:
								for (Heroes h : currentTeam.heroes) {
									if (h.heroName.equals(heroNew)) {
										currentHero = h; // new hero is selected to battle
										continue GAME;
									}
									else {
										System.out.println("type again");
										continue CHOOSNEW;
									}
								}
								
							}
						}
						
						
						playing = false;
						continue GAME3plying;
					}
				}
				
				//should decide which game is next
				System.out.println("Villain may change the game now");
				int randomGame;
				Random randomGN = new Random();
				randomGame = randomGN.nextInt(9) + 1; // Generates a random number between 1-3
				if (randomGame <= 3 && randomGame != gameNum) { //30% chance of the game changing.
					gameNum = randomGame;
					System.out.println("Villain has changed the game3.");
					continue GAME;
				} // Changes the game if the random number is either 2 or 3, otherwise the preferred game is continued.
				
				else {
					continue GAME3;
						
				}
					
				
			}//game3

			
			//number of villain loosing
			boolean villainLost = false;
			boolean heroLost = false;
			while (!villainLost && !heroLost) { // While neither the hero or the villain has lost
					
				if (currentVillain.villainHealth <= 0) {  
					break;
				}
				
				if (heroLost && currentTeam.heroCount <= 0) { // if hero has lost and the there is no more hero's in the team
					defeat = true; // You are defeated
				}// dont need anymore?
				
				if(currentHero.healthLevel <=  0) { // If heroes health drops below 0
					currentTeam.removeHero(currentHero); // Remove the hero from the team (i.e the game)
					heroLost = true; // Set hero lost as true
				}// dont need anymore?
				

				if (heroLost && currentTeam.heroCount > 0) { // if hero has lost but you still have other heroes in team
					
					Scanner newHero = new Scanner(System.in);
					System.out.println("--------- Current team: " + currentTeam + " ---------"
							+ "\nchoose the new one");
					String heroNew = newHero.nextLine();
					
					CHOOSNEW:
					for (Heroes h : currentTeam.heroes) {
						if (h.heroName.equals(heroNew)) {
							currentHero = h; // new hero is selected to battle
							heroLost = false;
							continue GAME;
						}
						else {
							System.out.println("type again");
							continue CHOOSNEW;
						}
					} 
					
				}// dont need anymore?
				
				
				
				
			}//result process
			
			
			
			
			
			
			
		}//game loop
		
		
		
		
		
		
		
		
		return_Result();
		setTeam(currentTeam);
		
	}//game class
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}