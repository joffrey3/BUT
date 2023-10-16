CREATE OR REPLACE FUNCTION fn_PrixUnitaire(p_nom_produit VARCHAR2)
RETURN INT IS
V_prix_unitaire INT;
BEGIN

SELECT Prix_unitaire INTO V_prix_unitaire  FROM Produit WHERE nom_produit= p_nom_produit;
RETURN V_prix_unitaire;

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END fn_PrixUnitaire;