CREATE OR REPLACE TRIGGER trg_DeleteClient
BEFORE DELETE
ON Client
FOR EACH ROW

DECLARE
v_client_id NUMBER := :old.id;
BEGIN
DELETE FROM Commande WHERE client_id=v_client_id;
DBMS_OUTPUT.PUT_LINE('Client supprim??e');
END trg_DeleteClient;
