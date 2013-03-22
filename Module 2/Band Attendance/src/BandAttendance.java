//Arthur Laks
import java.util.Random;
/**
 * Overview: Displays the levels of attendance of five bands.
 * Input: None
 * Output: Text Display
 * Variables: attendance[][], random[], counter (multiple times), bandNames[],retVal.
 * Plan: 
 * 1. User runs the program.
 * 2. Fills a multidimensional-array with random numbers for the level of attendance for each band and the total and an array 
 * of strings with the name of the bands.
 * 3. Populates an array with the column headers (the word "Name" and the names of the venues and "Total").
 * 4. Displays the border on top.
 * 5. Loops through the array of bands and displays them.  In a nested loop, it goes through each venue and displays the level
 * of attendence at each venue.
 *  
 * @author Arthur Laks
 * @version 1.0 February 14, 2013
 */
public class BandAttendance {
	private static final int COLUMN_LENGTH = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] attendance = new int[5][3];		//A multidimensional-array with the rows representing the 
		//bands and the columns the level of attendance.
		Random random= new Random();
		for(int counter=0;counter<=4;counter++){	//For every band
			attendance[counter][0]=Math.abs(random.nextInt()/200);	//Set the attendance of the first and second venues to a random
			//number.  It uses the absolute value of the number so that it would not be negative. (Most bands do not have negative
			//attendance.)  It divides it by 200 to make sure that the attendance would not be unreasonably high.
			attendance[counter][1]=Math.abs(random.nextInt()/200);
			attendance[counter][2]=attendance[counter][0]+attendance[counter][1];	//Makes the third column the total attendance.
		}
		String bandNames[]=new String[]{"Ants","Mosquitoes","Stinkbugs","Locusts","Cockroaches"};		//The names of
		//the bands.  (I followed the example of the Beatles in naming them after insects).
		
		String[] columnHeaders=new String[]{"Name","New York","Los Vegas","Total"}; //The names of the venues.
		//Storing them as an array makes it easier to print the right number of underscores under them.
		//Prints the border on top.
		//Prints enough slashes to fill four columns, the first two as front-slashes and the last two as back-slashes
		System.out.println(repeatSequence("/",COLUMN_LENGTH*2)+repeatSequence("\\",COLUMN_LENGTH*2));	
		System.out.println("|-\t\t\tBand Attendance"+"\t\t\t-|");
		System.out.println(repeatSequence("\\",COLUMN_LENGTH*2)+repeatSequence("/",COLUMN_LENGTH*2));
		System.out.println();
		//Print the column headers
		for(String thisColumn:columnHeaders){
			System.out.print(completeColumn(thisColumn));
		}
		System.out.println();
		for(String thisColumn:columnHeaders)	//For each column header, prints the right number of underscores.
			System.out.print(completeColumn(repeatSequence("_",thisColumn.length())));
		System.out.println();
		//Print the names of the bands and the levels of attendance.
		for(int outerCounter=0;outerCounter<=4;outerCounter++){		//For each band
			System.out.print(completeColumn(bandNames[outerCounter]+":"));	//Prints the band name in the first column
			for(int innerCounter=0;innerCounter<=2;innerCounter++)	//In the next two columns, prints the level of attendance
				System.out.print(completeColumn(String.format("%,d",attendance[outerCounter][innerCounter])));
			System.out.println();
		}
	}
	/**
	 * Returns a string containing the specified string repeated the specified number of times.
	 * @param sequence The characters to repeat.
	 * @param repetitions The number of times those characters should be repeated.
	 * @return A new string consisting of sequence repeated the specified number of times.
	 */
	private static String repeatSequence(String sequence,int repetitions){
		StringBuilder retVal = new StringBuilder();
		for(int counter=0;counter<=repetitions;counter++){	//Appends sequence to the return value a certain number of times.
			retVal.append(sequence);
		}
		
		return retVal.toString();
	}
	/**
	 * Completes the specified string with spaces until it is as long as the constant COLUMN-LENGTH.
	 * @param text The text to complete
	 * @return The string text, with spaces appended to it until it has the length of the COLUMN_LENGTH.
	 */
	private static String completeColumn(String text){
		return text + repeatSequence(" ",COLUMN_LENGTH- text.length());
	}
}
