/**
 * 
 */
package thirtyThree;
import thirtyThree.Card.Rank;
import thirtyThree.Card.Suite;
import java.util.LinkedList;
import java.util.Random;
/**
 * Author Arthur Laks
 * CSIT 210 - Project 3
 * Overview: Represents a deck of cards.
 * Description: When this class is initialized, it creates a linked list of cards and fills them with thirteen
 cards from each suite.  It contains a draw method that returns a random card from the linked list and 
removes it from the list so that it will not be drawn again.
 * Variable: cards, suites, ranks
 * @version 1.0 2013-04-23
 */
public class Deck {
	/**
	 * The underlying list of cards.
	 */
	private LinkedList<Card> cards=new LinkedList<Card>();
	/**
	 * Initializes a full deck of 52 cards.
	 */
	public Deck(){
		Suite[] suites=Suite.values();
		Rank[] ranks=Rank.values();
		for(Suite cSuite:suites){	//For each suite, add one card for each rank.
			for(Rank cRank:ranks){
				cards.add(new Card(cSuite,cRank));
			}
		}
	}
	/**
	 * Returns a card, randomly withdrawn from the list, and removes it from the list.
	 * @return
	 */
	public Card draw(){
		//Creates a random number and withdraws the card with that index.
		Random generator=new Random();
		return cards.remove(generator.nextInt(cards.size()));	//Remove the item that is being removed.
	}
	/**
	 * Returns the number of cards left.
	 * @return
	 */
	public int size(){
		return cards.size();
	}
}
