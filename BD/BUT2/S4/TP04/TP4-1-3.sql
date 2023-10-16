--TP4 :

--Exercice 1 :

--Session 3 :

SELECT DISTINCT sid FROM v$mystat;
/*
       SID
----------
	34

*/
SELECT * FROM v$locked_object;
/*
    XIDUSN    XIDSLOT	  XIDSQN  OBJECT_ID SESSION_ID              ORACLE_USERNAME 	       OS_USER_NAME		      PROCESS   LOCKED_MODE
---------- ---------- ---------- -------------------------------------------------- ------------------------------ ------------ -----------

    	 3  	    7	   61099     104800 	    11                      FOUCHE      			       fouche           2026	      3

         0	        0	       0     104800	        14                      FOUCHE		        	       fouche		    2058    	  3

*/
SELECT * FROM dba_waiters ;

/*
WAITING_SESSION HOLDING_SESSION LOCK_TYPE       MODE_HELD                                   MODE_REQUESTED                                  LOCK_ID1   LOCK_ID2
--------------- --------------- ---------------------------------------------------------------------------------------------------------- ---------- ----------
             14 	        11      Transaction                                     Exclusive                                   Exclusive       196615	    61099

*/
