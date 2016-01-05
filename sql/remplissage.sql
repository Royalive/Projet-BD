/* REMPLISSAGE DONNEES */
DELETE FROM stages;
DELETE FROM ENTREPRISES;
DELETE FROM ETUDIANTS;

INSERT INTO etudiants VALUES(1,'Roy','Aurelien',2015);
INSERT INTO etudiants VALUES(2,'Coispel','Romain',2015);
INSERT INTO etudiants VALUES(3,'Chaumeil','Paul',2015);
INSERT INTO etudiants VALUES(4,'Cherpentier','Antoine',2015);
INSERT INTO etudiants VALUES(5,'Gras','Johan',2015);
INSERT INTO etudiants VALUES(6,'Cirelli','Fabio',2015);
INSERT INTO etudiants VALUES(7,'Filoche','Correntin',2015);
INSERT INTO etudiants VALUES(8,'Villegier','Xavier',2015);
INSERT INTO etudiants VALUES(9,'Dupont','Martin',2014);
INSERT INTO etudiants VALUES(10,'Dupont','Fernand',2014);

INSERT INTO entreprises VALUES(1,'EDF','22-30 avenue de Wargram', 'Paris', 75);
INSERT INTO entreprises VALUES(2,'SFR','1 square Bella Bartok', 'Paris', 75);
INSERT INTO entreprises VALUES(3,'Orange','78 rue Olivier de Serres', 'Paris', 75);
INSERT INTO entreprises VALUES(4,'MAIF','200 avenue Salvador Allende', 'Niort', 79);
INSERT INTO entreprises VALUES(5,'Danone','17 boulevard Haussman', 'Paris', 75);
INSERT INTO entreprises VALUES(6,'HP','1 avenue du Canada', 'Les Ulis', 91);

INSERT INTO stages VALUES (1, 1, 2, TO_DATE('2016-02-02','YYYY-MM-DD'));
INSERT INTO stages VALUES (2, 4, 3, TO_DATE('2016-03-04','YYYY-MM-DD'));
INSERT INTO stages VALUES (3, 5, 4, TO_DATE('2016-01-17','YYYY-MM-DD'));
INSERT INTO stages VALUES (4, 5, NULL, NULL);
INSERT INTO stages VALUES (5, 6, 8, TO_DATE('2016-01-24','YYYY-MM-DD'));