--TP3 :

--Exercice 2 :

--Commande de base :
--mysql -h dwarves -u user_name -p db_name

--Commande personnalisée :
--mysql -h dwarves -u fouche -p fouche

--Commande redirection vers un fichier
--mysqldump -h dwarves -u user_name -p db_name > nom_fichier.sql

--Commande redirection vers un fichier personnalisé
--mysqldump -h dwarves -u fouche -p fouche > ./BD/BUT2/S4/TP03/backup.sql

--Ouvrir le fichier
--cd ./BD/BUT2/S4/TP03/
--nano backup.sql

--Nommer le fichier avec la date du jour :
--mysqldump -h dwarves -u fouche -p fouche > backup-$(date +%Y%m%d).sql

--Pour restorer la base de données
--source ./BD/BUT2/S4/TP03/backup.sql.