/*
 * JSON File Writer 1.0
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Uses GSON library to parse object lists into neatly formatted JSON.
 * Requires JSONLocalDateTimeConverter class.
 */

package writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.joda.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Member;
import entities.Person;
import entities.Product;

public class JSONFileWriter {
	// Takes in Member list and writes to JSON
	public void jsonConverterMembers(ArrayList<Member> member) {
		// Creates a Gson object
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Initializes PrintWriter, then tries to write to disk.
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Members.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to JSON file
		for (Member m : member) {
			String extract = gson.toJson(m);
			pw.println(extract);
		}

		pw.close();
	}

	// Takes in Person list and writes to JSON
	public void jsonConverterPersons(ArrayList<Person> person) {
		// Creates a Gson object
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Initializes PrintWriter, then tries to write to disk.
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Persons.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to JSON file
		for (Person p : person) {
			String extract = gson.toJson(p);
			pw.println(extract);
		}

		pw.close();
	}

	// Takes in Product list and writes to JSON
	public void jsonConverterProducts(ArrayList<Product> product) {
		// Creates a Gson object with special LocalDateTime formatter for joda time
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.registerTypeAdapter(LocalDateTime.class, new JSONLocalDateTimeConverter()).create();

		// Initializes PrintWriter, then tries to write to disk.
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Products.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Writes every list element to JSON file
		for (Product pro : product) {
			String extract = gson.toJson(pro);
			pw.println(extract);
		}

		pw.close();
	}

}