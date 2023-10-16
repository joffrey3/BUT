--Exercice 1 :

--Faire dans un terminal :

SELECT * FROM session_roles;

--ROLE
------------------------------
--CONNECT
--RESOURCE
--PLUSTRACE

EXEC DBMS_STATS.GATHER_TABLE_STATS(USER,'EMP');

EXEC DBMS_STATS.GATHER_TABLE_STATS(USER,'DEPT');

SELECT table_name, BLOCKS, EMPTY_BLOCKS, AVG_SPACE, CHAIN_CNT ,AVG_ROW_LEN, SAMPLE_SIZE, LAST_ANALYZED FROM user_tables;

--DEPT                                   28            0          0          0          20           4 26/01/23
--EMP                                    28            0          0          0          37          14 26/01/23

SET AUTOTRACE ON;