public class MenuSystem {
		public void displayMainMenu() {
		System.out.println();
		System.out.println("-------- WELCOME TO YOUR ADDRESS BOOK --------");

		System.out.println("-         1. Add a contact                   -");
		System.out.println("-         2. Delete a contact                -");
		System.out.println("-         3. Update a contact                -");
		System.out.println("-         4. Display number of contacts      -");
		System.out.println("-         5. Search for a contact            -");
		System.out.println("-         6. Quit application                -");
		System.out.println("----------------------------------------------");
		System.out.println();
	}

	public void displayAddContactMenu() {
		System.out.println();
		System.out.println("***** ADD CONTACT MENU *****");
		System.out
				.println("Please enter contact information.");
	}

	public void displayDeleteContactMenu() {
		System.out.println();
		System.out.println("***** DELETE CONTACT MENU *****");
		System.out
				.println("Are you sure you wanted to delete the currently displayed contact? (Y/[N]");
	}

	public void displayUpdateContactMenu() {
		System.out.println();
		System.out.println("***** UPDATE CONTACT MENU *****");
		System.out
				.print("Enter a field name and field value separated by a comma:");
	}

	public void displayNumberOfContactsMenu() {
		System.out.println();
		System.out.println("***** DISPLAY NUMBER OF CONTACTS MENU *****");
		System.out.print("Number of contacts: ");
	}

	public void displaySearchForContactMenu() {
		System.out.println();
		System.out.println("***** SEARCH FOR CONTACT MENU *****");
		System.out.print("Enter a value to search for: ");
	}

	public void displayQuitApplicationMenu() {
		System.out.println();
		System.out.println("***** QUIT APPLICATION MENU *****");
		System.out.print("Are you sure you want to quit the application? (Y/[N]) : ");
	}

}
