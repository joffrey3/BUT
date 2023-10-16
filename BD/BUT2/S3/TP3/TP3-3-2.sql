CREATE OR REPLACE PROCEDURE sp_InsertCommandeLigne2(p_commande_id INT, p_nom_produit VARCHAR2, p_quantite INT) IS
v_prix_total INT;
v_nombre_ligne INT;
v_quantite_commande INT;
BEGIN
SELECT COUNT(*) INTO v_nombre_ligne FROM commande_ligne WHERE nom_produit=p_nom_produit AND commande_id=p_commande_id;
IF V_nombre_ligne>0
THEN
SELECT quantite+p_quantite INTO v_quantite_commande FROM commande_ligne WHERE nom_produit=p_nom_produit AND commande_id=p_commande_id;
trg_GestionStock(p_nom_produit,V_quantite_commande);
UPDATE commande_ligne SET quantite=quantite+p_quantite WHERE nom_produit=p_nom_produit AND quantite=p_quantite;
ELSIF V_nombre_ligne=0 THEN
SELECT prix_unitaire*p_quantite INTO V_prix_total FROM Produit WHERE nom_produit= p_nom_produit;
INSERT INTO  commande_ligne VALUES(seq_CommandeLigne.nextval, p_commande_id, p_nom_produit, p_quantite, V_prix_total);
END IF;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END sp_InsertCommandeLigne2;