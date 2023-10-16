CREATE OR REPLACE PROCEDURE trg_GestionStock(p_nom_produit VARCHAR2, p_quantite_commande NUMBER) IS
V_stock NUMBER;
probleme EXCEPTION;
BEGIN
SELECT quantite_stock INTO V_stock FROM Produit WHERE nom_produit=p_nom_produit;
IF V_stock<p_quantite_commande
THEN RAISE PROBLEME;
END IF;

END trg_GestionStock;