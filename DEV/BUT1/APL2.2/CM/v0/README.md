# TP noté sur les tests 

## Fichiers mis à disposition
Pour ce TP noté sur les tests, vous disposez des fichiers suivants

+ README.md                          ce fichier, qui vous indique ce qu'il faut faire.
+ Memoire.java                       une interface java pour une mémoire non extensible pour stocker des chaînes de caractères.
+ **MaMemoire.java**                      une implémentation de l'interface ci-dessus.
+ Exemple.java                        des exemples d'uilisation de cette implémentation.
+ TestsFournisMaMemoire.java          des tests fournis pour corriger MaMemoire.java
+ **TestsACompleterMaMemoire.java**       un fichier squelette de tests à compléter.

Seuls les fichiers dont les noms sont **en gras** ci-dessus sont à compléter et à rendre.
Pour les modalités, voir ci-dessous.

## Première partie : debug ##
Un certains nombres de tests sont fournis. Vous ne devez pas changer ces derniers.
Vous devez exécuter ces tests puis changer le code de la classe **MaMemoire** idéalement jusqu'à ce que les tests fournis soient satisfaits.

Chaque ligne de **MaMemoire.java** changée devra être suivi du commentaire //BUGFIX éventuellement suivi de texte

Par exemple : 
> return (this.index); //BUGFIX enlevé +1

## Seconde partie : test ##
Vous devez compléter le fichier **TestsACompleterMaMemoire.java**
Il n'est pas demandé de changer le code de **MaMemoire.java** pour passer ces nouveaux tests.

## Modalité de rendu ##
Vous devez rendre votre travail sur devoir
l'url est :
www.iut-fbleau.fr/site/site/DEVOIR/

Il faut pour ce faire soumettre une archive tests.tar.gz contenant uniquement les deux fichiers .java (on ne veut pas les .class) suivants, édités par vos soins comme indiqué dans les questions ci-dessus :
**MaMemoire.java**
**TestsACompleterMaMemoire.java**

Pour ceux qui ont oublié comment faire :

> bob@box:~$ tar czvvf tests.tar.gz MaMemoire.java TestsACompleterMaMemoire.java 

## Special Thanks ##

![Philosophis Shadok](838_planche06_copie.jpg)
