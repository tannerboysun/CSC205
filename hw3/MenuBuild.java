public class MenuBuild{

	public static void main(String[] argv){


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


		Menu defaultmenu = new Menu(TITLE);
		defaultmenu.add(addUser);
		defaultmenu.add(delUser);
		defaultmenu.add(updUser);
		defaultmenu.add(chgUser);
		defaultmenu.add(diskUsage);
		defaultmenu.add(diskFree);
		defaultmenu.add(unused);
		defaultmenu.add(exit);
		unused.setEnabled(false);
		defaultmenu.display(System.out);


	}
}

