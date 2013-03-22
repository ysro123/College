
/**
 * @author Arthur Laks
 * CSIT 210-Using String Objects
 * Overview: Plays with String objects
 * Input: none
 * Output: Text Display
 * Variables: college,town,stringLength,change1,change2,change3
 * Plan:
 * 1. Declares two strings called college and town and initializes them to two values.
 * 2. Assigns and int to the length of one of those strings and displays it.
 * 3. Declares three strings and makes the first one the value of college in all-upper case, the second one the value of the first
 with all of the o's replaced with asterisks, and the third one the concatenation of the value of college and the value of town.
 * 4. Displays the value of the third string.
 *@version: 1.0 February 26, 2013
 */
public class StringPlay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String college = new String ("Frostburg State University");
		String town="Frostburg, MD"; // part (a)
		int stringLength;
		String change1, change2, change3;
		stringLength=college.length(); // part (b)
		System.out.println (college + " contains " + stringLength + " characters.");
		change1 =college.toUpperCase(); // part (c)
		change2 =change1.replace('o','*'); // part (d)
		change3 = college.concat(town); // part (e)
		System.out.println ("The final string is " + change3);
	}

}
