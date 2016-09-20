import java.util.Scanner;
/*
 * This program was written to test the MenuItem and Menu classes.
 * This program is a Driver program.
 *
 * @creator Tanner Boysun
 * @created 2016.09.18
 *
 * Credit to GDT for inspiration and original driver program.
 * this program was re-created from scratch to fit my style while
 * taking heavy inspiration from the original one created by GDT.
 *
 * When reading the code it should be noted that the intentions here
 * were not to make a working menu, but to test all the class methods
 * I just fancied some things up along the way.
 *
 */
public class MenuBuild{

	public static void main(String[] argv){

		final int ADD = 1,
		      DELETE = 2,
		      CHANGE = 3,
		      RESET = 4,
		      USERS = 5,
		      ADMIN = 6,
		      EXIT = 7;

		String MenuTITLE = "User Administration Menu";
		
		/* Create Menu Items */

		MenuItem addUser = new MenuItem(ADD, "Create a user");
		MenuItem delUser = new MenuItem(DELETE, "Delete a user");
		MenuItem changeUser = new MenuItem(CHANGE, "Change a user's settings");
		MenuItem resetUser = new MenuItem(RESET, "Reset user settings to default");
		MenuItem listUser = new MenuItem(USERS, "List current system users");
		MenuItem adminUser = new MenuItem(ADMIN, "Administrative functions");
		MenuItem exit = new MenuItem(EXIT, "Exit Menu");
		
		/* Default user doesn't have permissions to administrate */
		adminUser.setEnabled(false);

		/* Creation of a new menu to display all these menu items */

		Menu userOptions = new Menu(MenuTITLE);


		userOptions.add(addUser);
		userOptions.add(delUser);
		userOptions.add(changeUser);
		userOptions.add(resetUser);
		userOptions.add(listUser);
		userOptions.insert(1, adminUser);
		userOptions.add(exit);

		
		int knock;
		Scanner scan = new Scanner(System.in);

		/* I understand that most of this is fake and doesn't do anything
		 * I just made it for the spirit of the assignment with no intentions
		 * of making it work. */

		while ((knock = userOptions.activate(System.out)) != EXIT){
			switch(knock){

				case ADD:
					System.out.print("Please enter a username to add: ");
					String name = scan.nextLine();
					System.out.println("Added user " + name + " . . .");
					break;
				case DELETE:
					System.out.print("Please enter a username to delete: ");
					String delName = scan.nextLine();
					System.out.println("Deleted user " + delName + " . . .");
					break;
				case CHANGE:
					System.out.print("Please enter an account note: ");
					String note = scan.nextLine();
					System.out.println("Thanks for adding a note into the system!");
					break;
				case RESET:
					System.out.print("Please enter a username to reset: ");
					String reset = scan.nextLine();
					System.out.println("User successfully reset to default settings: " + reset);
					break;
				case USERS:
					System.out.println("Current users are: tannerboysun, administrator, webmaster");
					break;
				case ADMIN:
					System.out.println("Are you sure you want to clear everything?");
					String resp = scan.nextLine();
					System.out.println("Ok deleting everything");
					break;


			}
		}

		final int UNDERLINE = 1,
		      INSERT = 2,
		      ADD2 = 3,
		      CTITLE = 4,
		      REMOVE = 5, 
		      TOGGLE = 6, 
		      UTOGGLE = 7,
		      EXIT2 = 8;

		String TITLE2 = "This is the Driver Menu";
		MenuItem ChangeUL = new MenuItem(UNDERLINE, "Change the underline of the menu");
		MenuItem insertPos = new MenuItem(INSERT, "Insert a menu item to index 3");
		MenuItem addItem = new MenuItem(ADD2, "Adds a menu item to the end \"Appends\" ");
		MenuItem ChangeTitle = new MenuItem(CTITLE, "Changes the title of this menu");
		MenuItem Toggle = new MenuItem(TOGGLE, "Toggles accessibility of this item");
		MenuItem UToggle = new MenuItem(UTOGGLE, "Un-Toggles previous option");
		MenuItem added = new MenuItem(REMOVE, "REMOVE ME!");
		MenuItem Exit = new MenuItem(EXIT2, "Exit");

		Menu Driver = new Menu(TITLE2);

		Driver.add(ChangeUL);
		Driver.add(insertPos);
		Driver.add(addItem);
		Driver.add(ChangeTitle);
		Driver.add(Toggle);
		Driver.add(UToggle);
		Driver.add(Exit);

		int driverResp;

		while ((driverResp = Driver.activate(System.out)) != EXIT2){
			switch (driverResp){


				case UNDERLINE:
					char cur = Driver.getUnderlineChar();

					if (cur == Menu.DFLT_UNDERLINE_CHAR){
						Driver.setUnderlineChar('@');
						System.out.println("Successfully Changed Underline Character");
					} else {
						Driver.setUnderlineChar(Menu.DFLT_UNDERLINE_CHAR);
						System.out.println("Reverted Underline Character to Default");
					}
					
					break;

				case INSERT:
					Driver.insert(3, added);
					System.out.println("Successfully added MenuItem at index 3");
					break;

				case ADD2:
					Driver.add(added);
					System.out.println("Successfully appended MenuItem");
					break;
				case CTITLE:
					if (Driver.getTitle().equals(TITLE2)){
						Driver.setTitle("Holy Moly this is Significantly Different!");
					} else {
						Driver.setTitle(TITLE2);
					}
					System.out.println("Successfully changed the title");
					break;
				case TOGGLE:
					Toggle.setEnabled(false);
					System.out.println("Changed toggle status of Toggle Menu Item");
					break;
				case UTOGGLE:
					Toggle.setEnabled(true);
					System.out.println("Untoggled the toggled item");
					break;
				case REMOVE:
					Driver.remove(added);
					System.out.println("Removed 1 random instance of Added object"); /* All I needed to do here is test the remove method I understand it removes a random instance*/
					break;



			}
		}

	}
}


