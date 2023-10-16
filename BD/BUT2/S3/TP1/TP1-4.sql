CREATE OR REPLACE FUNCTION fn_QteProduitVendu(p_nom_produit VARCHAR2)
RETURN INT IS
V_quantite_total INT;
BEGIN

SELECT SUM(quantite) INTO V_quantite_total  FROM commande_ligne WHERE nom_produit= p_nom_produit;
RETURN V_quantite_total;

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END fn_QteProduitVendu;