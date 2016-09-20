import java.util.*;
import java.io.*;

/*
 * This program was written to test class Menu and class MenuItem.
 * Note: The code for these two classes is not provided.
 *
 * @creator gdt
 * @created 02014.09.25
 */
public class TestMenuMenuItem {

	public static void main(String[] argv) {
		final int ADD = 1, DELETE = 2, UPDATE = 3, CHANGE = 4,
		      DU = 5, DF = 6, UNUSED = 7, EXIT = 8;
		String TITLE = "System Administration Menu";

		MenuItem addUser = new MenuItem(ADD, "Add User");
		MenuItem delUser = new MenuItem(DELETE, "Delete User");
		MenuItem updUser = new MenuItem(UPDATE, "Update User");
		MenuItem chgUser = new MenuItem(CHANGE, "Change User");
		MenuItem diskUsage = new MenuItem(DU, "Disk Usage");
		MenuItem diskFree = new MenuItem(DF, "Disk Free");
		MenuItem unused = new MenuItem(UNUSED, "Testing Only");
		MenuItem exit = new MenuItem(EXIT, "Exit");

		unused.setEnabled(false);

		Menu sysAdmin = new Menu(TITLE);
		sysAdmin.add(addUser);
		sysAdmin.add(delUser);
		sysAdmin.add(updUser);
		sysAdmin.add(chgUser);
		//sysAdmin.addSeparator();
		sysAdmin.add(diskUsage);
		sysAdmin.add(diskFree);
		sysAdmin.add(unused);
		//sysAdmin.addSeparator();
		sysAdmin.add(exit);

		int option;
		while ((option = sysAdmin.activate(System.out)) != EXIT) {
			switch (option) {
				case ADD:
					System.out.println("... adding user");
					break;
				case DELETE:
					System.out.println("... deleting user");
					break;
				case UPDATE:
					System.out.println("... updating user");
					break;
				case CHANGE:
					System.out.println("... changing user");
					break;
				case DU:
					System.out.println("... calculating disk usage");
					break;
				case DF:
					System.out.println("... calculating disk free");
					break;
				case UNUSED:
					System.err.println("... what's this?");
					break;
			}
		}

		final int CHANGE_ULINECHAR = 1, CHANGE_ENABLED = 2,
		      CHANGE_TITLE = 3, REMOVE_ITEM = 4, 
		      INSERT_ITEM = 5, ADD_ITEM = 6, DONE = 7;

		TITLE = "Test Menu Changes";

		MenuItem chgULineChar = 
			new MenuItem(CHANGE_ULINECHAR, "Change Underline Character");
		MenuItem chgEnabled = 
			new MenuItem(CHANGE_ENABLED, "Change \"Change Title\" Enabled Flag");
		MenuItem chgTitle = 
			new MenuItem(CHANGE_TITLE, "Change Title");
		MenuItem rmItem = 
			new MenuItem(REMOVE_ITEM, "Remove This Menu Item");
		MenuItem insItem = 
			new MenuItem(INSERT_ITEM, "Insert \"Remove\" Menu Item");
		MenuItem addItem = 
			new MenuItem(ADD_ITEM, "Add This Menu Item");
		MenuItem done = new MenuItem(DONE, "Done");

		Menu test = new Menu(TITLE);
		test.add(chgULineChar);
		test.add(chgEnabled);
		test.add(chgTitle);
		//test.addSeparator();
		test.add(rmItem);
		test.add(insItem);
		test.add(addItem);
		//test.addSeparator();
		test.add(done);

		boolean didAnAdd = false;
		while ((option = test.activate(System.out)) != DONE) {
			switch (option) {
				case CHANGE_ULINECHAR:
					char ch = test.getUnderlineChar();
					if (ch == Menu.DFLT_UNDERLINE_CHAR)
						test.setUnderlineChar('*');
					else
						test.setUnderlineChar(Menu.DFLT_UNDERLINE_CHAR);
					break;
				case CHANGE_ENABLED:
					chgTitle.setEnabled(!chgTitle.getEnabled());
					break;
				case CHANGE_TITLE:
					if (test.getTitle().equals(TITLE))
						test.setTitle("Look At This New Title");
					else
						test.setTitle(TITLE);
					break;
				case REMOVE_ITEM:
					test.remove(rmItem);
					break;
				case INSERT_ITEM:
					test.insert(REMOVE_ITEM-1, rmItem);
					break;
				case ADD_ITEM:
					if (!didAnAdd) {
						test.add(addItem);
						didAnAdd = true;
					}
					break;
			}
		}
	}
}
