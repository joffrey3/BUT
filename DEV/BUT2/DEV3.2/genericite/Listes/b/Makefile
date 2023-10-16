JAVAC_OPT =  -implicit:none\
			-cp build \
			-d build \
			-sourcepath "src"

JAVA_OPT = -cp build

PACKAGE = fr.iutfbleau.info.fouche.genericite.listes

PACKAGE_PATH = fr/iutfbleau/info/fouche/genericite/listes

run : build/$(PACKAGE_PATH)/Main.class
	java $(JAVA_OPT) $(PACKAGE).Main

build/$(PACKAGE_PATH)/Main.class : src/$(PACKAGE_PATH)/Main.java build/$(PACKAGE_PATH)/Listes.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/Listes.class : src/$(PACKAGE_PATH)/Listes.java build/$(PACKAGE_PATH)/Test.class
	javac $(JAVAC_OPT) $<

build/$(PACKAGE_PATH)/Test.class : src/$(PACKAGE_PATH)/Test.java
	javac $(JAVAC_OPT) $<