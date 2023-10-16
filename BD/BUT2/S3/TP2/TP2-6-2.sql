CREATE OR REPLACE TRIGGER trg_DeleteEmploye
BEFORE DELETE
ON EMP
DECLARE
TYPE GROUPE IS RECORD(v_empno NUMBER :=0,v_ename VARCHAR2(100) :=' ',v_job VARCHAR2(100) :=' ',v_hiredate VARCHAR2(1000) :=' ',v_deptno VARCHAR2(1000) :=' ');
v_object GROUPE;
v_client_id NUMBER := :old.id;
BEGIN
SELECT id,prenom,nom,email,ville INTO v_object.v_id,v_object.v_prenom,v_object.v_nom,v_object.v_email,v_object.v_ville FROM Client WHERE id=v_client_id;
INSERT INTO Client_His VALUES(v_object.v_id,v_object.v_prenom,v_object.v_nom,v_object.v_email,v_object.v_ville);
DELETE FROM Commande WHERE client_id=v_client_id;
DBMS_OUTPUT.PUT_LINE('Client supprimee');
END trg_DeleteClient;
