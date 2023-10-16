CREATE OR REPLACE FUNCTION fn_PointsFidelite(p_client_id VARCHAR2)
RETURN INT IS

V_Depenses INT;

BEGIN

SELECT SUM(fn_FraisLivraison(id)) INTO V_Depenses FROM Commande WHERE client_id=p_client_id;
RETURN  V_Depenses;

EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('ERREUR');

END  fn_PointsFidelite;