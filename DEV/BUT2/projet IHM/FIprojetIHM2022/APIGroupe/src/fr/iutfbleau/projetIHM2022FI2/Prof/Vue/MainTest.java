package fr.iutfbleau.projetIHM2022FI2.Prof.Vue;

import fr.iutfbleau.projetIHM2022FI2.API.*;
import fr.iutfbleau.projetIHM2022FI2.MNP.*;

public class MainTest{
    public static AbstractChangementFactoryNP main(){
        TestTexteMNP test = new TestTexteMNP();
        test.main();
        AbstractChangementFactoryNP acf = test.getFactory();
        return acf;
    }
}