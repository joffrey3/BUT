DECLARE
V_quantite_total INT;
V_nom_produit VARCHAR2(1000);

BEGIN
V_nom_produit:='pisseur3000';
DBMS_OUTPUT.PUT_LINE('Pour le groupe'|| V_nom_produit || ' la quantite des produits vendus est' || fn_QteProduitVendu(V_nom_produit));

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END;