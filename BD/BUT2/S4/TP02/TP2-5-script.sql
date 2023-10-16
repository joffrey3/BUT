BEGIN
for id in 1..100000 LOOP
INSERT INTO BIGBITMAP VALUES
( id,
MOD(id,5) ,
TO_DATE(sysdate, 'DD/MM/YYYY')
);
Commit;
END LOOP;
dbms_output.put_line ('100000 lignes inserees');
END;