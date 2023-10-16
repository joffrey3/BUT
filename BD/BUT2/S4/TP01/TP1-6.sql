--Exercice 6 :

--Faire dans un terminal :

SELECT * FROM EMP NATURAL JOIN DEPT;

/*
    DEPTNO      EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM DNAME          LOC          
---------- ---------- ---------- --------- ---------- -------- ---------- ---------- -------------- -------------
        20       7369 SMITH      CLERK           7902 17/12/80        800            RESEARCH       DALLAS       
        30       7499 ALLEN      SALESMAN        7698 20/02/81       1600        300 SALES          CHICAGO      
        30       7521 WARD       SALESMAN        7698 22/02/81       1250        500 SALES          CHICAGO      
        20       7566 JONES      MANAGER         7839 02/04/81       2975            RESEARCH       DALLAS       
        30       7654 MARTIN     SALESMAN        7698 28/09/81       1250       1400 SALES          CHICAGO      
        30       7698 BLAKE      MANAGER         7839 01/05/81       2850            SALES          CHICAGO      
        10       7782 CLARK      MANAGER         7839 09/06/81       2450            ACCOUNTING     NEW YORK     
        20       7788 SCOTT      ANALYST         7566 09/12/82       3000            RESEARCH       DALLAS       
        10       7839 KING       PRESIDENT            17/11/81       5000            ACCOUNTING     NEW YORK     
        30       7844 TURNER     SALESMAN        7698 08/09/81       1500         10 SALES          CHICAGO      
        20       7876 ADAMS      CLERK           7788 12/01/83       1100            RESEARCH       DALLAS       

    DEPTNO      EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM DNAME          LOC          
---------- ---------- ---------- --------- ---------- -------- ---------- ---------- -------------- -------------
        30       7900 JAMES      CLERK           7698 03/12/81        950            SALES          CHICAGO      
        20       7902 FORD       ANALYST         7566 03/12/81       3000            RESEARCH       DALLAS       
        10       7934 MILLER     CLERK           7782 23/01/82       1300            ACCOUNTING     NEW YORK    
*/
/*
Execution Plan
----------------------------------------------------------
Plan hash value: 4258209286

---------------------------------------------------------------------------------------------

| Id  | Operation		     | Name	    | Rows  | Bytes | Cost (%CPU)| Time     |

---------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   1 |  NESTED LOOPS		     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   2 |   TABLE ACCESS FULL	     | EMP	    |	 14 |	518 |	  6   (0)| 00:00:01 |

|   3 |   TABLE ACCESS BY INDEX ROWID| DEPT	    |	  1 |	 20 |	  1   (0)| 00:00:01 |

|*  4 |    INDEX UNIQUE SCAN	     | SYS_C0070408 |	  1 |	    |	  0   (0)| 00:00:01 |

---------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("EMP"."DEPTNO"="DEPT"."DEPTNO")


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 39  consistent gets
	  0  physical reads
	  0  redo size
       1558  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 14  rows processed

*/

--Il y a 15 appels récursifs et 39 consistent gets pour 14 lignes la méthode utilisés est le nested loops

SELECT /*+USE_NL(emp dept)*/ * FROM EMP NATURAL JOIN DEPT;

/*
Execution Plan
----------------------------------------------------------
Plan hash value: 4258209286

---------------------------------------------------------------------------------------------

| Id  | Operation		     | Name	    | Rows  | Bytes | Cost (%CPU)| Time     |

---------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   1 |  NESTED LOOPS		     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   2 |   TABLE ACCESS FULL	     | EMP	    |	 14 |	518 |	  6   (0)| 00:00:01 |

|   3 |   TABLE ACCESS BY INDEX ROWID| DEPT	    |	  1 |	 20 |	  1   (0)| 00:00:01 |

|*  4 |    INDEX UNIQUE SCAN	     | SYS_C0070408 |	  1 |	    |	  0   (0)| 00:00:01 |

---------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("EMP"."DEPTNO"="DEPT"."DEPTNO")


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 39  consistent gets
	  0  physical reads
	  0  redo size
       1558  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 14  rows processed
*/
--15 recursifs calls et 39 consistent gets 4 étapes

SELECT /*+USE_MERGE(emp dept)*/ * FROM EMP NATURAL JOIN DEPT;

/*
Execution Plan
----------------------------------------------------------
Plan hash value: 3936002721

---------------------------------------------------------------------------------------------

| Id  | Operation		     | Name	    | Rows  | Bytes | Cost (%CPU)| Time     |

---------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	     |		    |	 14 |	798 |	  9  (12)| 00:00:01 |

|   1 |  MERGE JOIN		     |		    |	 14 |	798 |	  9  (12)| 00:00:01 |

|   2 |   TABLE ACCESS BY INDEX ROWID| DEPT	    |	  4 |	 80 |	  2   (0)| 00:00:01 |

|   3 |    INDEX FULL SCAN	     | SYS_C0070408 |	  4 |	    |	  1   (0)| 00:00:01 |

|*  4 |   SORT JOIN		     |		    |	 14 |	518 |	  7  (15)| 00:00:01 |

|   5 |    TABLE ACCESS FULL	     | EMP	    |	 14 |	518 |	  6   (0)| 00:00:01 |

---------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("EMP"."DEPTNO"="DEPT"."DEPTNO")
       filter("EMP"."DEPTNO"="DEPT"."DEPTNO")


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 26  consistent gets
	  0  physical reads
	  0  redo size
       1413  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  1  sorts (memory)
	  0  sorts (disk)
	 14  rows processed
*/
--15 recursive calls , 26 consisten gets , 5 étapes

--La meilleure option est le merge

CREATE INDEX ix_dept ON EMP (DEPTNO, ENAME) ;

/*
Execution Plan
----------------------------------------------------------
Plan hash value: 4258209286

---------------------------------------------------------------------------------------------

| Id  | Operation		     | Name	    | Rows  | Bytes | Cost (%CPU)| Time     |

---------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   1 |  NESTED LOOPS		     |		    |	 14 |	798 |	  7   (0)| 00:00:01 |

|   2 |   TABLE ACCESS FULL	     | EMP	    |	 14 |	518 |	  6   (0)| 00:00:01 |

|   3 |   TABLE ACCESS BY INDEX ROWID| DEPT	    |	  1 |	 20 |	  1   (0)| 00:00:01 |

|*  4 |    INDEX UNIQUE SCAN	     | SYS_C0070408 |	  1 |	    |	  0   (0)| 00:00:01 |

---------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("EMP"."DEPTNO"="DEPT"."DEPTNO")


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 39  consistent gets
	  0  physical reads
	  0  redo size
       1558  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 14  rows processed
*/
--15 recursifs calls 39 consistent gets et 4 étapes 

SELECT /*+USE_MERGE(emp dept)*/ * FROM EMP NATURAL JOIN DEPT;

/*

Execution Plan
----------------------------------------------------------
Plan hash value: 3936002721

---------------------------------------------------------------------------------------------

| Id  | Operation		     | Name	    | Rows  | Bytes | Cost (%CPU)| Time     |

---------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	     |		    |	 14 |	798 |	  9  (12)| 00:00:01 |

|   1 |  MERGE JOIN		     |		    |	 14 |	798 |	  9  (12)| 00:00:01 |

|   2 |   TABLE ACCESS BY INDEX ROWID| DEPT	    |	  4 |	 80 |	  2   (0)| 00:00:01 |

|   3 |    INDEX FULL SCAN	     | SYS_C0070408 |	  4 |	    |	  1   (0)| 00:00:01 |

|*  4 |   SORT JOIN		     |		    |	 14 |	518 |	  7  (1)| 00:00:01 |

|   5 |    TABLE ACCESS FULL	     | EMP	    |	 14 |	518 |	  6   (0)| 00:00:01 |

---------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("EMP"."DEPTNO"="DEPT"."DEPTNO")
       filter("EMP"."DEPTNO"="DEPT"."DEPTNO")


Statistics
----------------------------------------------------------
	 15  recursive calls
	  0  db block gets
	 26  consistent gets
	  0  physical reads
	  0  redo size
    1413  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  1  sorts (memory)
	  0  sorts (disk)
	 14  rows processed
*/
--15 recursif call 26 consistent gets et 4 étapes