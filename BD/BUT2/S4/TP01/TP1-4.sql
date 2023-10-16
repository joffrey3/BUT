--Exercice 4 :

--Faire dans un terminal :

CREATE INDEX ix_job ON EMP(JOB) ;

EXEC DBMS_STATS.GATHER_INDEX_STATS(USER,'ix_job');

SELECT * FROM EMP WHERE JOB='CLERK';

/*
     EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- --------- ---------- -------- ---------- ---------- ----------
      7369 SMITH      CLERK           7902 17/12/80        800                    20
      7876 ADAMS      CLERK           7788 12/01/83       1100                    20
      7900 JAMES      CLERK           7698 03/12/81        950                    30
      7934 MILLER     CLERK           7782 23/01/82       1300                    10
      
*/

/*
Execution Plan
----------------------------------------------------------
Plan hash value: 3709579207

--------------------------------------------------------------------------------------

| Id  | Operation		    | Name   | Rows  | Bytes | Cost (%CPU)| Time     |

--------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |	     |	   4 |	 148 |	   2   (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID| EMP    |	   4 |	 148 |	   2   (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | IX_JOB |	   4 |	     |	   1   (0)| 00:00:01 |

--------------------------------------------------------------------------------------
Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("JOB"='CLERK')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  4  consistent gets
	  0  physical reads
	  0  redo size
	838  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  4  rows processed
*/
--Il n'y a que 4 consistent gets et 0 db block gets pour 4 lignes

DROP INDEX ix_job;

CREATE INDEX ix_emp ON EMP(JOB,ENAME);

SELECT ENAME FROM EMP WHERE JOB='CLERK';

/*
ENAME     
----------
ADAMS
JAMES
MILLER
SMITH
*/

/*
Execution Plan
----------------------------------------------------------
Plan hash value: 4100896947

---------------------------------------------------------------------------
| Id  | Operation	 | Name   | Rows  | Bytes | Cost (%CPU)| Time	  |
---------------------------------------------------------------------------
|   0 | SELECT STATEMENT |	  |	4 |    56 |	1   (0)| 00:00:01 |
|*  1 |  INDEX RANGE SCAN| IX_EMP |	4 |    56 |	1   (0)| 00:00:01 |
---------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - access("JOB"='CLERK')


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	  6  consistent gets
	  0  physical reads
	  0  redo size
	389  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  4  rows processed

*/

--Il y a 15 appels récursifs et 6 consistent gets donc l'index est plus précis et plus dens il a besoin de plus d'opérations