CREATE OR REPLACE FUNCTION fn_AfficheMontantFacture(p_commande_id VARCHAR2)
RETURN INT IS
V_montantFacture INT;
BEGIN

SELECT SUM(quantite*prix_unitaire) INTO V_montantFacture FROM commande_ligne JOIN Produit USING(nom_produit) WHERE commande_id=p_commande_id;
RETURN  V_montantFacture;

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END fn_AfficheMontantFacture;