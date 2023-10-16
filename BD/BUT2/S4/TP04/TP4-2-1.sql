--TP4 :

--Exercice 2 :

--Session 1 :

--2.1 :

UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
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

--2.2 :

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
SELECT nom, valeur FROM DonneesFouche WHERE nom='B';
/*
NOM	  VALEUR
----- ----------
B	       0
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='B';
/*
1 row updated.
*/
COMMIT;
/*
Commit complete.
*/

--2.3 :

SELECT * FROM DonneesFouche WHERE nom ='A' FOR UPDATE;
/*
NOM	  VALEUR
----- ----------
A	       0
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
1 row updated.
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