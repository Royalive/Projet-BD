package edu.iut.dbaction;

import edu.iut.input.InputData;

import java.sql.*;

/**
 * Action consistant en l'éxécution
 * d'une requête simple sans paramètres.
 */
public class QueryExecuteAction extends DatabaseAction {

    private String query;

    /**
     * Constructeur
     * @param actionName Nom de l'action tel qu'il apparaît dans la GUI
     * @param input Non pris en charge pour cette action
     * @param query Requête à éxécuter
     */
    public QueryExecuteAction(String actionName, InputData input, String query) {
        super(actionName, input);
        this.query = query;
    }

    /**
     * Execute la requête query et retourne le résultat sous forme d'un tableau dans une String
     * @param connection Connexion à la base
     * @param param Non pris en charge pour cette action
     * @return Résultat de la requête
     * @throws SQLException
     */
    public String execute(Connection connection, Object param) throws SQLException {

        StringBuilder sb = new StringBuilder();

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData md = resultSet.getMetaData();

            for(int i = 1; i <= md.getColumnCount(); i++){
                sb.append(md.getColumnName(i));
                sb.append("  ");
            }

            sb.append('\n');

            while(resultSet.next()){
                for(int i = 1; i <= md.getColumnCount(); i++){
                    String data = resultSet.getString(i);
                    sb.append(data);
                    int blankToInsert = Math.max(0, md.getColumnName(i).length()+2-data.length());
                    for(int j = 0; j < blankToInsert; j++){
                        sb.append(' ');
                    }

                }

                sb.append('\n');
            }


            stmt.close();

        return sb.toString();


    }

}
