--TP2 :

--Exercice 3 :

DROP INDEX index_job;
DROP INDEX index_deptno;
DROP INDEX index_job_deptno;
--Index dropped.
--Index dropped.
--Index dropped.

SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	 20  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

--2?me tentative
SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

CREATE INDEX index_job ON EMP (JOB);
CREATE INDEX index_deptno ON EMP (DEPTNO);
--Index created.
--Index created.

SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

--2?me tentative
SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/


CREATE INDEX index_job_deptno ON EMP (JOB,DEPTNO);
--Index created.

SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

--2?me tentative
SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

CREATE INDEX index_deptno_job ON EMP (DEPTNO,JOB);
--Index created.

SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/

--2?me tentative
SELECT deptno, SUM(sal) FROM EMP WHERE deptno IN (SELECT deptno FROM DEPT WHERE loc = 'DALLAS' or loc = 'CHICAGO') GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    9625600
	20   11136000


Execution Plan
----------------------------------------------------------
Plan hash value: 1353120811

------------------------------------------------------------------------------
| Id  | Operation	      | Name | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------
|   0 | SELECT STATEMENT      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|   1 |  HASH GROUP BY	      |      |	   3 |	  54 |	  69   (3)| 00:00:01 |
|*  2 |   HASH JOIN RIGHT SEMI|      |	9557 |	 167K|	  68   (2)| 00:00:01 |
|*  3 |    TABLE ACCESS FULL  | DEPT |	   2 |	  22 |	   6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL  | EMP  | 14336 |	  98K|	  61   (0)| 00:00:01 |
------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DEPTNO"="DEPTNO")
   3 - filter("LOC"='CHICAGO' OR "LOC"='DALLAS')


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	425  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  2  rows processed
*/