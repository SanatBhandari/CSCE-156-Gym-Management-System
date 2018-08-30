/*
 * Flat File Reader 1.0.2
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Takes in flat text/dat files and parses them in lists of corresponding objects.
 */

package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import entities.Address;
import entities.DayPass;
import entities.Member;
import entities.ParkingPass;
import entities.Person;
import entities.Product;
import entities.Rental;
import entities.YearPass;

public class FlatFileReader {

	// Creates List of Member objects from flat file
	public ArrayList<Member> MembersFileReader() {
		// Creates new file object
		String filename = "data/Members.dat";
		File file = new File(filename);

		// Initializes scanner object
		Scanner scnr = null;

		// Tries to open file
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.printf("\"%s\" not found.\n", filename);
			System.exit(1);
		}

		// Creates lists of persons and members as a person is part of a member
		ArrayList<Member> members = new ArrayList<Member>();
		ArrayList<Person> persons = PersonsFileReader();

		// Goes through every line, delimiting at semicolon, and attributing variables
		// as necessary to create the member objects.
		scnr.nextLine();
		while (scnr.hasNextLine()) {
			String member = scnr.nextLine();
			String[] memberArr = member.split(";");

			String memberCode = memberArr[0].trim();
			String memberType = memberArr[1].trim();

			String memberPrimaryContact = memberArr[2].trim();
			Person tempPerson = null;
			// As every member is made of a person, goes trough list of persons according to
			// code until it finds a match
			for (Person p : persons) {
				if (p.getPersonCode().equals(memberPrimaryContact)) {
					tempPerson = p;
				}
			}

			String memberName = memberArr[3];
			
			//Passes address to string to address function
			Address memberAddress = strToAddress(memberArr[4]);

			// Creates new member object and adds to list
			Member newMember = new Member(memberCode, memberType, tempPerson, memberName, memberAddress);
			members.add(newMember);

		}
		return members;
	}

	// Creates List of Person objects from flat file
	public ArrayList<Person> PersonsFileReader() {
		// Creates new file object
		String filename = "data/Persons.dat";
		File file = new File(filename);

		// Initializes scanner
		Scanner scnr = null;

		// Tries to open file
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.printf("\"%s\" not found.\n", filename);
			System.exit(1);
		}

		// Creates new list of person objects
		ArrayList<Person> persons = new ArrayList<Person>();

		// Goes through every line of flat file, creating a person object and adding it
		// to the list
		scnr.nextLine();
		while (scnr.hasNextLine()) {
			String person = scnr.nextLine();
			String[] personDetails = person.split(";");

			// Adds person code
			String personCode = personDetails[0].trim();

			// Breaks up name at comma and adds to first/last name variables
			String personName = personDetails[1];
			String[] personNameConstituent = personName.split(",");
			String personFirstName = personNameConstituent[1].trim();
			String personLastName = personNameConstituent[0].trim();
			
			//Passes address to string to address function
			Address personAddress = strToAddress(personDetails[2]);

			// Resets email flag, necessary in case a person does not have an email.
			boolean flag = false;

			// creates and empty list of emails
			ArrayList<String> emails = null;

			// if there are emails, then delimit, and add to list
			if (personDetails.length == 4 && personDetails[3].length() > 4) {
				flag = true;
				String personEmail = personDetails[3];
				String[] personEmailIndividual = personEmail.split(",");
				emails = new ArrayList<String>();
				for (String s : personEmailIndividual) {
					emails.add(s.trim());
				}
			}

			// Creates new person object based on whether they have and email or not, then
			// adds to list.
			if (flag) {
				Person personInfo = new Person(personCode, personFirstName, personLastName, personAddress, emails);
				persons.add(personInfo);
			} else {
				Person personInfo = new Person(personCode, personFirstName, personLastName, personAddress);
				persons.add(personInfo);
			}
		}

		return persons;

	}

	// Creates List of Product objects from flat file
	public ArrayList<Product> ProductsFileReader() {
		// Creates new file object
		String filename = "data/Products.dat";
		File file = new File(filename);

		// Initializes scanner
		Scanner scnr = null;

		// Tries to open file
		try {
			scnr = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.printf("\"%s\" not found.\n", filename);
			System.exit(1);
		}

		// Creates list of products
		ArrayList<Product> products = new ArrayList<Product>();
		Product p = null;

		// Goes line by line parsing flat file to variables, then creating Product
		// objects and adding to list
		scnr.nextLine();
		while (scnr.hasNextLine()) {
			String product = scnr.nextLine();
			String[] productInfo = product.split(";");

			String productCode = productInfo[0];
			String productType = productInfo[1];

			// As Product is a superclass, all subclasses are determined by single character
			// type
			// Every conditional performs the same function, just geared at the separate
			// types.
			// They go through the delimited strings, parse them, then create a new
			// product-related object, and add it to the list
			if (productType.equals("Y")) {
				YearPass y = null;
				DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
				LocalDateTime startDate = LocalDateTime.parse(productInfo[2], fmt);
				LocalDateTime endDate = LocalDateTime.parse(productInfo[3], fmt);
				
				//Passes address to string to address function
				Address productAddress = strToAddress(productInfo[4]);

				String passName = productInfo[5];

				String productCost = productInfo[6];
				double cost = Double.parseDouble(productCost);
				y = new YearPass(productCode, productType, cost, startDate, endDate, productAddress, passName);
				p = y;
			}

			else if (productType.equals("D")) {
				DayPass d = null;
				DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
				LocalDateTime dateTime = LocalDateTime.parse(productInfo[2], fmt);

				//Passes address to string to address function
				Address productAddress = strToAddress(productInfo[3]);
				
				String productCost = productInfo[4];
				double cost = Double.parseDouble(productCost);
				d = new DayPass(productCode, productType, cost, dateTime, productAddress);
				p = d;
			}

			else if (productType.equals("P")) {
				ParkingPass pp = null;

				String productCost = productInfo[2].trim();
				double cost = Double.parseDouble(productCost);
				pp = new ParkingPass(productCode, productType, cost);
				p = pp;
			}

			else if (productType.equals("R")) {
				Rental r = null;

				String productCost = productInfo[3].trim();
				double cost = Double.parseDouble(productCost);

				String productName = productInfo[2].trim();

				r = new Rental(productCode, productType, cost, productName);
				p = r;
			}

			products.add(p);
		}

		return products;
	}


	//Because address is referenced many times, parser function that takes in address string and returns Address object
	public static Address strToAddress(String address) {
		
		// Breaks up address at the comma and creates a new address object
		String[] addressConstituent = address.split(",");
		String street = addressConstituent[0].trim();
		String city = addressConstituent[1].trim();
		String state = addressConstituent[2].trim();
		String zip = addressConstituent[3].trim();
		String country = addressConstituent[4].trim();

		// Create address object
		Address addressObject = new Address(street, city, state, zip, country);
		
		return addressObject;
	}

}