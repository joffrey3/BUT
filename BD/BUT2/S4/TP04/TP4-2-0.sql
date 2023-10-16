--TP4 :

--Exercice 2 :
SELECT * FROM DonneesFouche;
/*
A	2
B	0
C	0
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

--2.1 le ph?nom?ne mis en ?vidence est la perte de la coh?rence des donn?es et une perte de mise ? jour.

SELECT * FROM DonneesFouche;
/*
A	2
B	0
C	0
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

--t1 : les updates se sont fait sur chaque ligne donc pas d'attente, les vues ne prennent en compte que les updates qu'ils ont faits.
--t2 : cela a cr?er des d?pendances circulaires et donc oracle a rejett? la premi?re demande pour rendre le terminal accessible en indiquant une erreur sp?cifique.

SELECT * FROM DonneesFouche;
/*
A	2
B	2
C	0
*/
UPDATE DonneesFouche SET valeur =0;
/*
3 rows updated.
*/
SELECT * FROM DonneesFouche;
/*
A	0
B	0
C	0
*/
COMMIT;
/*
Commit complete.
*/

--t1 tout va bien le tuple 'C' est modifi?
--t2 c'est bloquant pour 'A' car session 1 a demand? de l'UPDATE. 