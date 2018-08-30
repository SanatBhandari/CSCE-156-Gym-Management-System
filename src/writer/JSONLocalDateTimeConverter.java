/*
 * JSON Local Date Time Converter
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 * 
 * Converts human readable form to and from joda library LocalDateTime variable.
 * Specifically implemented for Gson library.
 */

package writer;

import java.lang.reflect.Type;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JSONLocalDateTimeConverter implements JsonSerializer<LocalDateTime> {

	public JsonElement serialize(LocalDateTime dateTime, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")));
	}

	public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {
		LocalDateTime dateTime = null;
		try {
			dateTime = LocalDateTime.parse(json.getAsString(), DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return dateTime;
	}
}