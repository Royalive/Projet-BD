/* TRIGGERS */

/* Création de la table statistiques et ajout d'une ligne unique */
CREATE TABLE statistiques(
  nb_etudiants_avec_stage INT,
  nb_etudiants_sans_stage INT
);
INSERT INTO statistiques VALUES (0,0);


/* En cas d'insertion de stages ou d'étudiants, on met à jour la table statistiques */

CREATE OR REPLACE TRIGGER post_insert_stage AFTER INSERT
ON Stages
  BEGIN

    UPDATE statistiques
    SET nb_etudiants_avec_stage=nb_etudiants_avec_stage+1,
      nb_etudiants_sans_stage=nb_etudiants_sans_stage-1;
  END;
/

CREATE OR REPLACE TRIGGER post_insert_etudiant AFTER INSERT
ON Etudiants
  BEGIN

    UPDATE statistiques
    SET nb_etudiants_sans_stage=nb_etudiants_sans_stage+1;
  END;
/