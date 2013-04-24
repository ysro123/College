import java.util.Scanner;
/**
 * Author: Arthur Laks
 * CSIT 210 - Arrays Lab Part 2.
 * Overview: Calculates the sum of a matrix.
 * Input: Asks the user for the size and contents of the matrix.
 * Output: Displays the sum of each row and the total sum of the matrix.
 * Variables: input, rows (the number of rows in the matrix), columns, matrix, row (the row the loop is up
 to), column, sum.
 * Plan:
 * 1. Asks the user for the size of the matrix.
 * 2. Declares a 2-dimensional array of that size, with the first index for row and the second index for 
 columns.
 * 3. For each row, asks the user to enter the content of each column in that row.
 * 4. Uses the sum method to calculate the sum of the content of each row, and displays it.
 * 5. Uses the sum method to calculuate the total sum of all of the numbers in the matrix and displays that.
 * @version 1.0 2013-04-23
 */
public class ArraySum {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	System.out.println("What dimensions should the matrix be?");
	System.out.print("\t rows? ");
	int rows=input.nextInt();
	System.out.print("\t columns? ");
	int columns=input.nextInt();
	int[][] matrix=new int[rows][columns];
	for(int row=0;row<matrix.length;++row){
		System.out.printf("Please enter the contents of row %d?\n",row+1);
		for(int column=0;column<matrix[row].length;column++){
			System.out.printf("Column %d - ",column+1);
			matrix[row][column]=input.nextInt();
		}
	}
	for(int row=0;row<matrix.length;row++){
		int sum=sum(matrix[row]);
		System.out.printf("The sum of row %d is - %d.\n",row+1,sum);
	}
	int sum=sum(matrix);
	System.out.printf("Your total for the %d by %d matrix is %d.",rows,columns,sum);
	input.close();
	}
	/**
	 * Calculates the sum of the elements of one or more arrays of integers.
	 * @param array one or more arrays or a multi-dimensional array
	 * @return returns the sum of the elements in the array.
	 */
	private static int sum(int[]... array){	//A single array of a 2-dimensional array can be passed as a 
		//variable-length parameter.
		int sum=0;
		for(int[] row:array)	//For each row
			for(int element:row)	//For each element in that row.
				sum+=element;
		return sum;
	}
}
