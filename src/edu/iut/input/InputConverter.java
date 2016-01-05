package edu.iut.input;

/**
 * Classe abstraite dans le rôle est de convertir
 * une chaîne de caractères saisie par l'utilisateur
 * en un objet de classe E.
 * @param <E>
 */
public interface InputConverter<E> {
    /**
     * Convertit input en un objet E
     * @param input
     * @return L'objet crée
     * @throws IllegalArgumentException lorsque input ne peut être convertit (Format incorrect)
     */
    E convert(String input) throws IllegalArgumentException;
}
