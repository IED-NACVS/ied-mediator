package fr.nacvs.ied_mediator.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * Create a new instance of LocalDate from a string in the "yyyy-mm-dd" format
	 */
	public static LocalDate toDate(String date) {
		return LocalDate.parse(date, FORMATTER);
	}
	
	/**
	 * format the date to a string in the "yyyy-mm-dd" format
	 */
	public static String toString(LocalDate date) {
		return date.format(FORMATTER);
	}
}
