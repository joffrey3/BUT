DECLARE
TYPE rec IS RECORD(id NUMBER,commande_id NUMBER,nom_produit VARCHAR2(1000),quantite NUMBER,prix_total NUMBER);
V_rec rec;
V_commande_id NUMBER := 2;

BEGIN
FOR counter IN 1..2
LOOP
--SELECT id INTO V_rec.id,commande_id INTO V_rec.commande_id,nom_produit INTO V_rec.nom_produit,quantite INTO V_rec.quantite,prix_total INTO V_rec.prix_total FROM Commande_ligne INTO WHERE commande_id=V_commande_id AND id=counter;
SELECT ID,commande_id, nom_produit, quantite, prix_total into V_rec from commande_ligne WHERE commande_id=V_commande_id AND id=counter;
DBMS_OUTPUT.PUT_LINE('Le montant de la facture est ');
END LOOP;
DELETE FROM Commande WHERE id=v_commande_id;
FOR counter IN 1..120
LOOP
--SELECT * FROM Commande_ligne WHERE commande_id=V_commande_id AND id=counter;
DBMS_OUTPUT.PUT_LINE('Le montant de la facture est ');
END LOOP;

END;