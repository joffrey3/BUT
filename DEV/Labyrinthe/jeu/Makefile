### VARIABLES ###
JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none -d ./class

JVM = java
JVMFLAGS = 

### REGLES ESSENTIELLES ###

/Main.class : ./java/Main.java InterfaceAccueil.class InterfacePartie.class InterfaceNiveau.class InterfaceDialogue.class
	${JC} ${JCFLAGS} ./java/Main.java ./java/InterfaceAccueil.java ./java/InterfacePartie.java ./java/InterfaceNiveau.java ./java/InterfaceDialogue.java ./java/DessinAccueil.java ./java/DessinPartie.java ./java/DessinNiveau.java ./java/DessinDialogue.java ./java/InterfaceCombat.java ./java/DessinCombat.java ./java/LecteurXPM.java ./java/LecteurTableau.java ./java/LecteurDialogue.java ./java/LecteurDecor.java ./java/Temps.java

InterfaceAccueil.class : ./java/InterfaceAccueil.java DessinAccueil.class
	${JC} ${JCFLAGS} ./java/InterfaceAccueil.java ./java/DessinAccueil.java ./java/LecteurXPM.java

DessinAccueil.class : ./java/DessinAccueil.java LecteurXPM.class
	${JC} ${JCFLAGS} ./java/DessinAccueil.java ./java/LecteurXPM.java

InterfacePartie.class : ./java/InterfacePartie.java DessinPartie.class
	${JC} ${JCFLAGS} ./java/InterfacePartie.java ./java/DessinPartie.java ./java/LecteurXPM.java

DessinPartie.class : ./java/DessinPartie.java LecteurXPM.class
	${JC} ${JCFLAGS} ./java/DessinPartie.java ./java/LecteurXPM.java

InterfaceNiveau.class : ./java/InterfaceNiveau.java DessinNiveau.class LecteurTableau.class 
	${JC} ${JCFLAGS} ./java/InterfaceNiveau.java ./java/DessinNiveau.java ./java/LecteurXPM.java ./java/LecteurTableau.java

DessinNiveau.class : ./java/DessinNiveau.java LecteurXPM.class  
	${JC} ${JCFLAGS} ./java/DessinNiveau.java ./java/LecteurXPM.java

InterfaceDialogue.class : ./java/InterfaceDialogue.java LecteurDialogue.class Temps.class
	${JC} ${JCFLAGS} ./java/InterfaceDialogue.java ./java/DessinDialogue.java ./java/LecteurXPM.java ./java/LecteurDialogue.java ./java/Temps.java

DessinDialogue.class : ./java/DessinDialogue.java LecteurXPM.class
	${JC} ${JCFLAGS}  ./java/InterfaceDialogue.java ./java/DessinDialogue.java ./java/LecteurXPM.java ./java/LecteurDialogue.java ./java/Temps.java

InterfaceCombat.class : ./java/InterfaceCombat.java DessinAccueil.class
	${JC} ${JCFLAGS} ./java/InterfaceCombat.java ./java/DessinCombat.java ./java/LecteurXPM.java ./java/LecteurDecor.java

DessinCombat.class : ./java/DessinCombat.java LecteurXPM.class LecteurDecor.class
	${JC} ${JCFLAGS} ./java/DessinCombat.java ./java/LecteurXPM.java ./java/LecteurDecor.java

LecteurXPM.class : ./java/LecteurXPM.java
	${JC} ${JCFLAGS} ./java/LecteurXPM.java

LecteurTableau.class : ./java/LecteurTableau.java
	${JC} ${JCFLAGS} ./java/LecteurTableau.java

LecteurDialogue.class : ./java/LecteurDialogue.java
	${JC} ${JCFLAGS} ./java/LecteurDialogue.java

LecteurDecor.class : ./java/LecteurDecor.java
	${JC} ${JCFLAGS} ./java/LecteurDecor.java

Temps.class : ./java/Temps.java DessinDialogue.class
	${JC} ${JCFLAGS} ./java/InterfaceDialogue.java ./java/DessinDialogue.java ./java/LecteurXPM.java ./java/LecteurDialogue.java ./java/Temps.java

### FIN ###
