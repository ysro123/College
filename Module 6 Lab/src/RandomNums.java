/**
 * Arthur Laks
 * CSIT - Arrays Lab 1
 * Overview: Populates an array, populates it with random numbers (hardcoded), counts and displays 
 * the number of occurrences of 15, populates a new array of twice the number of elements of the 
 * first array with the content of the first array (repeating every value) and displays the 
 * of the new array. 
 * Input: none
 * Output: The number of occurrences of 15 in the old array and the content of the new array.
 * Variables randomnums, occ15 (stores the number of occurrences of 15 in the old array), cInt
 * (the counter for foreach loops), newArray, counter.
 * Plan:
 * 1. Declares an array of ints and populates it with numeric literals.
 * 2. For each element in the array, if it is 15 then increment a variable.
 * 3. Displays that variable.
 * 4. Declares a new array with twice the number of elements of the old array, and populates it with
 * the elements of the old array, so that each element in the new array will apear twice.
 * 5. Displays each element of the new array.
 * @version 1.0 2013-04-16
 */
public class RandomNums {
	public static void main(String[] args) {
		int[] randomnums={10,75,34,20,15,22,98,42,15,30,40,20};
		int occ15=0;
		for(int cInt:randomnums){
			if(cInt==15)
				++occ15;
		}
		System.out.printf("There were %d occurrences of 15 in the array.\n", occ15);
		int[] newArray=new int[randomnums.length*2];
		for(int counter=0;counter<newArray.length;counter++){
			newArray[counter]=randomnums[counter/2];
		}
		System.out.print("Here is the content of the new array: ");
		for(int cInt:newArray){
			System.out.print(cInt+"; ");
		}
	}
}