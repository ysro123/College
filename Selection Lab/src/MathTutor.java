import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210 - Selection Lab.
 * Overview: Asks the user for two numbers and the operation that he wants to be done two them and performs that operation.
 * Input: Asks the user for two numbers and a symbol representing the operation that he wants to be done.
 * Output: The result of that operation.
 * Variables: Scanner input; double operand1, operand2; String operation;
 * Plan:
 * 1. Asks the user which operation he wants to perform and on which two numbers he wants to perform them.
 * 2. If he chose to add them, adds the numbers and outputs the sum.
 * 3. If he chose to subtract them, subtracts one from the other and outputs the difference.
 * 4. If he chose to multiply them, multiplies the numbers and prints the product.
 * 5. If he chose to divide them, divides one by the other and prints the quotient.
 * 6. If he chose a symbol besides '+', '-', '*', or '/', gives an error that he choose an invalid operation.
 * @version: 1.0 2013/3/19
 */
public class MathTutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double operand1,operand2;	//Stores the numbers that the user inputs.
		String operation;
		System.out.print("Which operation do you want to perform (enter '+' for addition, '*' for multiplication, etc.)? ");
		operation=input.nextLine();
		System.out.print("Enter the first number that you want to perform the operation on: ");
		operand1=input.nextInt();
		System.out.print("Enter the second number that you want to perform the operation on: ");
		operand2=input.nextInt();

		switch(operation){
		case "+":
			System.out.printf("The sum of %f and %f is %f. ",operand1,operand2,operand1+operand2);
			break;
		case "-":
			System.out.printf("The difference between %f and %f is %f.",operand1, operand2,operand1-operand2);
			break;
		case "*":
			System.out.printf("The product of %f and %f is %f.",operand1,operand2,operand1*operand2);
			break;
		case "/":
			System.out.printf("The quotient of %f and %f is %f.",operand1,operand2,operand1/operand2);
			break;
		default:	//If the user typed something besides a valid operator
			System.out.print("That was not a valid operator");
		}
		input.close();
	}
}
