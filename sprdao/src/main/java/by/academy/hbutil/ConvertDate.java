package by.academy.hbutil;

public class ConvertDate {

	public static java.sql.Date convert(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}
}
