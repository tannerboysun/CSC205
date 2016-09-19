
import java.util.ArrayList;
import java.io.PrintStream;

public class Menu{

	private String title;
	private char underlineChar = '=';
	private ArrayList<MenuItem> items = new ArrayList<MenuItem>(); /* Only allows MenuItem objects in ArrayList*/

	public Menu(String Title){
		this.title = Title;
	}

	/* Accessor Methods */
	/* ---------------- */

	public String getTitle(){
		return this.title;
	}

	public char GetUnderlineChar(){
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
		this.items.add(pos, menuItem);
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
			cur_MenuItem.setChoice(recurse + 1);

			if (!itemEnabled) {
				prefix = "*)";
			} else {
				prefix = cur_MenuItem.getChoice() + ")";
			}

			out.println(prefix + " " + cur_MenuItemLabel);
			



		}
	}
}