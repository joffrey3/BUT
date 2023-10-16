--Exercice 2 :

--Faire dans un terminal :

SELECT * FROM EMP WHERE job='CLERK';

/*
     EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- --------- ---------- -------- ---------- ---------- ----------
      7369 SMITH      CLERK           7902 17/12/80        800                    20
      7876 ADAMS      CLERK           7788 12/01/83       1100                    20
      7900 JAMES      CLERK           7698 03/12/81        950                    30
      7934 MILLER     CLERK           7782 23/01/82       1300                    10
      
*/

--Les informations sont :
/*
Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     4 |   148 |     6   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     4 |   148 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='CLERK')


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 23  consistent gets
	  0  physical reads
	  0  redo size
	838  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  4  rows processed
*/
--il n'y a que 4 lignes  et deux opérations cela fait 15 appels récursifs et 23 consistent gets
/*
Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     4 |   148 |     6   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     4 |   148 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='CLERK')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	 19  consistent gets
	  0  physical reads
	  0  redo size
	838  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  4  rows processed
*/
--il n'y a toujours que 4 lignes  et deux opérations cela fait 0 appels récursifs et 19 consistent gets. La commande est dans le cache