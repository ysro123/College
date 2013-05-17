
package cashRegister;

/**
 * Author: Arthur Laks
 * CSIT 210 - Project 4
 * Overview: Represents a coin (dollar, quarter, dime, nickel, or penny) and stores its value (eg. 5 for 
 a nickel).
 * @
 */
public enum Coin {
	TWENTY{
		@Override
		public int value(){
			return 2000;
		}
	},
	TEN{
		@Override
		public int value(){
			return 1000;
		}
	},
    FIVE{
    	@Override
    	public int value(){
    		return 500;
    	}
    },
    DOLLAR{
    @Override
       public int value(){
            return 100;
        }
    },
    QUARTER {
        @Override
        public int value() {
            return 25;
        }
    },
    DIME{
        @Override
        public int value(){
            return 10;
        }
    },
    NICKEL{
        @Override
        public int value(){
            return 5;
        }
    },
    PENNY{
        @Override
        public int value(){
            return 1;
        }
    }
;
    public abstract int value();
}
