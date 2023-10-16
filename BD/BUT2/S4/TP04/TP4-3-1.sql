--TP4 :

--Exercice 3 :

--Session 1 :

--3.1 :
SET TRANSACTION READ ONLY;
/*
Transaction set.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
COMMIT;
/*
Commit complete.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       2
*/

--3.2 :

SET TRANSACTION READ ONLY;
/*
Transaction set.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
COMMIT;
/*
Commit complete.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       1
*/

--3.3 :

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
/*
Transaction set.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
COMMIT;
/*
Commit complete.
*/