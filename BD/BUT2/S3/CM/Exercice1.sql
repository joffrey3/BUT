CREATE OR REPLACE  FUNCTION salaire_moyen(p_job VARCHAR2)
RETURN NUMBER
IS
v_salaire_moyen NUMBER;
BEGIN 
SELECT AVG(SAL) INTO v_salaire_moyen FROM EMP WHERE JOB=p_job;
RETURN v_salaire_moyen;
END;