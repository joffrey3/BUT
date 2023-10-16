--Partie 1

SELECT * FROM v$datafile;
SELECT * FROM v$logfile;
SELECT * FROM v$controlfile;
SELECT * FROM v$tempfile;
SELECT * FROM dba_data_files;
SELECT * FROM dba_segments;
SELECT * FROM dba_free_space;

SELECT SUM(bytes*blocks) FROM dba_segments GROUP BY tablespace_name;
SELECT tablespace_name,segment_type,SUM(bytes*blocks) FROM dba_segments WHERE segment_type IN ('INDEX','TABLE') GROUP BY tablespace_name,segment_type;
SELECT tablespace_name,file_id,SUM(bytes*blocks) FROM dba_free_space GROUP BY tablespace_name,file_id;

--Partie 2

mysql -h dwarves -u fouche -p fouche
mysqldump -h dwarves -u fouche -p fouche > ./BD/BUT2/S4/TP03/backup.sql
cd ./BD/BUT2/S4/TP03/
nano backup.sql
mysqldump -h dwarves -u fouche -p fouche > backup-$(date +%Y%m%d).sql
source ./BD/BUT2/S4/TP03/backup.sql.