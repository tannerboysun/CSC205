/*
 * This class is the structure for making menus that display in a user 
 * specified PrintStream
 *
 * @creator Tanner Boysun
 * @created 2016.09.18
 *
 * P.S. Sorry for styling, it's habit.
 */
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.Scanner;

public class Menu{

	private String title;
	public static char DFLT_UNDERLINE_CHAR = '=';
	private char underlineChar = '=';
	private ArrayList<MenuItem> items = new ArrayList<MenuItem>(); /* Only allows MenuItem objects in ArrayList*/

	public Menu(String Title){
		this.title = Title;
	}
	/* ---------------- */
	/* Accessor Methods */
	/* ---------------- */

	public String getTitle(){
		return this.title;
	}

	public char getUnderlineChar(){
		return this.underlineChar;
	}

	/*public int getId(){
		return this.id
	}*/

	/* --------------- */
	/* Mutator Methods */
	/* --------------- */

	public void add(MenuItem menuItem){
		this.items.add(menuItem);
	}

	public void insert(int pos, MenuItem menuItem){
		this.items.add((pos-1), menuItem); /* Pos - 1 because indexing at 0 */
	}

	public void remove(MenuItem menuItem){
		this.items.remove(menuItem);
	}

	public void returnArray(){
		System.out.println(items);
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setUnderlineChar(char underlineChar){
		this.underlineChar = underlineChar;
	}

	/* ------------ */
	/* Menu Methods */
	/* ------------ */

	public void display(PrintStream out){
		String underline = "";
		int charLength = this.title.length();
		int count = 0;

		for (int i = 0; i < charLength; i++){
			underline += Character.toString(underlineChar);
			/* Tried looking up StringBuffer, wasn't able to get it working */
		}

		out.println(this.title);
		out.println(underline);
		
		for (int recurse = 0; recurse < items.size(); recurse++){

			/* Variable Collection */
			MenuItem cur_MenuItem = items.get(recurse);
			boolean itemEnabled = cur_MenuItem.getEnabled();
			String cur_MenuItemLabel = cur_MenuItem.getLabel();
			String prefix = "";

			/* Set appropriate values */

			if (!itemEnabled) {
				prefix = "*)";
				cur_MenuItem.setChoice(0);
			} else {
				count++;
				cur_MenuItem.setChoice(count);
				prefix = cur_MenuItem.getChoice() + ")";
				//System.out.println("Incremented count");

			}

			out.println(prefix + " " + cur_MenuItemLabel);
			



		}
	}

	public int activate(PrintStream out){

		int result = 0;
		Scanner input = new Scanner(System.in);
		boolean found = false;

		do{
			this.display(out);
			out.print("\nChoice: ");
			int response = input.nextInt();
			for (int check = 0; check < this.items.size(); check++){
				MenuItem cur_MenuItem = items.get(check);
				int temp_choice = cur_MenuItem.getChoice();

				if (temp_choice == response) {
					found = true;
					result = cur_MenuItem.getId();
				}
			}

			if (found == false){
				out.println("Please enter a valid choice . . . \n");
			}

		} while (found == false);
		return result;
	}
}
