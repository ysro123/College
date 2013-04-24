package thirtyThree;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 * Author: Arthur Laks
 * CSIT 210 - Project 3
 * Overview: The driver class.  This class uses the other three classes to handle the actual game play
 * Input: Asks the user whether he wants to play and whether he wants to draw another card and whether he
 wants to play another game.
 * Output: Displays the cards that it drew for the user and the dealer and the values of the respective hands
 and the winner of each game.
 * Variables: input, victories, cOutcome (variables starting with c are the counters for foreach loops), 
 response (used throughout the program to store the input), deck, dealer, player, counter, winner.
 * Plan:
 * 1. Declares and initiates a Hashmap with the Outcome enum as the key and Integer as the value to store
 the outcomes of past games.
 * 2. Asks the user if he wants to play.
 * 3. If he does, declares and initiates a deck and a hand for each player.
 * 4. Picks three cards for the user and displays the total value of his cards.
 * 5. Asks the user if he wants to pick more cards until he says no or his total reaches 33.
 * 6. Picks cards for the dealer until the total exceeds 26.
 * 7. If the values of both hands are equal or they both exceed 33, make the game a push.
 * 8. If the player's hand is less than 33 and it exceeds the dealer's hand or the dealer's hand exceeds 33,
 the player wins.
 * 9. If none of the first two conditions are true, the dealer wins.
 * 10. Increments the value corresponding to the winner in the hashmap.
 * 11. Displays the outcome of the current game and the outcome of past games.
 * 12. Plays a new game (going back to step 3) until the player types 'Q' or wins five games.
 * @version 1.0 2013-04-23
 */
public class Thirty3 {
	/**
	 * Contains the three possible outcomes of a game.
	 */
	private enum Outcome{
		DEALER
		, PLAYER
		, PUSH
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//This Map is used the store the number of past games of each outcome.
		Map<Outcome,Integer> victories=new HashMap<Outcome,Integer>();
		for(Outcome cOutcome:Outcome.values()){	//Initialize each value by setting it to 0.
			victories.put(cOutcome, 0);
			}
		System.out.print("Welcome to Thirty3.\n\n");
		System.out.print("Would you like to play? (Y/Q)");
		String response=input.next();
		while(!response.equalsIgnoreCase("Q")){		//While the user does not type 'q' to the question of
			//whether he wants to quit, which is asked before the loop and at the end of the loop.
			Deck deck=new Deck();	//The deck and the hands are re-initialized in every iteration of the
			//loop so that they will be reset for each game.  I assume that the same card can be picked twice
			//between different games.
			Hand dealer=new Hand();
			Hand player=new Hand();
			//Draw two cards for the player.  The third card is
			//drawn at the beginning of the next loop.
			player.addCard(deck.draw());
			player.addCard(deck.draw());
			//This loop runs until the user types 'n' or his hand goes equals or exceeds 33.
			do{
				player.addCard(deck.draw());
				System.out.println("Your cards: "+player.toString());
				//If the hand is equal to or greater than 33 then do not even ask the user if he wants
				//to draw another card.
				if(player.value()>=33)	
					break;
				System.out.print("Would you like to draw another card (Y/N)?");
				response=input.next();
			}while(!response.equalsIgnoreCase("N"));
			//Draw cards for the dealer until his hand is equal to or greater than 26.
			while(dealer.value()<26)
				dealer.addCard(deck.draw());
			System.out.println("The dealers cards: "+dealer.toString());
			Outcome winner;
			//If the two hands are of the same value or both exceed 33 (if lower one is greater than 33
			//then both of them must be greater the 33), then the game is a push.
			if(player.value()==dealer.value()||Math.min(player.value(),dealer.value())>33)
				winner=Outcome.PUSH;
			else{
				//If the player's hand not greater than 33 and if the dealer has more than 33 or the player
				//has more than the dealer then the player won.
				if(player.value()<=33&&(dealer.value()>33||player.value()>dealer.value()))
					winner=Outcome.PLAYER;
				else	//If none of the above if-statements are true then the dealer won.
					winner=Outcome.DEALER;
			}
			victories.put(winner, victories.get(winner)+1);	//Increment the value of the player who won in
			//victories.
			//Display the appropriate message.
			switch(winner){
			case DEALER:
				System.out.print("You lose!");
				break;
			case PLAYER:
				System.out.print("You win!");
				break;
			case PUSH:
				System.out.print("You push!");
				break;
			}
			System.out.print(" - Current Total - ");
			//Print the outcomes of previous games.
			for(Outcome cOutcome:Outcome.values()){	//For each possible outcome, display its value in
				//the map.
				System.out.printf("%s-%d ", cOutcome.toString().toLowerCase(),victories.get(cOutcome));
			}
			System.out.println();	//Skip to next line (everything from the switch statement were printed
			//on one line).
			//If the user won five times quit and don't even ask the user if he wants to play again.
			if(victories.get(Outcome.PLAYER)==5)
				break;
			System.out.print("Do you want to play again (Y/Q)?");
			response=input.next();
		}
		input.close();
	}

}
