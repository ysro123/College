import java.util.Random;

	/**
	 * 
	 * @author Arthur Laks
	 * CSIT 210 - Dice
	 * Overview: Stores the information about a die, generates random numbers for throws, and calculates the total of the numbers it 
rolled and the average of the numbers it rolled.  It is to be used by the Dice class for the dice assignment.
	*  Plan: 
	*  1. Dice class declares an instance of the Die class and passes a number of sides.
	*  2. When the Dice class calls roll(), picks a random number between 1 and the number of sides and adds that number to
total and increments timesRolled in order to keep track of the average number it landed on.
 	*  3. When the user calls average, calculates the average number it landed on by dividing total by timesRolled.
	 */
	public class Die{
		private Random generator=new Random();	//Generates the random numbers
		private int sides=0;	//Stores the number of sides (the maximum number that can be returned with each throw).
		private int timesRolled=0;	//Stores the number of times it was thrown.
		private int total=0;	//Stores the total of the numbers that roll returned
		/**
		 * Initializes a Die with the specified number of sides.
		 * @param sides the number of sides that the die should have
		 */
		public Die(int sides){
			this.sides=sides;
		}

		/**
		 * Generates a random number between 1 and sides.
		 * @return a random number between 1 and sides.
		 */
		public int roll(){
			int retVal= generator.nextInt(sides)+1;		
			total+=retVal;
			timesRolled++;
			return retVal;
		}
		/**
		 * Returns the total of the numbers that the die landed on.
		 * @return the total of the numbers that the die landed on.
		 */
		public int total(){
			return total;
		}
		/**
		 * Returns the average of the numbers that the die landed on.
		 * @return
		 */
		public double average(){
			return (double)total/timesRolled;
		}
	}