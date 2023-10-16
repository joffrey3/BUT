--TP4 :

--Exercice 3 :

--Session 2 :

--3.1 :
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
COMMIT;
/*
Commit complete.
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       2
*/
COMMIT;
/*
Commit complete.
*/

--3.2 :

UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       1
*/
COMMIT;
/*
Commit complete.
*/

--3.3 :
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
/*
Transaction set.
*/
COMMIT;
/*
Commit complete.
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
COMMIT;
/*
Commit complete.
*/