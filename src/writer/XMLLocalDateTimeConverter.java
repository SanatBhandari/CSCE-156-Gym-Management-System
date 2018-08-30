/*
 * XML Local Date Time Converter
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Converts human readable form to and from joda library LocalDateTime variable.
 * Specifically implemented for XStream library.
 * NOTE: Input, when adding converter to XStream object, can be null.
 */

package writer;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class XMLLocalDateTimeConverter implements Converter {

	@SuppressWarnings("unused")
	private LocalDateTime dateTime;

	public XMLLocalDateTimeConverter(LocalDateTime class1) {
		super();
		this.dateTime = class1;
	}

	// Checks if class is of DateTime type
	@SuppressWarnings("rawtypes")
	public boolean canConvert(Class type) {
		return LocalDateTime.class.isAssignableFrom(type);
	}

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		// Takes in object and typecasts as DateTime
		LocalDateTime dateTime = (LocalDateTime) value;

		// Sets format
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

		// Parses as string and writes it.
		writer.setValue(dateTime.toString(fmt));

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) throws ConversionException {
		// Creates a DateTime object
		LocalDateTime dateTime = new LocalDateTime();

		// Sets the format
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

		// Parses the string
		dateTime = LocalDateTime.parse(reader.getValue(), fmt);

		// Returns the new object
		return dateTime;
	}

}
