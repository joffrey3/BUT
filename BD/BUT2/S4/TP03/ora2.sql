SELECT * FROM v$datafile;
SELECT * FROM v$logfile;
SELECT * FROM v$controlfile;
SELECT * FROM v$tempfile;
SELECT * FROM dba_data_files;
SELECT * FROM dba_segments;
SELECT * FROM dba_free_space;

SELECT bytes*blocks FROM dba_segments;