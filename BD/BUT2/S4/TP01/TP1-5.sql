--Exercice 5 :

--Faire dans un terminal :
CREATE INDEX ix_sal ON EMP(SAL,ENAME);

SELECT ENAME FROM EMP WHERE sal>3000;

/*
ENAME     
----------
KING
*/
/*
Execution Plan
----------------------------------------------------------
Plan hash value: 537267953

---------------------------------------------------------------------------
| Id  | Operation	 | Name   | Rows  | Bytes | Cost (%CPU)| Time	  |
---------------------------------------------------------------------------
|   0 | SELECT STATEMENT |	  |	7 |    70 |	1   (0)| 00:00:01 |
|*  1 |  INDEX RANGE SCAN| IX_SAL |	7 |    70 |	1   (0)| 00:00:01 |
---------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - access("SAL">3000 AND "SAL" IS NOT NULL)


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  1  consistent gets
	  0  physical reads
	  0  redo size
	334  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed

*/
--L'index est créé sur le salaire et le nom de l'employé donc on peut récupérer directement les salaires supérieurs à 3000. Il n'y a qu'une seule ligne et donc 1 consistent gets
--Il n'y a qu'une seule étape

SELECT ENAME FROM EMP WHERE sal/2>1500;
 
/*
 ENAME     
----------
KING
*/
/*
Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    10 |     6   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    10 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("SAL"/2>1500)


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 23  consistent gets
	  0  physical reads
	  0  redo size
	334  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed

*/
--Il n'y a qu'une étape également
--Cependant il y a 15 appels récursifs et 23 consistent gets donc le programme prend 23 lignes avec les index pour le salaire à 1500 puis il fait 15 appels récursifs pour réduire le nombre de lignes à 1

