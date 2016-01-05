package edu.iut.dbaction;

import edu.iut.input.InputData;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Cette classe abstraite représente une action
 * pouvant être éxécutée sur une base de données.
 *
 * Ces actions peuvent être éxécutés en prenant
 * comme arguments une connexion à une BDD ainsi
 * qu'un paramètre optionnel pouvant être utilisé
 * lors de l'éxécution de l'action.
 *
 * (Par exemple, une requête de type "Trouver les
 * "étudiants sans stage à la date D", D est un
 *  paramètre utilisé lors de l'éxécution).
 */
public abstract class DatabaseAction {
    private String actionName;
    private InputData inputLabel;

    /**
     * Constructeur
     * @param actionName Nom de l'action, tel qu'il apparaît sur la GUI
     * @param input Modèle de données pour le paramètre optionnel
     */
    public DatabaseAction(String actionName, InputData input) {
        this.actionName = actionName;
        this.inputLabel = input;
    }

    /**
     * Exécute l'action
     * @param connection
     * @param param (optionnel)
     * @return Résultat de l'action/requête
     * @throws SQLException si la requête s'est mal déroulé
     */
    public abstract String execute(Connection connection, Object param) throws SQLException;

    /**
     * Retourne le nom de l'action tel qu'il apparaît sur la GUI
     * @return actionName
     */
    public String getActionName(){
        return actionName;
    }

    /**
     * Retourne le modèle de données du paramètre optionnel
     * @return inputLabel
     */
    public InputData getInputLabel(){
        return inputLabel;
    }

    /**
     * Retourne true si l'action requiert une donnée en paramètre pour être éxécutée
     * @return
     */
    public boolean requireInput(){
        return inputLabel != null;
    }

    @Override
    public String toString() {
        return actionName;
    }
}
