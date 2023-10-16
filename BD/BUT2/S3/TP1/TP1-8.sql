CREATE OR REPLACE FUNCTION fn_FraisLivraison(p_commande_id VARCHAR2)
RETURN INT IS

V_FraisLivraison INT;
V_MontantFacture INT;

BEGIN

V_MontantFacture:=fn_AfficheMontantFacture(p_commande_id);

IF V_MontantFacture<50
THEN V_FraisLivraison:= V_MontantFacture+10;
ELSIF V_MontantFacture>=50 AND V_MontantFacture<100
THEN V_FraisLivraison:= V_MontantFacture+4;
ELSIF V_MontantFacture>=100
THEN V_FraisLivraison:= V_MontantFacture+0;
END IF;
RETURN V_FraisLivraison;

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END fn_FraisLivraison;