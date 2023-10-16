--TP4 :

--Exercice 1 :

--Session 2 :

SELECT DISTINCT sid FROM v$mystat;

/*
       SID
----------
	14
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
COMMIT;
/*
Commit complete.
*/