--TP2 :

--Exercice 4 :

SELECT deptno FROM dept WHERE deptno NOT IN (SELECT deptno FROM emp);
/*
    DEPTNO
----------
	40


Execution Plan
----------------------------------------------------------
Plan hash value: 3547749009

---------------------------------------------------------------------------
| Id  | Operation	   | Name | Rows  | Bytes | Cost (%CPU)| Time	  |
---------------------------------------------------------------------------
|   0 | SELECT STATEMENT   |	  |	3 |	9 |    10   (0)| 00:00:01 |
|*  1 |  FILTER 	   |	  |	  |	  |	       |	  |
|   2 |   TABLE ACCESS FULL| DEPT |	4 |    12 |	6   (0)| 00:00:01 |
|*  3 |   TABLE ACCESS FULL| EMP  |	2 |	6 |	2   (0)| 00:00:01 |
---------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter( NOT EXISTS (SELECT *//*+ *//* 0 FROM "EMP" "EMP" WHERE
	      LNNVL("DEPTNO"<>:B1)))
   3 - filter(LNNVL("DEPTNO"<>:B1))


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	396  consistent gets
	  0  physical reads
	  0  redo size
	333  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
SELECT deptno FROM dept d WHERE NOT EXISTS(SELECT deptno FROM emp WHERE deptno=d.deptno);

/*
    DEPTNO
----------
	40


Execution Plan
----------------------------------------------------------
Plan hash value: 3554693509

-----------------------------------------------------------------------------------

| Id  | Operation	   | Name	  | Rows  | Bytes | Cost (%CPU)| Time  |

-----------------------------------------------------------------------------------

|   0 | SELECT STATEMENT   |		  |	1 |	6 |    14   (0)| 00:00:01 |

|   1 |  NESTED LOOPS ANTI |		  |	1 |	6 |    14   (0)| 00:00:01 |

|   2 |   TABLE ACCESS FULL| DEPT	  |	4 |    12 |	6   (0)| 00:00:01 |

|*  3 |   INDEX RANGE SCAN | INDEX_DEPTNO |  9557 | 28671 |	2   (0)| 00:00:01 |

-----------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   3 - access("DEPTNO"="D"."DEPTNO")


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	 32  consistent gets
	  6  physical reads
	  0  redo size
	333  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
SELECT d.deptno FROM dept d LEFT OUTER JOIN emp e ON d.deptno=e.deptno WHERE ename IS NULL;
/*

    DEPTNO
----------
	40


Execution Plan
----------------------------------------------------------
Plan hash value: 2146709594

----------------------------------------------------------------------------
| Id  | Operation	    | Name | Rows  | Bytes | Cost (%CPU)| Time	   |
----------------------------------------------------------------------------
|   0 | SELECT STATEMENT    |	   | 14336 |   168K|	68   (2)| 00:00:01 |
|*  1 |  FILTER 	    |	   |	   |	   |		|	   |
|*  2 |   HASH JOIN OUTER   |	   | 14336 |   168K|	68   (2)| 00:00:01 |
|   3 |    TABLE ACCESS FULL| DEPT |	 4 |	12 |	 6   (0)| 00:00:01 |
|   4 |    TABLE ACCESS FULL| EMP  | 14336 |   126K|	61   (0)| 00:00:01 |
----------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("E"."ENAME" IS NULL)
   2 - access("D"."DEPTNO"="E"."DEPTNO"(+))


Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	333  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
(SELECT deptno FROM dept)MINUS(SELECT deptno FROM emp);
/*
    DEPTNO
----------
	40


Execution Plan
----------------------------------------------------------
Plan hash value: 545445780

------------------------------------------------------------------------------------

| Id  | Operation	    | Name | Rows  | Bytes |TempSpc| Cost (%CPU)| Time   |

------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT    |	   |	 4 | 43020 |	   |   186  (97)| 00:00:02 |

|   1 |  MINUS		    |	   |	   |	   |	   |		|   |

|   2 |   SORT UNIQUE	    |	   |	 4 |	12 |	   |	 7  (15)| 00:00:01 |

|   3 |    TABLE ACCESS FULL| DEPT |	 4 |	12 |	   |	 6   (0)| 00:00:01 |

|   4 |   SORT UNIQUE	    |	   | 14336 | 43008 |   346K|   179   (2)| 00:00:02 |

|   5 |    TABLE ACCESS FULL| EMP  | 14336 | 43008 |	   |	61   (0)| 00:00:01 |

------------------------------------------------------------------------------------



Statistics
----------------------------------------------------------
	  1  recursive calls
	  0  db block gets
	384  consistent gets
	  0  physical reads
	  0  redo size
	333  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  2  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

--ils ont tous un recursive calls , celui qui a le moins de consistant get c'est la solution avec NOT EXISTS cependant il a des physicals reads que les autres n'ont pas

--On peut pour optimiser la requ?te rajouter des index ad?quats  ou cr?er une vue sur les deux tables.