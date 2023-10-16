CREATE OR REPLACE PROCEDURE sp_InsertCommandeLigne(p_id INT, p_commande_id INT, p_nom_produit VARCHAR2, p_quantite INT) IS
V_prix_total INT;
BEGIN

SELECT prix_unitaire*p_quantite INTO V_prix_total FROM PRODUIT WHERE nom_produit= p_nom_produit;
DBMS_OUTPUT.PUT_LINE('Le prix total est' || V_prix_total);
INSERT INTO COMMANDE_LIGNE VALUES(p_id, p_commande_id, p_nom_produit, p_quantite, V_prix_total);
DBMS_OUTPUT.PUT_LINE('La commande est insérée avec l id ' || p_id);

END sp_InsertCommandeLigne;