JAVAC_OPT =  -implicit:none\
			-cp build \
			-d build \
			-sourcepath "src"

JAVA_OPT = -cp build

PACKAGE = fr.iutfbleau.info.fouche.organisationducode.quiz

PACKAGE_PATH = fr/iutfbleau/info/fouche/organisationducode/quiz

run : build/$(PACKAGE_PATH)/Main.class
	java $(JAVA_OPT) $(PACKAGE).Main

build/$(PACKAGE_PATH)/Main.class : src/$(PACKAGE_PATH)/Main.java build/$(PACKAGE_PATH)/Fenetre.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/Fenetre.class : src/$(PACKAGE_PATH)/Fenetre.java build/$(PACKAGE_PATH)/Ecran.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/Ecran.class : src/$(PACKAGE_PATH)/Ecran.java build/$(PACKAGE_PATH)/BoiteQuestion.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/BoiteQuestion.class : src/$(PACKAGE_PATH)/BoiteQuestion.java build/$(PACKAGE_PATH)/Question.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/Question.class : src/$(PACKAGE_PATH)/Question.java
	javac $(JAVAC_OPT) $<