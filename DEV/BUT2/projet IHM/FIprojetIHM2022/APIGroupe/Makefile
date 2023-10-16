# COMMANDES #
JAVAC = javac
# note $$ to get a single shell $
JAVAC_OPTIONS = -d build -cp build:$$CLASSPATH -implicit:none -encoding utf8
JAVA = java
JAR = jar
EXEC_JAR = ${JAVA} -jar

# CHEMINS RELATIFS
SRC = src/fr/iutfbleau/projetIHM2022FI2
BUILD = build/fr/iutfbleau/projetIHM2022FI2
DOC = doc/fr/iutfbleau/projetIHM2022FI2

# CHOIX NOMS
JAR_MNP = test-mnp.jar

# BUTS FACTICES #
.PHONY : run clean doc

# BUT PAR DEFAUT #
run : ${JAR_MNP}
	${EXEC_JAR} ${JAR_MNP}

# AUTRE BUTS
doc :
	javadoc -d doc src/fr/iutfbleau/projetIHM2022FI2/API/*.java src/fr/iutfbleau/projetIHM2022FI2/MNP/*.java

clean :
	rm -rf ${BUILD}/* *.jar

# REGLES DE DEPENDANCE #

## API ##
${BUILD}/API/MonPrint.class : ${SRC}/API/MonPrint.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/MonPrint.java

${BUILD}/API/TypeGroupe.class : ${SRC}/API/TypeGroupe.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/TypeGroupe.java

${BUILD}/API/Groupe.class : ${SRC}/API/Groupe.java \
	  		     ${BUILD}/API/TypeGroupe.class\
			     ${BUILD}/API/MonPrint.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/Groupe.java

${BUILD}/API/Etudiant.class : ${SRC}/API/Etudiant.java \
                            ${BUILD}/API/MonPrint.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/Etudiant.java

${BUILD}/API/Changement.class : ${SRC}/API/Changement.java \
	  		            ${BUILD}/API/Etudiant.class \
	  		     	    ${BUILD}/API/Groupe.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/Changement.java

${BUILD}/API/AbstractGroupeFactory.class : ${SRC}/API/AbstractGroupeFactory.java \
				${BUILD}/API/Groupe.class \
	  		         ${BUILD}/API/Etudiant.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/AbstractGroupeFactory.java

${BUILD}/API/AbstractChangementFactory.class : ${SRC}/API/AbstractChangementFactory.java \
	  		            ${BUILD}/API/AbstractGroupeFactory.class \
				    ${BUILD}/API/Changement.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/API/AbstractChangementFactory.java

## MNP ##

${BUILD}/MNP/EtudiantNP.class : ${SRC}/MNP/EtudiantNP.java \
                              ${BUILD}/API/Etudiant.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MNP/EtudiantNP.java


${BUILD}/MNP/GroupeNP.class : ${SRC}/MNP/GroupeNP.java \
                              ${BUILD}/API/Groupe.class \
			      ${BUILD}/API/TypeGroupe.class \
                              ${BUILD}/API/Etudiant.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MNP/GroupeNP.java


${BUILD}/MNP/ChangementNP.class : ${BUILD}/API/Changement.class \
				${SRC}/MNP/ChangementNP.java \
                              ${BUILD}/API/Groupe.class \
                              ${BUILD}/API/Etudiant.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MNP/ChangementNP.java

${BUILD}/MNP/AbstractGroupeFactoryNP.class : ${SRC}/MNP/AbstractGroupeFactoryNP.java \
				${BUILD}/API/AbstractGroupeFactory.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MNP/AbstractGroupeFactoryNP.java

${BUILD}/MNP/AbstractChangementFactoryNP.class : ${SRC}/MNP/AbstractChangementFactoryNP.java \
				${BUILD}/API/AbstractChangementFactory.class \
				${BUILD}/API/Changement.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MNP/AbstractChangementFactoryNP.java


###...

## TEST ##

 ${BUILD}/Test/TestTexteMNP.class : ${SRC}/Test/TestTexteMNP.java \
			 ${BUILD}/MNP/EtudiantNP.class \
			 ${BUILD}/MNP/GroupeNP.class \
			 ${BUILD}/MNP/ChangementNP.class \
                         ${BUILD}/MNP/AbstractGroupeFactoryNP.class \
                         ${BUILD}/MNP/AbstractChangementFactoryNP.class	
	${JAVAC} -Xlint:deprecation ${JAVAC_OPTIONS} ${SRC}/Test/TestTexteMNP.java

# ## JARS ##

 ${JAR_MNP} : ${BUILD}/Test/TestTexteMNP.class
	${JAR} cvfe ${JAR_MNP} fr.iutfbleau.projetIHM2022FI2.Test.TestTexteMNP -C build fr

# ## Etudiant ##

 ${BUILD}/Etu/Vue/MainEtu.class : ${SRC}/Etu/Vue/MainEtu.java \
		${BUILD}/Etu/Vue/VueEtu.class \
		${BUILD}/Etu/Vue/ActionMenuEtu.class \
			${BUILD}/Etu/Vue/StaticMethodeEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/MainEtu.java

${BUILD}/Etu/Vue/VueEtu.class : ${SRC}/Etu/Vue/VueEtu.java \
		${BUILD}/Etu/Vue/ActionMenuEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/VueEtu.java

${BUILD}/Etu/Vue/ActionMenuEtu.class : ${SRC}/Etu/Vue/ActionMenuEtu.java \
		${BUILD}/Etu/Vue/PanneauEtu.class	
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/ActionMenuEtu.java

${BUILD}/Etu/Vue/PanneauEtu.class : ${SRC}/Etu/Vue/PanneauEtu.java \
		${BUILD}/Etu/Vue/PageEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/PanneauEtu.java

${BUILD}/Etu/Vue/PageEtu.class : ${SRC}/Etu/Vue/PageEtu.java \
		${BUILD}/Etu/Vue/ListeGroupe.class \
		${BUILD}/Etu/Vue/ListeEtudiant.class \
		${BUILD}/Etu/Vue/ListeChangement.class \
		${BUILD}/Etu/Vue/PanneauEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/PageEtu.java

${BUILD}/Etu/Vue/ListeGroupe.class : ${SRC}/Etu/Vue/ListeGroupe.java \
		${BUILD}/Etu/Vue/StaticMethodeEtu.class \
		${BUILD}/Etu/Vue/ActionListeEtu.class \
		${BUILD}/Etu/Vue/PageEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/ListeGroupe.java

${BUILD}/Etu/Vue/ListeEtudiant.class : ${SRC}/Etu/Vue/ListeEtudiant.java \
		${BUILD}/Etu/Vue/StaticMethodeEtu.class \
		${BUILD}/Etu/Vue/ActionListeEtu.class \
		${BUILD}/Etu/Vue/PageEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/ListeEtudiant.java

${BUILD}/Etu/Vue/ListeChangement.class : ${SRC}/Etu/Vue/ListeChangement.java \
		${BUILD}/Etu/Vue/StaticMethodeEtu.class \
		${BUILD}/Etu/Vue/ActionListeEtu.class \
		${BUILD}/Etu/Vue/PageEtu.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/ListeChangement.java

${BUILD}/Etu/Vue/ActionListeEtu.class : ${SRC}/Etu/Vue/ActionListeEtu.java \
		${BUILD}/Etu/Vue/PageEtu.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/ActionListeEtu.java

${BUILD}/Etu/Vue/StaticMethodeEtu.class : ${SRC}/Etu/Vue/StaticMethodeEtu.java \
		${BUILD}/Etu/Vue/MainTest.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/StaticMethodeEtu.java

${BUILD}/Etu/Vue/MainTest.class : ${SRC}/Etu/Vue/MainTest.java \
		${BUILD}/Etu/Vue/TestTexteMNP.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/MainTest.java

${BUILD}/Etu/Vue/TestTexteMNP.class : ${SRC}/Etu/Vue/TestTexteMNP.java 	
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Etu/Vue/TestTexteMNP.java


# ## Professeur ##

 ${BUILD}/Prof/Vue/MainProf.class : ${SRC}/Prof/Vue/MainProf.java \
		${BUILD}/Prof/Vue/VueProf.class \
		${BUILD}/Prof/Vue/ActionMenuProf.class \
			${BUILD}/Prof/Vue/StaticMethodeProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/MainProf.java

${BUILD}/Prof/Vue/VueProf.class : ${SRC}/Prof/Vue/VueProf.java \
		${BUILD}/Prof/Vue/ActionMenuProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/VueProf.java

${BUILD}/Prof/Vue/ActionMenuProf.class : ${SRC}/Prof/Vue/ActionMenuProf.java \
		${BUILD}/Prof/Vue/PanneauProf.class	
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/ActionMenuProf.java

${BUILD}/Prof/Vue/PanneauProf.class : ${SRC}/Prof/Vue/PanneauProf.java \
		${BUILD}/Prof/Vue/PageProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/PanneauProf.java

${BUILD}/Prof/Vue/PageProf.class : ${SRC}/Prof/Vue/PageProf.java \
		${BUILD}/Prof/Vue/ListeGroupe.class \
		${BUILD}/Prof/Vue/ListeEtudiant.class \
		${BUILD}/Prof/Vue/PanneauProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/PageProf.java

${BUILD}/Prof/Vue/ListeGroupe.class : ${SRC}/Prof/Vue/ListeGroupe.java \
		${BUILD}/Prof/Vue/StaticMethodeProf.class \
		${BUILD}/Prof/Vue/ActionListeProf.class \
		${BUILD}/Prof/Vue/PageProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/ListeGroupe.java

${BUILD}/Prof/Vue/ListeEtudiant.class : ${SRC}/Prof/Vue/ListeEtudiant.java \
		${BUILD}/Prof/Vue/StaticMethodeProf.class \
		${BUILD}/Prof/Vue/ActionListeProf.class \
		${BUILD}/Prof/Vue/PageProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/ListeEtudiant.java

${BUILD}/Prof/Vue/ActionListeProf.class : ${SRC}/Prof/Vue/ActionListeProf.java \
		${BUILD}/Prof/Vue/PageProf.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/ActionListeProf.java

${BUILD}/Prof/Vue/StaticMethodeProf.class : ${SRC}/Prof/Vue/StaticMethodeProf.java \
		${BUILD}/Prof/Vue/MainTest.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/StaticMethodeProf.java

${BUILD}/Prof/Vue/MainTest.class : ${SRC}/Prof/Vue/MainTest.java \
		${BUILD}/Prof/Vue/TestTexteMNP.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/MainTest.java

${BUILD}/Prof/Vue/TestTexteMNP.class : ${SRC}/Prof/Vue/TestTexteMNP.java 	
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Prof/Vue/TestTexteMNP.java

# ## Admin ##

${BUILD}/Admin/Controleur/ActionAdminInstru.class : ${SRC}/Admin/Controleur/ActionAdminInstru.java                
    ${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/Controleur/ActionAdminInstru.java

${BUILD}/Admin/Controleur/ActionMenuAdmin.class : ${SRC}/Admin/Controleur/ActionMenuAdmin.java \ 
		${BUILD}/Admin/Controleur/ActionAdminInstru.class 
    ${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/Controleur/ActionMenuAdmin.java

${BUILD}/Admin/Vue/Pancardlayout.class : ${SRC}/Admin/Controleur/PancardLayout.java \
        ${BUILD}/Admin/Controleur/ ActionMenuAdmin.class 
    ${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/Vue/PancardLayout.java

${BUILD}/Admin/Vue/PanTree.class : ${BUILD}/Admin/Vue/PanTree.java 
    ${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/Vue/PanTree.java

${BUILD}/Admin/Vue/VueAdmin.class : ${SRC}/Admin/Vue/VueAdmin.java \
        ${BUILD}/Admin/Vue/PanTree.class \
        ${BUILD}/Admin/Vue/PancardLayout.class \
		${BUILD}/Admin/Controleur/ActionMenuAdmin.class
    ${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/Vue/VueAdmin.java

${BUILD}/Modele/Initialisation.class : ${SCR}/Modele/Initialisation.java \
		${BUILD}/Admin/Vue/VueAdmin.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Modele/Initialisation.java

  ${BUILD}/Admin/MainAdmin.class : ${SRC}/Admin/MainAdmin.java \
		${BUILD}/Modele/Initialisation.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Admin/MainAdmin.java