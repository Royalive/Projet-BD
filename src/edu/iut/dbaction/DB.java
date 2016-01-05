package edu.iut.dbaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Wrapper se connectant à la base de données
 */
public class DB {
    private Connection co;

    /**
     * Initialise la connexion à la base de donnée
     */
    public DB(){

        String url = "jdbc:oracle:thin:aroy1/demo@oracle.iut-orsay.fr:1521:etudom";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); co= DriverManager.getConnection(url);
        }
        catch (ClassNotFoundException e){
            System.out.println("il manque le driver oracle");
            System.exit(1); }
        catch (SQLException e) {
            System.out.println("impossible de se connecter à l'url : "+url); System.exit(1);
        }
    }

    /**
     * Retourne la connexion à la base
     * @return
     */
    public Connection getConnection() {
        return co;
    }


}
