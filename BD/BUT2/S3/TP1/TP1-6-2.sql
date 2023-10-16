DECLARE
V_nomProduit VARCHAR2(100);
V_prixUnitaire NUMBER;
BEGIN
v_nomproduit:='spoon';
V_prixUnitaire:= fn_PrixUnitaire(V_nomProduit);
DBMS_OUTPUT.PUT_LINE('Le prix est' || V_PrixUnitaire);

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END fn_PrixUnitaire;