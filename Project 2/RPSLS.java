import java.util.*;
/**
 * @author Arthur Laks
 * CSIT 210 - Project 2
 * Overview: Simulates a game of Rock, Paper, Scissors, Lizard, Spock against the computer.
 * Input: Asks user if he wants to play a "best of" game, asks the user to choose one of the five gestures, and 
 if he wants to play again.
 * Output: Outputs the computer's choice, who won the round and the total score at the end of the game.
 * Variables: Scanner input, Random generator; HashMaps<Players,Integer> victories; Players player;
 int victoriesNeeded; String response; Gesture usersChoice, computersChoice, IllegalArgumentException e;
 Players winner;
 * Plan:
 * 1. Declares and initializes a HashMap mapping each player to an int to keep track of how many victories each
 player won. 
 * 2. Asks the user if he wants a "best of" competition".
 * 3. Asks the user to choose one of the five gestures.
 * 4. Chooses one of the gestures for the computer based on a random number.
 * 5. If the choices are the same, declares the game a tie.
 * 6. If the ordinals of the two gestures are two or less apart, declares the player who picked the gesture with
 the higher ordinal as the winner.
 * 7. If the ordinals are more than two apart, declares the player with the lower ordinal a the victor.
 * 8. Adds one to the int that maps to the victor's key in the HashTable.
 * 9. If the user choose not to have a "Best of" competition, asks the user if he wants to quit.
 * 10. If the user choose to have a "best of" competition, if one player won the required number of rounds then 
 declares that player the winner of that cycle and breaks out of the loop.
 * 11. After breaking out of the loop, displays the total victories of each player and the number of ties.
 * @version 1.0 2013/03/26
 */
public class RPSLS {
	/**
	 * Stores the five gestures in such an order that each gesture beats the two before it and is beaten by the
two after it.
	 */
	private enum Gestures{
		rock,
		spock,
		paper,
		lizard,
		scissors
	}
	/**
	 * The three possible outcomes of a game.
	 */
	private enum Players{
		Computer,
		User,
		Tie
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		Random generator=new Random();
		HashMap<Players,Integer> victories = new HashMap<Players,Integer>();	//Keeps track of the number of
		//victories of each player.
		//Initializes the members of victories to 0.
		for(Players player:Players.values()){
			victories.put(player, 0);
		}
		int victoriesNeeded=0;	//If the user chooses a best of competition, stores the number of victories needed
		//to win the competition.  If not, remains 0.
		System.out.println("How about a \"best of\" competition? (3,5,7)");
		String response=input.next();
		if(response.equals("3")||response.equals("5")||response.equals("7"))
			victoriesNeeded=Integer.parseInt(response)/2+1;		//victoriesNeeded should be the majority of
		//the number that the user chose.
		do{
			System.out.println("Please enter rock, paper, scissors, lizard, or spock: ");
			Gestures usersChoice;
			try {	
				usersChoice = Gestures.valueOf(input.next().toLowerCase());	//Ignores case.
			} catch (IllegalArgumentException e) {	//If the user picked an invalid option
				System.out.println("Invalid option.");
				continue;	//Skip to the next round.
			}
			Gestures computersChoice=Gestures.values()[generator.nextInt(5)];
			Players winner;
			if(usersChoice==computersChoice)
				winner=Players.Tie;
			else
				//Gestures is sorted in such a way that every gestures beats the two before it and is beaten
				//by the two after it.  If the two choices are two or less apart then the higher number wins.
				if(Math.abs(usersChoice.ordinal()-computersChoice.ordinal())<=2)
					if(usersChoice.ordinal()>computersChoice.ordinal())
						winner=Players.User;
					else
						winner=Players.Computer;
			//If they are more than two apart then the list warps and the one who picked the lower number wins.
				else
					if(usersChoice.ordinal()<computersChoice.ordinal())
						winner=Players.User;
					else
						winner=Players.Computer;
			switch(winner){
			case User:
				System.out.printf("The computer selected %s --- You Win!\n",computersChoice.toString());
				break;
			case Computer:
				System.out.printf("The computer selected %s --- You Lose!\n", computersChoice.toString());
				break;
			case Tie:
				System.out.printf("The computer also selected %s --- Tie Game!\n",computersChoice.toString());
			}
			victories.put(winner, victories.get(winner)+1);	//Update the appropriate key in victories.
			if(victoriesNeeded==0){		//If the game is not a best of competition then ask the user if he 
				//wants to quit.
				System.out.println("Do you want to play again (Y/N)?");
				if(input.next().equalsIgnoreCase("N"))
					break;
			}
			else{	//If the user choose a best of competition
				if(victories.get(Players.Computer)==victoriesNeeded){	//If the computer won the required number
					//of victories
					System.out.println("The computer won the cycle.");
					break;
				}
				if(victories.get(Players.User)==victoriesNeeded){	//If the user won the required number of victories
					System.out.println("You won the cycle.");
					break;
				}
			}
		}while(true);	//The code inside of the loop breaks out of it when the user chooses to quit or when
		//one of the players won the required number of competitions
		//Display the number of victories of each player
		for(Players player:Players.values()){
			System.out.printf("%s - %d\n",player,victories.get(player));
		}
		input.close();
	}
}
