CREATE OR REPLACE PROCEDURE sp_DetermineProduitEnPromo(P_WhereClause VARCHAR2, p_promo out NUMBER)
IS

BEGIN
UPDATE Produit SET en_promotion = 0;
EXECUTE IMMEDIATE 
    'UPDATE Produit SET  en_promotion = 1 WHERE ' || P_WhereClause;
SELECT COUNT(en_promotion)INTO p_promo FROM Produit WHERE en_promotion=1;

END sp_DetermineProduitEnPromo;