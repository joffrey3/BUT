/*
C
Nom et Prénom : Joffrey Fouché
Groupe : 2
Salle TP : 235
Nom du voisin de gauche : Besson Romain
Nom du voisin de droite : Adrien Dos Santos
*/

--Exercice 1 :

CREATE OR REPLACE  FUNCTION salaire_moyen(p_job VARCHAR2)
RETURN NUMBER
IS
v_salaire_moyen NUMBER;
BEGIN 
SELECT AVG(SAL) INTO v_salaire_moyen FROM EMP WHERE JOB=p_job;
RETURN v_salaire_moyen;
END;

--Exercice 1 Test

SELECT DISTINCT JOB,salaire_moyen(JOB) FROM EMP;

--Exercice 2 :

CREATE OR REPLACE PROCEDURE ajuster(p_empno NUMBER) IS
v_comm NUMBER;
v_comm_min NUMBER;
BEGIN
SELECT COMM_MIN INTO v_comm_min FROM EMP_SEUIL;
IF v_comm<v_comm_min
THEN
UPDATE EMP SET COMM=v_comm_min WHERE EMPNO=p_empno;
END IF;
END;


--Exercice 3 :

CREATE OR REPLACE TRIGGER tr_nb_employe
AFTER INSERT OR UPDATE of DEPTNO OR DELETE
ON EMP
DECLARE
v_depno NUMBER;
BEGIN

IF INSERTING THEN
v_depno:=:new.DEPNO;
UPDATE SUIVI_EMP SET Nom_Emp=Nombre_Emp+1 WHERE DEPTNO=v_depno;
END IF;

IF UPDATING THEN
v_depno:=:old.DEPNO;
UPDATE SUIVI_EMP SET Nom_Emp=Nombre_Emp-1 WHERE DEPTNO=v_depno;
v_depno:=:new.DEPNO;
UPDATE SUIVI_EMP SET Nom_Emp=Nombre_Emp+1 WHERE DEPTNO=v_depno;
END IF;

IF DELETING THEN
v_depno:=:old.DEPNO;
UPDATE SUIVI_EMP SET Nom_Emp=Nombre_Emp-1 WHERE DEPTNO=v_depno;
END IF;

END;

--Exercice 4 :

DROP TABLE EMP_His;
CREATE TABLE EMP_His(EMPID INT PRIMARY KEY ,ENAME VARCHAR2(100),JOB VARCHAR2(100),HIREDATE DATE,DEPTNO NUMBER,ENDDATE DATE);

--Exercice 4  suite :

CREATE OR REPLACE TRIGGER trg_DeleteEmploye
BEFORE DELETE
ON EMP
DECLARE
TYPE GROUPE IS RECORD(v_empno NUMBER :=0,v_ename VARCHAR2(100) :=' ',v_job VARCHAR2(100) :=' ',v_hiredate VARCHAR2(1000) :=' ',v_deptno VARCHAR2(1000) :=' ',v_endate VARCHAR2(1000) :=' ');
v_object GROUPE;
v_empno NUMBER := :old.empno;
BEGIN
SELECT empno,ename,job,hiredate,deptno INTO v_object.v_empno,v_object.v_ename,v_object.v_job,v_object.v_hiredate,v_object.v_deptno FROM Client WHERE id=v_client_id;
INSERT INTO EMP_His VALUES(v_object.v_empno,v_object.v_ename,v_object.v_job,v_object.v_hiredate,v_object.v_deptno,'');
DELETE FROM Commande WHERE EMPNO=v_empno;
END trg_DeleteClient;
