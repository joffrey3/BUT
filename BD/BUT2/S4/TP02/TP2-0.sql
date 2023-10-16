--TP2 :

-- Avant de faire l'exercice 1 :

DROP TABLE DEPT;
DROP TABLE EMP;

--executer le fichier TpBuild.sql

SELECT index_name FROM user_indexes WHERE table_name = 'EMP' AND index_name NOT LIKE 'SYS%' ;
--On supprime tous les index de ces tables (il n'y en a pas)

DROP INDEX i ;
