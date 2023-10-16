# TP noté tests et debug.

## Fichiers mis à disposition
Pour ce TP noté sur les tests, vous disposez des fichiers suivants

+ README.md                          ce fichier, qui vous indique ce qu'il faut faire.
+ Ranger.java                        une interface java pour une mémoire non extensible pour stocker des chaînes de caractères *dans l'ordre*.
+ **MonRanger.java**                 une implémentation de l'interface ci-dessus.
+ TestsFournisMonRanger.java         des tests fournis pour corriger MonRanger.java
+ **TestsACompleterMonRanger.java**  un fichier squelette de tests à compléter.

Seuls les fichiers dont les noms sont **en gras** ci-dessus sont à compléter et à rendre.
Pour les modalités, voir ci-dessous.

## Première partie : debug ##
Un certains nombres de tests sont fournis. Vous ne devez pas changer ces derniers.
Vous devez exécuter ces tests puis changer le code de la classe **MonRanger** idéalement jusqu'à ce que les tests fournis soient satisfaits.

Chaque ligne de **MonRanger.java** changée devra être suivi du commentaire //BUGFIX éventuellement suivi de texte

Par exemple : 
> return (this.index); //BUGFIX enlevé +1

si vous avez enlevé +1.

Je corrige en utilisant grep pour chercher BUGFIX. 
Si vous ne suivez pas ces consignes vous n'aurez aucun point sur cette partie.

## Seconde partie : test ##
Vous devez compléter le fichier **TestsACompleterMonRanger.java**
Il n'est pas demandé de changer le code de **MonRanger.java** pour passer ces nouveaux tests.

## Modalité de rendu ##
Vous devez rendre votre travail sur devoir
l'url est :
www.iut-fbleau.fr/site/site/DEVOIR/

Il faut pour ce faire soumettre une archive tests.tar.gz contenant uniquement les deux fichiers .java (on ne veut pas les .class) suivants, édités par vos soins comme indiqué dans les questions ci-dessus :
**MonRanger.java**
**TestsACompleterMonRanger.java**

Pour ceux qui ont oublié comment faire :

> bob@box:~$ tar czvvf tests.tar.gz MonRanger.java TestsACompleterMonRanger.java 

Si vous ne suivez pas exactement cette consigne, je dois changer mon script de correction et je perds du temps.
La perte de temps ne favorise pas la bienveillance.

