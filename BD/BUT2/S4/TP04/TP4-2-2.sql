--TP4 :

--Exercice 2 :

--Session 2 :

--2.1 :

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
A	       1
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
A	       2
*/

--2.2 :

UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='B';
/*
1 row updated.
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       0
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='B';
/*
NOM	  VALEUR
----- ----------
B	       1
*/
COMMIT;
/*
Commit complete.
*/
UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='A';
/*
ERROR at line 1:
ORA-00060: deadlock detected while waiting for resource


1 row updated.
*/
COMMIT;
/*
Commit complete.
*/

--2.3 :

UPDATE DonneesFouche SET valeur = valeur+1 WHERE nom='C';
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
SELECT nom, valeur FROM DonneesFouche WHERE nom='A';
/*
NOM	  VALEUR
----- ----------
A	       2
*/
SELECT nom, valeur FROM DonneesFouche WHERE nom='C';
/*
NOM	  VALEUR
----- ----------
C	       1
*/
COMMIT;
/*
Commit complete.
*/