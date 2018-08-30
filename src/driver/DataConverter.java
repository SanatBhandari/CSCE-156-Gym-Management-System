/*
 * Data Converter 1.0
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Driver program for converting flat text/dat files into XML and JSON.
 */

package driver;

import java.util.ArrayList;

import entities.Member;
import entities.Person;
import entities.Product;
import reader.FlatFileReader;
import writer.JSONFileWriter;
import writer.XMLFileWriter;

public class DataConverter {
	public static void main(String[] args) {

		// Creates reader and writer objects
		System.out.println("Data Converter 1.0: \nNow loading .dat files...");
		FlatFileReader ffr = new FlatFileReader();
		XMLFileWriter xfw = new XMLFileWriter();
		JSONFileWriter jfw = new JSONFileWriter();

		// Parses Members flat file into list, then writes to XML and JSON
		System.out.println("Converting Members.dat to XML and JSON...");
		ArrayList<Member> gymMembers = new ArrayList<Member>();
		gymMembers = ffr.MembersFileReader();
		xfw.xmlConverterMembers(gymMembers);
		jfw.jsonConverterMembers(gymMembers);

		// Parses Persons flat file into list, then writes to XML and JSON
		System.out.println("Converting Persons.dat to XML and JSON...");
		ArrayList<Person> gymPersons = new ArrayList<Person>();
		gymPersons = ffr.PersonsFileReader();
		xfw.xmlConverterPersons(gymPersons);
		jfw.jsonConverterPersons(gymPersons);

		// Parses Products flat file into list, then writes to XML and JSON
		System.out.println("Converting Products.dat to XML and Json...");
		ArrayList<Product> gymProducts = new ArrayList<Product>();
		gymProducts = ffr.ProductsFileReader();
		xfw.xmlConverterProducts(gymProducts);
		jfw.jsonConverterProducts(gymProducts);

		System.out.println("Finished.");
	}

}
