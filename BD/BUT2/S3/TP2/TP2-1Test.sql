DECLARE
v_montant_facture NUMBER;
BEGIN
v_montant_facture:=fn_MontantFacture(1);
DBMS_OUTPUT.PUT_LINE('Le montant de la facture est ' || v_montant_facture);
END;
