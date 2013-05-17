import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * Author: Arthur Laks
 * CSIT 210 - Exceptions Lab
 * Overview: Reads a file with student records and displays the names of the students whose gpas are less
 * than 2.
 * Input: If the file that the program chooses by default does not exist, asks the user to enter the path of
 the file with the academic records until he enters the path of a file that exists.  Similarly, if the data
 in the file is invalid or result in division by zero, asks the user to enter new data instead.
 * Output: Displays the names of the students on academic warning.
 * Variables: input, creditHrs, qualityPts, gpa, name
 * Plan: 
 * 1. Opens the file at c:\students.dat
 * 2. If the file doesn't exist, asks the user to enter another path.  Repeats from step 1 on with the new
 path.
 * 3. For each line in the file, parses the first word as the name of the student, the second sequence 
 * characters  (separated by spaces) as the number of credit hours, and the third as the number of quality
 points.  
 * 4. If the second or third sequences of characters are not numbers, asks the user to enter other values
 instead.
 * 5. Divides the quality-points by the credit-hours in order to calculate the grade-point average of the
 student.  If the credit-hours is zero, asks the user to enter another value instead.
 * 6. If the grade-point average is less than two, displays the name of the student.
 * 7. Repeats the process for every line in the file.
 * @version 1.0 2013-04-29
 */
public class Warning {
	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		int creditHrs; // number of semester hours earned
		double qualityPts; // number of quality points earned
		double gpa; // grade point (quality point) average
		String name;
		
		// Set up scanner to input file
		Scanner inFile=null;	//inFile starts out as a null reference in order to make it easier to keep 
		//track of whether or not it ended up being initialized to a valid file.
		String path="c:\\students.dat";
		//Keeps asking the user to enter another path until he enters the path of an existing file.
		while(inFile==null){	//While inFile does not point to a valid file.
			try{
				inFile = new Scanner(new File(path));
			} catch (FileNotFoundException e) {
				System.out.printf("%s is not a valid path.  Please enter the path of the file with the " +
						"academic records: ",path);
				path=input.nextLine();
			}
		}
		System.out.println("\n Students on Academic Warning\n");
		// Process the input file, one token at a time
		while (inFile.hasNext()) {
			// Get the credit hours and quality points and
			// determine if the student is on warning. If so,
			// display the student's name.
			name = inFile.next();
			try {
				creditHrs = Integer.parseInt(inFile.next());
				qualityPts = Double.parseDouble(inFile.next());
			} catch (NumberFormatException e) {
				System.err.printf("Invalid data found in file under the student %s.  Please enter your own " +
						"data instead.\n",name);
				System.out.print("Please enter the credit hours: ");
				creditHrs=input.nextInt();
				System.out.print("Please enter the quality points: ");
				qualityPts=input.nextDouble();
			}
			// Insert gpa calculation
			// and statement to determine if the student name is listed.
			try{
			gpa=(int)(qualityPts)/creditHrs;	//Cast qualityPts to int so that it would be integer division
			//instead of floating-point division and would result in an exception if creditHrs is zero 
			//instead of Double.Infinity
			}catch(ArithmeticException e){	//If creditHrs is zero
				System.out.print("A division-by-zero error resulted from credit hours being set to zero. " +
						"Please enter a non-zero value for credit hours: ");
				creditHrs=input.nextInt();
				gpa=qualityPts/creditHrs;
			}
			if(gpa<2)
				System.out.println(name);
		}
		inFile.close();
		input.close();
	}
}