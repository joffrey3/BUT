CREATE OR REPLACE TRIGGER trg_DeleteCommande 
BEFORE DELETE
ON Commande
FOR EACH ROW

DECLARE
v_commande_id NUMBER := :old.id;
BEGIN
DELETE FROM Commande_ligne WHERE commande_id=v_commande_id;
DBMS_OUTPUT.PUT_LINE('Commande supprimée');
END;
