package edu.iut.input;

/**
 * Convertit une chaîne de caractères... en une chaîne de caractères.
 */
public class StringConverter implements InputConverter<String> {

    @Override
    public String convert(String input) throws IllegalArgumentException {
        return input;
    }

}
