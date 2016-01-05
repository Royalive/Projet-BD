/* Procédures */

CREATE OR REPLACE FUNCTION getNbEtudiantsStage
  RETURN INT IS nb INT;
  BEGIN
    SELECT count(*) INTO nb
    FROM stages
    WHERE to_char(dateSignature,'YYYY')=to_char(SYSDATE,'YYYY');
    RETURN nb;
  end;


CREATE OR REPLACE FUNCTION getNbEtudiantsNoStage
  RETURN INT IS nb INT;
  BEGIN
    SELECT COUNT(*) INTO nb
    FROM etudiants
    WHERE id NOT IN (
      SELECT e.id
      FROM etudiants e, stages s
      WHERE e.id = s.etudiant
            AND to_char(dateSignature, 'YYYY') = to_char(SYSDATE,'YYYY')
    );
    RETURN nb;
  END;


CREATE OR REPLACE FUNCTION etudiantsSansStageDate(dateStage in DATE)
  RETURN INT IS nb INT;
  BEGIN
    SELECT COUNT(*) INTO nb
    FROM etudiants
    WHERE promo=to_char(dateStage,'YYYY')+1
          AND id NOT IN (
      SELECT e.id
      FROM etudiants e, stages s
      WHERE e.id = s.etudiant
            AND dateSignature < dateStage
            AND promo=to_char(dateStage,'YYYY')+1
    );
    return nb;
  END;

CREATE OR REPLACE FUNCTION fonctionDep(dep in INT)
  return int is nb int;
  BEGIN
    select count(*) into nb
    from stages s, entreprises e
    where s.entreprise=e.id
          and departement=dep;
    return nb;
  END;

CREATE OR REPLACE FUNCTION fonctionVille(v in varchar)
  return int is nb int;
  BEGIN
    select count(*) into nb
    from stages s, entreprises e
    where s.entreprise=e.id
          and ville=v;
    return nb;
  END;

CREATE OR REPLACE FUNCTION nbMoyenStagiairesEntrep(n in INT)
  RETURN FLOAT IS av FLOAT;
  BEGIN
    SELECT AVG(CAST(COUNT(s.id) AS FLOAT)) INTO av
    FROM entreprises e LEFT JOIN stages s ON s.entreprise = e.id
    WHERE s.id IS NULL OR to_char(dateSignature,'YYYY') > to_char(SYSDATE,'YYYY')-n
    GROUP BY entreprise;
    RETURN av;
  END;

CREATE OR REPLACE VIEW stagesParZone AS
  SELECT departement, ville, COUNT(*) AS NbStages
  FROM stages s, entreprises e
  WHERE s.entreprise = e.id
  GROUP BY departement, ville
  ORDER BY departement, ville;