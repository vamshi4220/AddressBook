import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		MenuSystem menuSystem = new MenuSystem();
		AddressBook addressBook = new AddressBook();
		Scanner in = new Scanner(System.in);
		Contact contact = new Contact();
		Boolean quit = false;
		boolean customFieldBoolean = false;
		String repeat;
		String yesOrNo = "n";
		boolean validInput;
		;
		String crudeMenuChoice = null;

		do {

			repeat = null;
			menuSystem.displayMainMenu();

			if (addressBook.getCurrentContact() != null) {
				System.out.println("*****Current Contact*****");
				System.out.println(addressBook.getCurrentContact().toString());
			} else {
				System.out.println("*****No Current Contact*****");
			}

			System.out.println();
			System.out.print("Please choose a menu item above by entering a number (1-6): ");

			validInput = false;
			while (validInput == false) {
				validInput = true;
				crudeMenuChoice = in.nextLine();

				try {
					int menuChoice = Integer.parseInt(crudeMenuChoice);

				} catch (Exception e) {
					validInput = false;
					System.out.println();
					System.out.print("Invalid input, try again: ");

				} finally {
					if (validInput == true) {
						int menuChoice = Integer.parseInt(crudeMenuChoice);
						if (1 > menuChoice || 6 < menuChoice) {
							validInput = false;
							System.out.println();
							System.out.print("Invalid number, try again: ");
						}
					}

				}

			}
			int menuChoice = Integer.parseInt(crudeMenuChoice);

			switch (menuChoice) {

			case 1:
				menuSystem.displayAddContactMenu();
				contact = new Contact();
				System.out.println();
				System.out.print("Enter First Name: ");
				String firstName = in.nextLine();
				contact.setFirstName(firstName);
				System.out.print("Enter Last Name: ");
				String lastName = in.nextLine();
				contact.setLastName(lastName);
				System.out.print("Enter Phone Number: ");
				String phoneNumber = in.nextLine();
				contact.setPhoneNumber(phoneNumber);
				System.out.print("Enter Email: ");
				String email = in.nextLine();
				contact.setEmailAddress(email);
				addressBook.addContact(contact);

				System.out.print("(Optional) Custom Field (Y/N)? ");
				yesOrNo = in.nextLine();
				if (yesOrNo.toLowerCase().equals("y")) {
					customFieldBoolean = false;
					while (customFieldBoolean == false) {
						System.out.print("Enter your custom fields name: ");
						String customField = in.nextLine();
						System.out.print("Enter a value for" + customField
								+ ":");
						String customFieldValue = in.nextLine();
						contact.setCustomField(customField, customFieldValue);
						System.out
								.print("Would you like to add another custom field (Y/N): ");
						yesOrNo = in.nextLine();

						if (yesOrNo.toLowerCase().equals("n"))
							customFieldBoolean = true;
					}
				}
				break;

			case 2:
				menuSystem.displayDeleteContactMenu();
				yesOrNo = in.nextLine();
				if (yesOrNo.toLowerCase().equals("y"))
					addressBook.deleteContact();
				break;

			case 3:
				menuSystem.displayUpdateContactMenu();
				String crudeUpdateInfo = in.nextLine();
				if (crudeUpdateInfo.contains(","))
					addressBook.updateContact(crudeUpdateInfo.substring(0,
							crudeUpdateInfo.indexOf(",")), crudeUpdateInfo
							.substring(crudeUpdateInfo.indexOf(",") + 1,
									crudeUpdateInfo.length()));
				else
					System.out
							.println("Info was not entered correctly, please make sure to use a comma!");
					System.out.println("Press [Enter] to continue");
					repeat = in.nextLine();
					if (!repeat.equals(null))
					break;
				break;

			case 4:
				menuSystem.displayNumberOfContactsMenu();
				System.out.println(addressBook.getContactCount());
				System.out.println();
				System.out.println("Press [Enter] to continue");
				repeat = in.nextLine();
				if (!repeat.equals(null))
					break;

			case 5:
				menuSystem.displaySearchForContactMenu();
				String searchInfo = in.nextLine();
				ArrayList<Contact> matches = addressBook
						.searchForContact(searchInfo);
				if (matches.size() == 0) {
					System.out.println("There were 0 results found.");
					System.out.println();
					System.out.println("Press [Enter] to continue");
					repeat = in.nextLine();
					if (!repeat.equals(null))
						break;
				} else
					System.out.println("There were " + matches.size()
							+ " results found.");
				System.out
						.println("Would you like to print out the results (Y/N)?");
				yesOrNo = "n";
				yesOrNo = in.nextLine();
				if (yesOrNo.toLowerCase().equals("y")) {

					System.out.println("**********");
					System.out.println("Search Results:");
					System.out.println();
					for (Contact match : matches) {
						System.out.println(match.toString());
						System.out.println("----------");
					}
					System.out.println("**********");

					System.out.println();
					System.out.println("Press [Enter] to continue");
					repeat = in.nextLine();
					if (!repeat.equals(null))
						break;
				} else
					break;
			case 6:
				menuSystem.displayQuitApplicationMenu();
				yesOrNo = in.nextLine();
				if (yesOrNo.toLowerCase().equals("y")) {
					System.out.println();
					System.out.println("***** Application terminated. *****");
					quit = true;
				}
				break;
			default:
				System.out.println();
				System.out.println("Unknown error!");
				break;
			}

		} while (quit != true);

	}
}
