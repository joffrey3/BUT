CREATE OR REPLACE PROCEDURE sp_DateDernierAchat IS
TYPE  tabProduit IS TABLE OF VARCHAR2(1000); 
v_DateDernierProduit DATE;
v_tableProduit tabProduit;
v_increment INT:=1;
BEGIN
SELECT nom_produit BULK COLLECT INTO v_tableProduit FROM Produit;
FORALL v_increment IN 1..v_tableProduit.count
SELECT MAX(date_achat) INTO v_DateDernierProduit FROM Commande c JOIN commande_ligne cl ON c.id=cl.commande_id WHERE nom_produit=v_tableProduit(v_increment);
DBMS_OUTPUT.PUT_LINE('La dernière date d achat du produit ' || v_tableProduit(v_increment) || ' est ' || v_DateDernierProduit);
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END sp_DateDernierAchat;