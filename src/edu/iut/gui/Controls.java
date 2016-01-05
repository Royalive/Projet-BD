package edu.iut.gui;

import edu.iut.dbaction.DatabaseAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Représente l'ensemble des éléments
 * de contrôle de l'application.
 * A savoir :
 *
 * - Le combobox affichant la liste des actions
 * disponibles pour la base de donnée.
 * - Le champ de saisie de donnée optionnel,
 * potentiellement nécéssaire au traitement de l'action choisie.
 * - Le bouton éxécuter
 */
public class Controls extends JPanel implements ActionListener, ItemListener {
    private JComboBox<DatabaseAction> comboBox;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton execButton;

    private ActionExecListener listener;

    private static String NO_DATA_REQUIRED = "Aucune donnée à saisir";

    /**
     * Initialisation des contrôles pour les actions passés en paramètres
     * @param actions Actions disponibles en base de données
     * @param listener Listener à appeler lorsque l'utilisateur éxécute une action
     */
    public Controls(DatabaseAction[] actions, ActionExecListener listener){
        comboBox = new JComboBox<>(actions);
        inputLabel = new JLabel(NO_DATA_REQUIRED);
        inputField = new JTextField();
        execButton = new JButton("Exécuter");

        inputField.setEnabled(false);
        inputLabel.setEnabled(false);
        Dimension d1 = inputField.getMinimumSize();
        Dimension d2 = inputField.getPreferredSize();
        d1.width = 150;
        d2.width = 150;
        inputField.setMinimumSize(d1);
        inputField.setPreferredSize(d2);

        JPanel p = new JPanel();
        p.add(inputLabel);
        p.add(inputField);
        p.add(execButton);

        setLayout(new GridLayout(2, 1));
        add(comboBox);
        add(p);

        execButton.addActionListener(this);
        comboBox.addItemListener(this);
        this.listener = listener;

    }

    /**
     * Listener appelé lorsque l'utilisateur clique sur "Executer".
     * La méthode vérifie que les éventuelles donnés saisies sont conformes au
     * modèle de données (Date, Integer, String...) utilisé pour l'action sélectionné.
     *
     * Si tout est OK, un autre listener est éxécuté pour lancer l'action.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DatabaseAction action = (comboBox.getItemAt(comboBox.getSelectedIndex()));
        if(action.requireInput()){
            try{
                Object o = action.getInputLabel().getConverter().convert(inputField.getText());
                listener.onActionExecute(action, o);
            }catch (IllegalArgumentException ex){
                JOptionPane.showMessageDialog(null, "Données entrés invalides", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            listener.onActionExecute(action, null);
        }

    }

    /**
     * Listener appelé lorsque l'action sélectionné dans le combobox change.
     * Il est alors nécéssaire de d'activer ou de désactive le champ de saisie
     * de donnée en fonction de l'action choisie.
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        DatabaseAction action = comboBox.getItemAt(comboBox.getSelectedIndex());
        if(action.requireInput()){
            inputField.setText("");
            inputField.setEnabled(true);
            inputLabel.setText(action.getInputLabel().getInputLabel());
            inputLabel.setEnabled(true);
        }else{
            inputField.setText("");
            inputField.setEnabled(false);
            inputLabel.setText(NO_DATA_REQUIRED);
            inputLabel.setEnabled(false);
        }
    }
}
