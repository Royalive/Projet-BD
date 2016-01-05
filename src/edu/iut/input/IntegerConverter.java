package edu.iut.input;

/**
 * Convertit une chaîne de caractères en un Integer.
 */
public class IntegerConverter implements InputConverter<Integer> {
    @Override
    public Integer convert(String input) throws IllegalArgumentException {
        try{
            return Integer.valueOf(input);
        }catch(NumberFormatException ex){
            throw new IllegalArgumentException();
        }
    }
}
