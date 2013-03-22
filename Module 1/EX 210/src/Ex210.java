/**
 * 
 */

/**
 * @author Arthur Laks
 * CSIT 210-Data and Expressions lab
 * Overview: Displays the results of assignments
 * Input: none
 * Output: Text display
 * Variables: iResult,num1,num2,num3,num4,fResult,val1,val2
 * Plan:
 * 1. User runs the program.
 * 2. Runs the various statements in EX 2.10
 * 3. After each expression, displays the results.
 * @version: 1.0 February 17, 2013
 */
public class Ex210 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int iResult,num1=25,num2=40,num3=17,num4=5;
		double fResult,val1=17.0,val2=12.78;
		
		//a.
		iResult=num1/num4;
		System.out.printf("num1/num4 stored as an integer equals %d.\n",iResult);
		
		//b.
		fResult=num1/num4;
		System.out.printf("num1/num4 stored as a double equals %f.\n",fResult);
		
		//c.
		iResult=num3/num4;
		System.out.printf("num3/num4 stored as an integer equals %d.\n", iResult);
		
		//d.
		fResult=num3/num4;
		System.out.printf("num3/num4 stored as a double equals %f.\n", fResult);
		
		//e.
		fResult=val1/num4;
		System.out.printf("val1/num4 stored as a double equals %f.\n", fResult);
		
		//f.
		fResult=val1/val2;
		System.out.printf("val1/val2 equals %f.\n", fResult);
		
		//g.
		iResult=num1/num2;
		System.out.printf("num1/num2 stored as an integer equals %d.\n", iResult);
		
		//h.
		fResult=(double)num1/num2;
		System.out.printf("num1/num2 when num1 is cast to a double equals %f.\n", fResult);
		
		//i.
		fResult=num1/(double)num2;
		System.out.printf("num1/num2 when num2 is cast to a double equals %f.\n", fResult);
		
		//j.
		fResult=(double)(num1/num2);
		System.out.printf("num1/num2 equals %f when the result is cast to a double.\n",fResult);
		
		//k.
		iResult=(int)(val1/num4);
		System.out.printf("val1/num4 equals %d when the result is cast to and stored as an integer.\n", iResult);
		
		//l.
		fResult=(int)(val1/num4);
		System.out.printf("val1/num4 equals %f when the result is cast to an integer and stored as a double.\n",fResult);
	
		//m.
		fResult=(int)((double)num1/num2);
		System.out.printf("num1/num2 equals %f when num1 is cast to a double and the result is cast to an integer and stored "
		+"as a double.\n", fResult);
		
		//n.
		iResult=num3%num4;
		System.out.println("num3%num4 equals "+iResult+".");
		
		//o.
		iResult=num2%num3;
		System.out.println("num2%num3 equals "+ iResult+".");
		
		//p.
		iResult=num3%num2;
		System.out.println("num3%num2 equals "+iResult+".");
		
		//q.
		iResult=num2%num4;
		System.out.println("num2%num4 equals "+iResult+".");
	}

}
