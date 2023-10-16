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
