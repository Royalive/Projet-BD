package edu.iut.gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import edu.iut.dbaction.*;

/**
 * Unique fenêtre du programme
 */
public class MainFrame extends JFrame implements ActionExecListener {

    private Console console;
    private Controls controls;

    private DatabaseAction[] actions;
    private DB db;

    /**
     * Initialise la fenêtre pour les actions et la connexion passés en paramètres
     * @param actions Actions sur la base de données qui seront proposés à l'utilisateur
     * @param db Base de donnée
     * @throws HeadlessException
     */
    public MainFrame(DatabaseAction[] actions, DB db) throws HeadlessException {
        super("Statistiques Stages");
        this.actions = actions;
        this.db = db;
        setupUI();
    }

    /**
     * Initialise les éléments d'interface
     */
    public void setupUI(){
        console = new Console();
        console.setBorder(new EmptyBorder(5,5,5,5));
        controls = new Controls(actions, this);

        setLayout(new BorderLayout());
        add(console, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        pack();
        setVisible(true);


    }

    /**
     * Listener appelé lorsque l'utilisateur souhaite éxécuter une action
     * @param action L'action à éxécuter
     * @param data La donnée optionelle saisie par l'utilisateur
     */
    @Override
    public void onActionExecute(DatabaseAction action, Object data) {

        try {
            String result = action.execute(db.getConnection(), data);
            if(!action.requireInput())
                console.addInfo(action.getActionName() + " : ");
            else
                console.addInfo(action.getActionName() + " (" + data + ") : ");
            console.addInfo(result);
            console.addInfo("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
