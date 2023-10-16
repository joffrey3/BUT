CREATE OR REPLACE FUNCTION fn_MontantFacture(p_commande_id NUMBER)
RETURN NUMBER
IS
v_montant_total NUMBER(10,3);
BEGIN
SELECT SUM(prix_total) INTO v_montant_total
FROM commande_ligne
WHERE commande_id = p_commande_id;
RETURN v_montant_total;
END;
