/*
 * XML File Writer 1.0
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Uses XStream library to write lists into neatly formatted XML. 
 * Requires XMLLocalDateTimeConverter class to function.
 */

package writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import entities.DayPass;
import entities.Member;
import entities.ParkingPass;
import entities.Person;
import entities.Product;
import entities.Rental;
import entities.YearPass;

public class XMLFileWriter {
	// Takes in Member list and writes to XML
	public void xmlConverterMembers(ArrayList<Member> member) {
		// Creates a new XStream object and makes a "member" tag
		XStream xstream = new XStream();
		xstream.alias("member", Member.class);

		// Creates a PrintWriter object, then tries to write to XML file
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Members.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to XML file in sequential order.
		for (Member m : member) {
			pw.println(xstream.toXML(m));
		}

		pw.close();
	}

	// Takes in Person list and writes to XML
	public void xmlConverterPersons(ArrayList<Person> person) {
		// Creates a new XStream object and makes a "person" tag
		XStream xstream = new XStream();
		xstream.alias("person", Person.class);

		// Creates a PrintWriter object, then tries to write to XML file
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Persons.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to XML file in sequential order.
		for (Person p : person) {
			pw.println(xstream.toXML(p));
		}

		pw.close();
	}

	// Takes in Product list and writes to XML
	public void xmlConverterProducts(ArrayList<Product> products) {
		// Creates a new XStream object and makes tags for every product related object
		XStream xstream = new XStream();
		xstream.alias("product", Product.class);
		xstream.alias("year-pass", YearPass.class);
		xstream.alias("day-pass", DayPass.class);
		xstream.alias("rental", Rental.class);
		xstream.alias("parking-pass", ParkingPass.class);
		// Creates a new converter for LocalDateTime from Joda time library to make it
		// pretty
		xstream.registerConverter(new XMLLocalDateTimeConverter(null));

		// Creates a PrintWriter object, then tries to write to XML file
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Products.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to XML file in sequential order.
		for (Product n : products) {
			pw.println(xstream.toXML(n));
		}

		pw.close();
	}

}
