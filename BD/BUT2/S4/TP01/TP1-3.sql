--Exercice 3 :

--Faire en terminal : 

SELECT JOB, DBMS_ROWID.ROWID_RELATIVE_FNO(rowid) FICHIER, DBMS_ROWID.ROWID_BLOCK_NUMBER(rowid) BLOC, DBMS_ROWID.ROWID_ROW_NUMBER(rowid) NUMLIGNE FROM EMP;

/*
JOB	     FICHIER	   BLOC   NUMLIGNE
--------- ---------- ---------- ----------
CLERK		   8	 320073 	 0
SALESMAN	   8	 320073 	 1
SALESMAN	   8	 320073 	 2
MANAGER 	   8	 320073 	 3
SALESMAN	   8	 320073 	 4
MANAGER 	   8	 320073 	 5
MANAGER 	   8	 320073 	 6
ANALYST 	   8	 320073 	 7
PRESIDENT	   8	 320073 	 8
SALESMAN	   8	 320073 	 9
CLERK		   8	 320073 	10

JOB	     FICHIER	   BLOC   NUMLIGNE
--------- ---------- ---------- ----------
CLERK		   8	 320073 	11
ANALYST 	   8	 320073 	12
CLERK		   8	 320073 	13
*/

SELECT rowid FROM EMP WHERE empno=7902;

/*
ROWID
------------------
AAAd1MAAIAABOJJAAM

*/

SELECT * FROM EMP WHERE rowid='AAAd1MAAIAABOJJAAM';

/*
     EMPNO ENAME      JOB	       MGR HIREDATE	    SAL       COMM    DEPTNO
---------- ---------- --------- ---------- --------- ---------- --------------------
      7902 FORD       ANALYST	      7566 03-DEC-81	   3000         20

Execution Plan
----------------------------------------------------------
Plan hash value: 1116584662

-----------------------------------------------------------------------------------

| Id  | Operation		   | Name | Rows  | Bytes | Cost (%CPU)| Time  |

-----------------------------------------------------------------------------------

|   0 | SELECT STATEMENT	   |	  |	1 |    37 |	1   (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY USER ROWID| EMP  |	1 |    37 |	1   (0)| 00:00:01 |

-----------------------------------------------------------------------------------



Statistics
----------------------------------------------------------
	  0  recursive calls
	  0  db block gets
	  1  consistent gets
	  0  physical reads
	  0  redo size
	719  bytes sent via SQL*Net to client
	 41  bytes received via SQL*Net from client
	  2  SQL*Net roundtrips to/from client
	  0  sorts (memory)
	  0  sorts (disk)
	  1  rows processed
*/

--1 consistent get, 0 db block gets. On ne peut pas faire mieux

