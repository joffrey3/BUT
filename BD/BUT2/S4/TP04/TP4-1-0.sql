--TP4

--Exercice 1 :

--On cr??er la table

CREATE TABLE DonneesFouche(nom VARCHAR2(5), valeur NUMBER);
/*
Table DONNEESFOUCHE cr????(e).
*/
--On ins??re les donn??es

INSERT INTO DonneesFouche VALUES('A',0);
INSERT INTO DonneesFouche VALUES('B',0);
INSERT INTO DonneesFouche VALUES('C',0);
/*
1 ligne ins??r??.
1 ligne ins??r??.
1 ligne ins??r??.
*/
COMMIT;
--1.1

SELECT DISTINCT sid FROM v$mystat;

/*

       SID
----------
        37
*/

--1.2
--On voit qu'on a deux sessions qui tournent id 11 et 14

--1.3
--Il veulent tous les deux un mode exclusif donc la deuxi?me session est en attente
--Oui on peut li? la waiting session avec le mode requested et la holding session avec le mode held
--On peut d?bloquer la situation en faisant des commit