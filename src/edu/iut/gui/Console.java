package edu.iut.gui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;

/**
 * La console est le composant graphique qui
 * affiche le résultat des actions éxécutés
 * en base de données.
 */
public class Console extends JTextPane {

    /**
     * Initialise la console
     */
    public Console(){
        setMinimumSize(new Dimension(300, 500));
        setPreferredSize(new Dimension(300, 500));

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        setFont(font);
        setEditable(false);
    }

    /**
     * Ajoute une ligne dans la console
     * @param text Texte à ajouter
     */
    public void addInfo(String text){
        try {
            getDocument().insertString(getDocument().getLength(), text + '\n', null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    /*public void addError(String text){

    }*/
}
