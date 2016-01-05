package edu.iut.gui;


import edu.iut.dbaction.DB;
import edu.iut.dbaction.DatabaseAction;
import edu.iut.dbaction.QueryExecuteAction;
import edu.iut.dbaction.StoredFunctionAction;
import edu.iut.input.DateConverter;
import edu.iut.input.InputData;
import edu.iut.input.IntegerConverter;
import edu.iut.input.StringConverter;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Initialisation des trois convertisseurs de données.
        // Le rôle de ses classes est de convertir les données saisies
        // par l'utilisateur en objets Java (Integer, Date...).
        StringConverter sc = new StringConverter();
        DateConverter dc = new DateConverter();
        IntegerConverter ic = new IntegerConverter();

        // Initialisation de toutes les actions prises en charge par l'application
        StoredFunctionAction a1 = new StoredFunctionAction("Nombre d'étudiants avec un stage cette année", null, "getNbEtudiantsStage");
        StoredFunctionAction a2 = new StoredFunctionAction("Nombre d'étudiants sans stage cette année", null, "getNbEtudiantsNoStage");
        StoredFunctionAction a3 = new StoredFunctionAction("Nombre d'étudiants sans stage pour l'année N à la date du ../../N", new InputData<>("Date (JJ/MM/AAAA)", dc), "etudiantsSansStageDate");
        StoredFunctionAction a4 = new StoredFunctionAction("Nombre de stages dans le département", new InputData<>("Code département", ic), "fonctionDep");
        StoredFunctionAction a5 = new StoredFunctionAction("Nombre de stages dans la ville", new InputData<>("Ville", sc), "fonctionVille");
        StoredFunctionAction a6 = new StoredFunctionAction("Nombre moy. de stagiaires par entreprise les n dernières années", new InputData<>("Nombre d'années n", ic), "nbMoyenStagiairesEntrep");
        QueryExecuteAction a7 = new QueryExecuteAction("Nombre de stages par zone géographique", null, "SELECT * FROM stagesParZone");

        // Connexion à la base de donnée
        DB db = new DB();

        // Affichage de la GUI
        MainFrame frame = new MainFrame(new DatabaseAction[]{a1, a2, a3, a4, a5, a6, a7}, db);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
