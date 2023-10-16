--TP4 :

--Exercice 3 :

SELECT * FROM DonneesFouche;
/*
A	2
B	0
C	1
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

--t1 une valeur de A
--t2 et t3 deux valeurs de A
--t4 une valeur de A
--il faut plusieurs valeurs une pour chaque read only et une pour la personne qui modifie.

SELECT * FROM DonneesFouche;
/*
A	2
B	0
C	0
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

--Les valeur de t1 et de t2 sont diff?rentes car le read only a ?t? fait avant le commit et c'est ? ce moment la que tous est fig?.

SELECT * FROM DonneesFouche;
/*
A	1
B	0
C	0
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

SELECT * FROM DonneesFouche;
UPDATE DonneesFouche SET valeur =0;
COMMIT;