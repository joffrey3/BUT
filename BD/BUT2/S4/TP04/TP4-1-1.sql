--TP4 :

--Exercice 1 :

--Session 1 :

SELECT DISTINCT sid FROM v$mystat;
/*
       SID
----------
	11

*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
COMMIT;
/*
Commit complete.
*/