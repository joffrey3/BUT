--EXECUTE sp_InsertCommandeLigne(123,1,'Produit0',10);
--CALL sp_InsertCommandeLigne(124,1,'Produit0',10);

BEGIN

DELETE FROM COMMANDE_LIGNE WHERE id =122;
sp_InsertCommandeLigne(122,1,'Produit0',10);

END;