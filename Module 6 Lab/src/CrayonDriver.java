import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
/**
 * @author Arthur Laks
 * CSIT 210 - Arrays Lab Part 2.
 * Overview: Creates a collection of crayons and allows the user to pick one randomly or to choose one from a 
 menu and removes that crayon from the list until the list is empty or the user types "end".
 * Input: Asks the user to choose whether to pick the crayon randomly or to choose one from the menu.
 * Output: Displays the information about crayons that the user picks randomly and displays a menu of the 
 remaining crayons.
 * Variables: input, generator, crayons, counter, toCreate, index (a random number containing the index of 
 the crayon to select), choice (the crayon that the user choose), selected (the index of the crayon that 
 the user selected from the menu).
 * Plan:
 * 1. Create a linked list of 8 crayons and populate them with crayons with different colors, length, and 
 degrees of sharpness.
 * 2. Ask the user whether he wants to select a random crayon, to select a crayon from the menu, or quit.
 * 3. If the user chooses to select a random crayon, generates a random number, removes the crayon with that 
 index from the list, and displays the information about that crayon.
 * 4. If the user chooses to select a crayon from a menu, displays the properties of all of the crayons and
 asks the user to enter the index of the crayon that he wants to select. Removes the crayon of that index
 from the list.
 * 5. Repeats the process until the user types end or runs out of crayons.
 * @version 1.0 2013-04-23
 */
public class CrayonDriver {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random generator=new Random();
		//I use a LinkedList instead of an array because it is easier to remove values from a LinkedList.
		LinkedList<Crayon> crayons=new LinkedList<>();
		for(int counter=0;counter<8;counter++){
			Crayon toCreate=new Crayon(Color.values()[counter],(counter+1)*2,(counter)%5+1);
			crayons.add(toCreate);
		}
		while (crayons.size()>0) {	//While the user did not run out of crayons.
			System.out.print("Do you want to select a random crayon, do you want to choose one from a menu, or "
							+ "do you want to quit? (Type \"Random\" to choose a random crayon, type \"Select\""
							+ " to choose one from a menu, or \"End\" to quit.)");
			switch (input.next().toLowerCase()) {	//Check the user's choice case-insensitively. 
			//Java 1.7 supports switch statements on Strings.
			case "random":
				int index = generator.nextInt(8);
				Crayon choice = crayons.remove(index);	//Remove  the crayon from the list so that it would
				//not be selected twice. (List.remove returns the item that is removed).
				System.out.println("A random crayon was selected. Here is the information about the crayon:");
				System.out.print(choice.toString());
				System.out.println();
				break;
			case "select":
				System.out.println("Here is a menu of all of the crayons that are currently available:");
				for (int counter = 0; counter < crayons.size(); counter++) {
					//For the user, the index should be one-based.
					System.out.printf("Crayon #%d: %s\n", counter + 1,crayons.get(counter));
				}
				System.out.print("Enter the number of the crayon that you want.");
				int selected = input.nextInt()-1;	//The user is expected to enter a 1-based index.
				crayons.remove(selected);
				break;
			case "end":
				return;
			default:
				System.out.println("You have entered invalid input.");
				continue;
			}
		}
		System.out.print("You have ran out of crayons.");
	}

}
