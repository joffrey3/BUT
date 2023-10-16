--TP2 :

--Exercice 2 :
DROP INDEX index_job;
DROP INDEX index_deptno;
DROP INDEX index_job_deptno;
--Index dropped.
--Index dropped.
--Index dropped.
SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;

/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	186  recursive calls
	  0  db block gets
	452  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  4  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
--2??me tentative
SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;

/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	362  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

CREATE INDEX index_deptno ON EMP(DEPTNO);
CREATE INDEX index_job ON EMP(JOB);
--Index created.
--Index created.

SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;

/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	428  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed

*/

--2?me tentative
SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;

/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	362  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

CREATE INDEX index_job_deptno ON EMP(JOB,DEPTNO);
--Index created.

SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	429  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

--2?me tentative
SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;

/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	362  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

CREATE INDEX index_empno ON EMP(EMPNO);
--Index created.

SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	429  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
--2?me tentative
SELECT deptno, SUM(sal)FROM EMP WHERE deptno = 30 AND job = 'SALESMAN' GROUP BY deptno;
/*
    DEPTNO   SUM(SAL)
---------- ----------
	30    5734400


Execution Plan
----------------------------------------------------------
Plan hash value: 2854459865

-----------------------------------------------------------------------------
| Id  | Operation	     | Name | Rows  | Bytes | Cost (%CPU)| Time     |
-----------------------------------------------------------------------------
|   0 | SELECT STATEMENT     |	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|   1 |  SORT GROUP BY NOSORT|	    |  3836 |	119K|	 61   (0)| 00:00:01 |
|*  2 |   TABLE ACCESS FULL  | EMP  |  3836 |	119K|	 61   (0)| 00:00:01 |
-----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("DEPTNO"=30 AND "JOB"='SALESMAN')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	362  consistent gets
	  0  physical reads
	  0  redo size
	392  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
      
*/
