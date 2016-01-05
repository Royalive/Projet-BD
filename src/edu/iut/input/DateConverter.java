package edu.iut.input;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Convertit une chaîne de caractères en une date.
 */
public class DateConverter implements InputConverter<Date> {

    private static DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date convert(String input) throws IllegalArgumentException {
        try {
            return formater.parse(input);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }
}
