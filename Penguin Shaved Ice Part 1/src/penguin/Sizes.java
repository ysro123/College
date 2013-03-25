package penguin;
/**
 * @author Arthur Laks
 * CSIT 210 - Project 1
 * Overview: Contains the sizes that the franchise is selling.
 * Input: none
 * Output: none
 * Variables: none
 * Plan: none
 * @version: 1.0 3/5/13
 */
public enum Sizes{
	
	Child,
	Medium,
	Large,
	ExtraLarge{
		/**
		 * Returns "Extra Large" with a space instead of an underscore, because that is the way it should be displayed.
		 */
		public String toString(){
			return "Extra Large";
		}
	},

}