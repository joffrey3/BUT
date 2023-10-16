DECLARE 
V_Simon NUMBER;

BEGIN
sp_DetermineProduitEnPromo('quantite_stock<10', V_Simon);
DBMS_OUTPUT.PUT_LINE('il y a ' || V_Simon || 'produits en promo');

END;