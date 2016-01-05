/* STRUCTURE */

CREATE TABLE etudiants(
  id INT PRIMARY KEY,
  nom VARCHAR(50),
  prenom VARCHAR(50),
  promo INT
);

CREATE TABLE entreprises(
  id INT PRIMARY KEY,
  nom VARCHAR(50),
  adresse VARCHAR(255),
  ville VARCHAR(50),
  departement INT
);

CREATE TABLE stages(
  id INT PRIMARY KEY,
  entreprise INT,
  etudiant INT,
  dateSignature DATE,
  CONSTRAINT fk_entreprise FOREIGN KEY (entreprise) REFERENCES entreprises(id),
  CONSTRAINT fk_etudiant FOREIGN KEY (etudiant) REFERENCES etudiants(id)

);

