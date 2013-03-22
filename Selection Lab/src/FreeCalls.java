import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210 - Selection lab
 * Overview: inputs a number and tell the user if it is toll-free, based on the area code.
 * Input: A 10-digit number.
 * Output: Tells the user if the number is toll-free.
 * Variables: Scanner input; String fullNumber, areaCode, exchange, lastDigits;
 * Plan:
 * 1. Asks the user for a phone number.
 * 2. Divides the number into three parts (the area code, the exchange, and the last four digits) and stores each part in a different string.
 * 3. If the area code is 800, 855, 866, 877 or 888, tells the user that it is toll-free.
 * 4. If not, tell the user that it is not toll-free.
 * @version 1.0 2013.03.19
 */
public class FreeCalls {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a 10-digit phone number: ");
		String fullNumber=input.next();
		String areaCode=fullNumber.substring(0,3);
		String exchange=fullNumber.substring(3,6);	//The middle three digits.  Stores each component of the number in a separate string in order to make it easier to 
		//format properly.
		String lastDigits=fullNumber.substring(6);	//The last four digits. fullNumber.substring(6) returns everything after the sixth digit.
		if(areaCode.equals("800")||areaCode.equals("855")||areaCode.equals("866")||areaCode.equals("877")||areaCode.equals("888"))
			System.out.printf("(%s) %s-%s is a toll-free number.",areaCode,exchange,lastDigits);
		else
			System.out.printf("(%s) %s-%s is not a toll-free number.",areaCode,exchange,lastDigits);
		input.close();
	}

}
