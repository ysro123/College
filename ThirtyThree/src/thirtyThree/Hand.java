/**
 * 
 */
package thirtyThree;
import java.util.LinkedList;
import java.util.List;

import thirtyThree.Card.Rank;
/**
 * Author: Arthur Laks
 * CSIT 210 - Project 3
 * Overview: Represents the player's or dealer's hand, keeping track of his card's and calculating its total
 value.
 * Description: Maintains a private list to store the cards that the driver class added to the hand.  
 * Methods:
  -addCard(Card toAdd) - adds a card to the hand.  
  -getValue-adds up the values of  the cards in the list and counts Ace as one or eleven, depending on 
  whether it brings value to above 33.
 -  toString() - returns a list of the cards in the hand and the value.
 * Variable: cards
 * @version 1.0 2013-04-13
 */
public class Hand {
	private List<Card> cards=new LinkedList<>();
	public void addCard(Card card){
		cards.add(card);
	}
	public int value(){
		int retVal=0;
		int aces=0;
		//For each card, add to retVal the value of that card.
		for(Card cCard:cards){
			if(cCard.getRank()==Rank.Ace)	//Keep track of the number of aces by incrementing aces if cCard
				//is an ace.
				++aces;
			retVal+=cCard.getValue();	//Whether or not the card is an ace, add its value to retVal.  If the
			//card is an ace, its value is one, and another ten will be added to retVal if that does not bring
			//it above 33
		}
		//For each ace, if adding 10 to retVal will not bring it above 33, add ten to retVal.
		for(int counter=0;counter<aces;counter++){
			if(retVal+10<33)
				retVal+=10;
		}
		return retVal;
	}
	/**
	 * Returns a String with a list of the cards in the hand, with each card's rank and suite, followed 
by the total value.
	 */
	@Override
	public String toString(){
		StringBuilder retVal=new StringBuilder();
		//For each card in the hand, append the card's description (as obtained from Card.toString()) to 
		//retVal and a comma so that the descriptions of the cards will be seperated by commas, and remove the
		//last comma.
		for(Card cCard:cards){
			retVal.append(cCard.toString());
			retVal.append(", ");
		}
		retVal.deleteCharAt(retVal.length()-2);	//Remove the last comma.
		//After the list, it should say the total value in parentheses.
		retVal.append(String.format("(Total %d)",value()));
		return retVal.toString();
	}
}
