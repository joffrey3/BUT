DROP TABLE EMP_SEUIL;
DROP TABLE SUIVI_EMP;
DROP TABLE EMP;
DROP TABLE DEPT;

CREATE TABLE DEPT
       (DEPTNO NUMBER(2) NOT NULL Primary Key,
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) );

CREATE TABLE EMP
       (EMPNO NUMBER(4) NOT NULL Primary Key,
        ENAME VARCHAR2(10),
        JOB VARCHAR2(9),
        MGR NUMBER(4),
        HIREDATE DATE,
        SAL NUMBER(7, 2) check (sal > 0),
        COMM NUMBER(7, 2) check (comm > 0),
        DEPTNO NUMBER(2) References DEPT);

create table Suivi_EMP (
deptno number references dept,
nombre_emp number);

create table EMP_SEUIL (
JOB VARCHAR2(9) NOT NULL Primary Key,
COMM_MIN number);

INSERT into EMP_SEUIL values ('CLERK',100);    
INSERT into EMP_SEUIL values ('SALESMAN',1000); 
INSERT into EMP_SEUIL values ('PRESIDENT',5000);
INSERT into EMP_SEUIL values ('MANAGER',2000);  
INSERT into EMP_SEUIL values ('ANALYST',200); 
commit;

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH',   'DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES',      'CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');
commit;
	

INSERT INTO EMP VALUES (7369, 'SMITH',  'CLERK', 7902,  TO_DATE('17-12-1980', 'DD-MM-YYYY'),  800, NULL, 20);
INSERT INTO EMP VALUES (7499, 'ALLEN',  'SALESMAN',  7698,  TO_DATE('20-02-1981', 'DD-MM-YYYY'), 1600,  300, 30);
INSERT INTO EMP VALUES
        (7521, 'WARD',   'SALESMAN',  7698,
        TO_DATE('22-02-1981', 'DD-MM-YYYY'), 1250,  500, 30);
INSERT INTO EMP VALUES
        (7566, 'JONES',  'MANAGER',   7839, TO_DATE('2-04-1981', 'DD-MM-YYYY'),  2975, NULL, 20);
INSERT INTO EMP VALUES (7654, 'MARTIN', 'SALESMAN',  7698, TO_DATE('28-09-1981', 'DD-MM-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES
        (7698, 'BLAKE',  'MANAGER',   7839,
        TO_DATE('1-05-1981', 'DD-MM-YYYY'),  2850, NULL, 30);
INSERT INTO EMP VALUES
        (7782, 'CLARK',  'MANAGER',   7839,
        TO_DATE('9-06-1981', 'DD-MM-YYYY'),  2450, NULL, 10);
INSERT INTO EMP VALUES
        (7788, 'SCOTT',  'ANALYST',   7566,
        TO_DATE('09-12-1982', 'DD-MM-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES(7839, 'KING',   'PRESIDENT', NULL,
        TO_DATE('17-11-1981', 'DD-MM-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES
        (7844, 'TURNER', 'SALESMAN',  7698,
        TO_DATE('8-09-1981', 'DD-MM-YYYY'),  1500,   10, 30);
INSERT INTO EMP VALUES
        (7876, 'ADAMS',  'CLERK',     7788,
        TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES
        (7900, 'JAMES',  'CLERK',     7698,
        TO_DATE('3-12-1981', 'DD-MM-YYYY'),   950, NULL, 30);
INSERT INTO EMP VALUES
        (7902, 'FORD',   'ANALYST',   7566,
        TO_DATE('3-12-1981', 'DD-MM-YYYY'),  3000, NULL, 20);
INSERT INTO EMP VALUES
        (7934, 'MILLER', 'CLERK',     7782,
        TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300, NULL, 10);

COMMIT;

insert into suivi_emp select deptno, 0 from dept where deptno not in (select distinct deptno from emp);
insert into suivi_emp select deptno, count(*) from emp group by deptno;
commit;


