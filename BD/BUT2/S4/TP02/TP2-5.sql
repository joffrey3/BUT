--TP 2 :

--Exercice 5 :

--Creation de la table
CREATE TABLE BIGBITMAP (id INT,nbitmap INT,date_insertion DATE);

SET TIMING ON;

CREATE INDEX indexNbitmapBtree ON BIGBITMAP(nbitmap);
/*
Index created.

Elapsed: 00:00:01.03
*/

SELECT COUNT(*) FROM bigbitmap WHERE nbitmap = 0 ;

/*
 COUNT(*)
----------
     60000

Elapsed: 00:00:00.08

Execution Plan
----------------------------------------------------------
Plan hash value: 605128047

-------------------------------------------------------------------------------------------

| Id  | Operation	      | Name		  | Rows  | Bytes | Cost (%CPU)| Time	  |

-------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT      | 		  |	1 |    13 |   442   (1)| 00:00:05 |

|   1 |  SORT AGGREGATE       | 		  |	1 |    13 |	       |	  |

|*  2 |   INDEX FAST FULL SCAN| INDEXNBITMAPBTREE | 59578 |   756K|   442   (1)| 00:00:05 |

-------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("NBITMAP"=0)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	 32  recursive calls
	  0  db block gets
       2652  consistent gets
       2549  physical reads
	  0  redo size
	335  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

SELECT SUM(id) FROM bigbitmap WHERE nbitmap = 0 ;

/*
   SUM(ID)
----------
3000150000

Elapsed: 00:00:00.04

Execution Plan
----------------------------------------------------------
Plan hash value: 779161200

--------------------------------------------------------------------------------
| Id  | Operation	   | Name      | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------------
|   0 | SELECT STATEMENT   |	       |     1 |    26 |   609	 (1)| 00:00:07 |
|   1 |  SORT AGGREGATE    |	       |     1 |    26 |	    |	       |
|*  2 |   TABLE ACCESS FULL| BIGBITMAP | 59578 |  1512K|   609	 (1)| 00:00:07 |
--------------------------------------------------------------------------------

Predicate Information (identified by operation id):
---------------------------------------------------

   2 - filter("NBITMAP"=0)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	 30  recursive calls
	  0  db block gets
       3722  consistent gets
	524  physical reads
	  0  redo size
	336  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
DROP INDEX  indexNbitmapBtree;
/*
Index dropped.

Elapsed: 00:00:00.02
*/
CREATE BITMAP INDEX indexNbitmapBitmap ON BIGBITMAP(nbitmap);
/*
Index created.

Elapsed: 00:00:00.13
*/
SELECT COUNT(*) FROM bigbitmap WHERE nbitmap = 0 ;
/*
  COUNT(*)
----------
     60000

Elapsed: 00:00:00.01

Execution Plan
----------------------------------------------------------
Plan hash value: 521077604

--------------------------------------------------------------------------------------------------

| Id  | Operation		    | Name		 | Rows  | Bytes | Cost(%CPU)| Time	 |

--------------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	    |			 |     1 |    13 |    39   (0)| 00:00:01 |

|   1 |  SORT AGGREGATE 	    |			 |     1 |    13 |      | 	 |

|   2 |   BITMAP CONVERSION COUNT   |			 | 59578 |   756K|    39   (0)| 00:00:01 |

|*  3 |    BITMAP INDEX SINGLE VALUE| INDEXNBITMAPBITMAP |	 |	 |      | 	 |

--------------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   3 - access("NBITMAP"=0)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	 40  recursive calls
	  0  db block gets
	112  consistent gets
	 34  physical reads
	  0  redo size
	335  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/
SELECT SUM(id) FROM bigbitmap WHERE nbitmap = 0 ;
/*
   SUM(ID)
----------
3000150000

Elapsed: 00:00:00.03

Execution Plan
----------------------------------------------------------
Plan hash value: 2226662327

----------------------------------------------------------------------------------------------------

| Id  | Operation		      | Name		   | Rows  | Bytes | Cost (%CPU)| Time	   |

----------------------------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	      | 		   |	 1 |	26 |   477   (0)| 00:00:06 |

|   1 |  SORT AGGREGATE 	      | 		   |	 1 |	26 |	|	   |

|   2 |   TABLE ACCESS BY INDEX ROWID | BIGBITMAP	   | 59578 |  1512K|   477   (0)| 00:00:06 |

|   3 |    BITMAP CONVERSION TO ROWIDS| 		   |	   |	   |	|	   |

|*  4 |     BITMAP INDEX SINGLE VALUE | INDEXNBITMAPBITMAP |	   |	   |	|	   |

----------------------------------------------------------------------------------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   4 - access("NBITMAP"=0)

Note
-----
   - dynamic sampling used for this statement


Statistics
----------------------------------------------------------
	  7  recursive calls
	  0  db block gets
       3706  consistent gets
	  0  physical reads
	  0  redo size
	336  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/