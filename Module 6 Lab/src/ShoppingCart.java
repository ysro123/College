
public class ShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] price=new double[]{3.43,2.34,3.35};
		int[] qty=new int[]{4,32,9};
		double[] amt=fillAmounts(qty,price);
		
	}
	private static double[] fillAmounts(int[] quantity,double[] price){
		double[] retval=new double[quantity.length];
		for(int counter=0;counter<quantity.length;counter++){
			retval[counter]=quantity[counter]*price[counter];
		}
		return retval;
	}
}
