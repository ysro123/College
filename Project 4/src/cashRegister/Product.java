/**
 * 
 */
package cashRegister;

/**
 * @author Aryeh
 *
 */
public enum Product {
	CHILD{
		@Override
		public double price(){
			return 0.90;
		}
		@Override
		public String toString(){
			return "Child";
		}
	}
	,MEDIUM{
		@Override
		public double price(){
			return 1.40;
		}
		@Override
		public String toString(){
			return "Medium";
		}
	}
	,LARGE{
		@Override
		public double price(){
			return 1.75;
		}
		@Override
		public String toString(){
			return "Large";
		}
	}
	,EXTRA_LARGE{
		@Override
		public double price(){
			return 2;
		}
		@Override
		public String toString(){
			return "Extra Large";
		}
	}

	;public abstract double price();
}
