/*
 * Person Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

import java.util.ArrayList;

public class Person {
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private ArrayList<String> emails;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		if (personCode.length() > 0) {
			this.personCode = personCode;
		} else {
			System.out.println("Person code is too short.");
			System.exit(1);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() > 0) {
			this.firstName = firstName;
		} else {
			System.out.println("First name is too short.");
			System.exit(1);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.length() > 0) {
			this.lastName = lastName;
		} else {
			System.out.println("Last name is too short.");
			System.exit(1);
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if (address != null) {
			this.address = address;
		} else {
			System.out.println("Please enter a valid address.");
			System.exit(1);
		}
	}

	public ArrayList<String> getEmails() {
		return this.emails;
	}

	public void setEmails(ArrayList<String> emails) {
		if (emails.size() > 0 && emails != null) {
			this.emails = emails;
		} else {
			System.out.println("Please enter a valid set of email address(es).");
			System.exit(1);
		}
	}

	public Person(String personCode, String firstName, String lastName, Address address) {
		super();
		if (personCode.length() > 0) {
			this.personCode = personCode;
		} else {
			System.out.println("Person code is too short.");
			System.exit(1);
		}
		if (firstName.length() > 0) {
			this.firstName = firstName;
		} else {
			System.out.println("First name is too short.");
			System.exit(1);
		}
		if (lastName.length() > 0) {
			this.lastName = lastName;
		} else {
			System.out.println("Last name is too short.");
			System.exit(1);
		}
		if (address != null) {
			this.address = address;
		} else {
			System.out.println("Please enter a valid member address.");
			System.exit(1);
		}
	}

	public Person(String personCode, String firstName, String lastName, Address address, ArrayList<String> emails) {
		super();
		if (personCode.length() > 0) {
			this.personCode = personCode;
		} else {
			System.out.println("Person code is too short.");
			System.exit(1);
		}
		if (firstName.length() > 0) {
			this.firstName = firstName;
		} else {
			System.out.println("First name is too short.");
			System.exit(1);
		}
		if (lastName.length() > 0) {
			this.lastName = lastName;
		} else {
			System.out.println("Last name is too short.");
			System.exit(1);
		}
		if (address != null) {
			this.address = address;
		} else {
			System.out.println("Please enter a valid member address.");
			System.exit(1);
		}
		if (emails.size() > 0 && emails != null) {
			this.emails = emails;
		} else {
			System.out.println("Please enter a valid set of email address(es).");
			System.exit(1);
		}
	}
}
