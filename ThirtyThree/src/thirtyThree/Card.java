/**
 * 
 */
package thirtyThree;

/**
 * @author Arthur Laks
 * CSIT 210 - Project 3
 * Overview: Represents a card, and stores its suit, rank, and numeric value.
 */
public class Card {
	public enum Suite{
		Clubs,Diamonds,Hearts,Spades
	}
	public enum Rank{
		King,Ace,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen
	}
	private Suite suite;
	private Rank rank;
	private int value;
	/**
	 * @param suite a Suite enum containing the suite of the card that should be created.
	 * @param rank a Rank enum containing the rank of the card that should be created.
	 */
	public Card(Suite suite, Rank rank) {
		this.suite = suite;
		this.rank = rank;
		//Set value to the value corresponding with the rank of the card.  For all of the ranks between 
		//1 and ten, the ordinal is the same as the value (with ace as one by default) and the other ones
		//(King, Jack, and Queen), the value is ten.
		if(rank.ordinal()>=1&&rank.ordinal()<=10)
			value=rank.ordinal();
		else{
			value=10;
		}
	}
	/**
	 * Returns the suit of the card.
	 * @return
	 */
	public Suite getSuite() {
		return suite;
	}
	/**
	 * Returns the rank of the card.
	 */
	public Rank getRank() {
		return rank;
	}
	/**
	 * Returns the numeric value of the card and 1 for ace.
	 */
	public int getValue() {
		return value;
	}
	/**
	 * Returns a string containing [rank] of [suite].
	 */
	@Override
	public String toString(){
		return String.format("%s of %s",rank,suite);
	}
	
}
