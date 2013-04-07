import java.util.Vector;
/**
 * @author Arthur Laks
 * CSIT 210 - Repetition Lab
 * Overview: Finds two perfect numbers.
 * Input: none
 * Output: Displays the two perfect numbers that it found.
 * Variables: ArrayList<Integer> numberFound; int toTest, sumFactors, potentialFactors;
 * Plan:
 * 1. For each number after 29, goes through all of the numbers below it, and if they go into that number, counts it as a factor of that number.
 * 2. If the sum of the factors of that number equal that number then add it to the list of numbers found.
 * 3. Keeps on going until it finds two perfect numbers.
 * 4. Displays the numbers that it found.
 */
public class JustPerfects:extends Thread {
	private int beginRange, endRange;
	private static ArrayList<Integer> numbersFound=new ArrayList<>();

	public JustPerfects(int beginRange,int endRange){
		this.beginRange=beginRange;
		this.endRange=endRange;
	}
	private void run(){
		
	}
	public static void main(String[] args) {
	

		for(int toTest=29;numbersFound.size()<2;toTest++){	//For each number after 28 until it finds two perfect numbers
			int sumFactors=0;	//The sum of the factors of toTest
			for(int potentialFactor=1;potentialFactor<(toTest-1);potentialFactor++){	//For each number until the number before toTest (toTest itself is a factor, but
				//it should not be counted, or else there would be no perfect numbers).
				if(toTest%potentialFactor==0)	//If that number is a factor of toTest
					sumFactors+=potentialFactor;
			}
			if(toTest==sumFactors)		//If toTest is a perfect number
				numbersFound.add(toTest);
		}
		System.out.printf("The next two perfect numbers are %d and %d.", numbersFound.get(0),numbersFound.get(1));
	}

}
