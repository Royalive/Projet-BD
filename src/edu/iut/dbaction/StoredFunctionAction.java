package edu.iut.dbaction;

import edu.iut.input.InputData;

import java.sql.*;

/**
 * Action consistant en l'éxécution d'une
 * fonction PL/SQL stockée dans le serveur SQL.
 *
 * La fonction peut prendre optionellement un
 * paramètre.
 */
public class StoredFunctionAction extends DatabaseAction {

    private String functionName;

    /**
     * Constructeur
     * @param actionName Nom de l'action tel qu'il apparaît dans la GUI
     * @param inputLabel Modèle de donnée pour le paramètre
     * @param functionName Nom de la fonction PL/SQL à éxécuter
     */
    public StoredFunctionAction(String actionName, InputData inputLabel, String functionName) {
        super(actionName, inputLabel);
        this.functionName = functionName;
    }

    /**
     * Exécute la fonction PL/SQL et retourne le résultat sous forme de String
     * @param connection Connexion à la base de données
     * @param param Paramètre de la fonction (optionnel)
     * @return Résultat de la fonction
     * @throws SQLException
     */
    @Override
    public String execute(Connection connection, Object param) throws SQLException{

            String call = "{ ? = call " + functionName + (param != null ? "(?)" + " }" : "");
            CallableStatement stmt = connection.prepareCall(call);
            if (param != null) {
                if (param instanceof java.util.Date) {
                    System.out.println("date");
                    stmt.setDate(2, new Date(((java.util.Date) param).getTime()));
                } else if (param instanceof Integer) {
                    stmt.setInt(2, (Integer) param);
                } else {
                    stmt.setString(2, param.toString());
                }
            }

        stmt.registerOutParameter(1, Types.VARCHAR);
        stmt.execute();
        String result = stmt.getString(1);
        stmt.close();

        return result;
    }
}
