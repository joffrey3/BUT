--TP2 :

--Exercice 1 :

--On cherche ?? optimiser la requ??te
set autotrace on;
--La 1??re fois
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    87 |     6   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    87 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	168  recursive calls
	  0  db block gets
	 69  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

--La 2??me fois
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    87 |     6   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    87 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	 22  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/
--Si on cr???? deux index
CREATE INDEX index_job ON EMP(JOB);
CREATE INDEX index_deptno ON EMP(DEPTNO);
--Index created.
--Index created.

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2285283441

-----------------------------------------------------------------------------------------

| Id  | Operation		    | Name	| Rows	| Bytes | Cost (%CPU)| Time	|

-----------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		|     1 |    87 |     1   (0)| 00:00:01 |

|*  1 |  TABLE ACCESS BY INDEX ROWID| EMP	|     1 |    87 |     1   (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB |     1 |	|     1   (0)| 00:00:01 |

-----------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("DEPTNO"=20)
   2 - access("JOB"='Clerk')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	 26  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed

*/

--2??me tentative
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2285283441

--------------------------------------------------------------------------------
---------

| Id  | Operation		    | Name	| Rows	| Bytes | Cost (%CPU)| T
ime	|

--------------------------------------------------------------------------------
---------

|   0 | SELECT STATEMENT	    |		|     1 |    87 |     1   (0)| 0
0:00:01 |

|*  1 |  TABLE ACCESS BY INDEX ROWID| EMP	|     1 |    87 |     1   (0)| 0
0:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB |     1 |	|     1   (0)| 0
0:00:01 |

--------------------------------------------------------------------------------
---------


Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("DEPTNO"=20)
   2 - access("JOB"='Clerk')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  1  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

CREATE INDEX index_job_deptno ON EMP(JOB,DEPTNO);
--Index created.

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2846612990

------------------------------------------------------------------------------------------------

| Id  | Operation		    | Name	       | Rows  | Bytes | Cost (%CPU)| Time     |

------------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		       |     1 |    87 |     1 (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID| EMP	       |     1 |    87 |     1 (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB_DEPTNO |     1 |       |     1 (0)| 00:00:01 |

------------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	 27  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

--2??me tentative

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2846612990

------------------------------------------------------------------------------------------------

| Id  | Operation		    | Name	       | Rows  | Bytes | Cost (%CPU)| Time     |

------------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		       |     1 |    87 |     1 (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID| EMP	       |     1 |    87 |     1 (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB_DEPTNO |     1 |       |     1 (0)| 00:00:01 |

------------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  1  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

--Executer la commande 10 fois
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
INSERT INTO EMP SELECT * FROM EMP;
COMMIT;
/*
14 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |    28 |  2436 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |    28 |  2436 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	 12  db block gets
	 46  consistent gets
	  1  physical reads
       3216  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 14  rows processed

28 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |    56 |  4872 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |    56 |  4872 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	 17  db block gets
	 25  consistent gets
	  0  physical reads
       5840  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 28  rows processed

56 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |   112 |  9744 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |   112 |  9744 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	173  db block gets
	 47  consistent gets
	  6  physical reads
      30720  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	 56  rows processed

112 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |   224 | 19488 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |   224 | 19488 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	503  db block gets
	 58  consistent gets
	  3  physical reads
      85228  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	112  rows processed

224 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |   448 | 38976 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |   448 | 38976 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
       1198  db block gets
	 83  consistent gets
	  0  physical reads
     195988  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	224  rows processed

448 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |   896 | 77952 |     6   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |   896 | 77952 |     6   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
       2770  db block gets
	127  consistent gets
	  0  physical reads
     423676  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	448  rows processed

896 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |  1792 |   152K|    11   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |  1792 |   152K|    11   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	144  recursive calls
       5800  db block gets
	288  consistent gets
	  0  physical reads
     840332  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	896  rows processed

1792 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |  3341 |   283K|    21   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |  3341 |   283K|    21   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	201  recursive calls
      11496  db block gets
	619  consistent gets
	  0  physical reads
    1709436  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
       1792  rows processed

3584 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 |  7538 |   640K|    36   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  |  7538 |   640K|    36   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	450  recursive calls
      26195  db block gets
       1241  consistent gets
	  0  physical reads
    3435676  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
       3584  rows processed

7168 rows created.


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | INSERT STATEMENT  |	 | 13439 |  1141K|    61   (0)| 00:00:01 |
|   1 |  TABLE ACCESS FULL| EMP  | 13439 |  1141K|    61   (0)| 00:00:01 |
--------------------------------------------------------------------------

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	834  recursive calls
      61499  db block gets
       2378  consistent gets
	  0  physical reads
    6976524  redo size
	115  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
       7168  rows processed

*/
DROP INDEX index_job;
DROP INDEX index_deptno;
DROP INDEX index_job_deptno;

--Index dropped.
--Index dropped.
--Index dropped.

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    87 |    61   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    87 |    61   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	 68  recursive calls
	  0  db block gets
	444  consistent gets
	  0  physical reads
	216  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  2  sorts (memory)
	  0  sorts (disk)
	  0  rows processed

*/

--2??me tentative

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 3956160932

--------------------------------------------------------------------------
| Id  | Operation	  | Name | Rows  | Bytes | Cost (%CPU)| Time	 |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |	 |     1 |    87 |    61   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     1 |    87 |    61   (0)| 00:00:01 |
--------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("JOB"='Clerk' AND "DEPTNO"=20)

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
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/
CREATE INDEX index_job ON EMP(JOB);
CREATE INDEX index_deptno ON EMP(DEPTNO);
--Index created.
--Index created.

SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2285283441

-----------------------------------------------------------------------------------------

| Id  | Operation		    | Name	| Rows	| Bytes | Cost (%CPU)| Time	|

-----------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		|     1 |    87 |     4   (0)| 00:00:01 |

|*  1 |  TABLE ACCESS BY INDEX ROWID| EMP	|     1 |    87 |     4   (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB |     4 |	|     3   (0)| 00:00:01 |

-----------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("DEPTNO"=20)
   2 - access("JOB"='Clerk')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	 69  consistent gets
	  2  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed

*/

--2??me tentative
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2285283441

-----------------------------------------------------------------------------------------

| Id  | Operation		    | Name	| Rows	| Bytes | Cost (%CPU)| Time	|

-----------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		|     1 |    87 |     4   (0)| 00:00:01 |

|*  1 |  TABLE ACCESS BY INDEX ROWID| EMP	|     1 |    87 |     4   (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB |     4 |	|     3   (0)| 00:00:01 |

-----------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("DEPTNO"=20)
   2 - access("JOB"='Clerk')

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  3  consistent gets
	  0  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

CREATE INDEX index_job_deptno ON EMP(JOB,DEPTNO);
--Index created.
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;
/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2846612990

------------------------------------------------------------------------------------------------

| Id  | Operation		    | Name	       | Rows  | Bytes | Cost (%CPU)| Time     |

------------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |		       |     1 |    87 |     4 (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID| EMP	       |     1 |    87 |     4 (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB_DEPTNO |     1 |       |     3 (0)| 00:00:01 |

------------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  5  recursive calls
	  0  db block gets
	 70  consistent gets
	  2  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/

--2??me tentative
SELECT * FROM EMP WHERE JOB='Clerk' and DEPTNO=20;

/*
no rows selected


Execution Plan
----------------------------------------------------------
Plan hash value: 2846612990

--------------------------------------------------------------------------------
----------------

| Id  | Operation		    | Name	       | Rows  | Bytes | Cost (%
CPU)| Time     |

--------------------------------------------------------------------------------
----------------

|   0 | SELECT STATEMENT	    |		       |     1 |    87 |     4
 (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID| EMP	       |     1 |    87 |     4
 (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN	    | INDEX_JOB_DEPTNO |     1 |       |     3
 (0)| 00:00:01 |

--------------------------------------------------------------------------------
----------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("JOB"='Clerk' AND "DEPTNO"=20)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  3  consistent gets
	  2  physical reads
	  0  redo size
	594  bytes sent via SQL*Net to client
	 30  bytes received via SQL*Net from client
	  1  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  0  rows processed
*/