import java.util.HashMap;


public class Contact {

	String firstName, lastName, phoneNumber, emailAddress, toString;

	public Contact() {
		firstName = lastName = phoneNumber = emailAddress = toString = null;
		this.customField = new HashMap<String,String>();
	}

	public Contact(String firstName, String lastName, String phoneNumber,
			String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.customField = new HashMap<String,String>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public HashMap<String, String> getCustomFields() {
			return customField;
	}

	public void setCustomField(String fieldName, String fieldValue) {
		customField.put(fieldName, fieldValue);
	}

	public String toString() {

		toString = "First Name: " + firstName + "\nLast Name: " + lastName
				+ "\nPhone Number: " + phoneNumber + "\nEmail Address: "
				+ emailAddress;
		if (customField.size() == 0)
			return toString;
		else {
			for (String key : customField.keySet())
				toString = toString + "\n" + key + ": " + customField.get(key);
			return toString;
		}

	}

	private HashMap<String, String> customField;

}
