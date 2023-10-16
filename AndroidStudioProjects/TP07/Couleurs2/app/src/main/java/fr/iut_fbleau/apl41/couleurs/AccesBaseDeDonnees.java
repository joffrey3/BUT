package fr.iut_fbleau.apl41.couleurs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class AccesBaseDeDonnees extends SQLiteOpenHelper {
    public final static String NOM_BASE = "base_couleurs";
    public final static int VERSION_BASE = 3;
    public final static String NOM_TABLE = "couleurs";
    public final static String CHAMP_NOM = "couleurs_nom";
    public final static String CHAMP_VALEUR = "couleurs_valeur";

    public AccesBaseDeDonnees(Context context) {
        super(context, AccesBaseDeDonnees.NOM_BASE, null, AccesBaseDeDonnees.VERSION_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDonnees) {
        baseDeDonnees.execSQL("create table " + AccesBaseDeDonnees.NOM_TABLE + "(" +
                              BaseColumns._ID + " integer primary key autoincrement, " +
                              AccesBaseDeDonnees.CHAMP_NOM + " text not null, " +
                              AccesBaseDeDonnees.CHAMP_VALEUR + " integer);");

        ContentValues tuple = new ContentValues();

        tuple.put(AccesBaseDeDonnees.CHAMP_NOM, "bleu Denim");
        tuple.put(AccesBaseDeDonnees.CHAMP_VALEUR, 0xFF4B0082);
        baseDeDonnees.insert(AccesBaseDeDonnees.NOM_TABLE, null, tuple);
        tuple.put(AccesBaseDeDonnees.CHAMP_NOM, "bleu électrique");
        tuple.put(AccesBaseDeDonnees.CHAMP_VALEUR, 0xFF1163E3);
        baseDeDonnees.insert(AccesBaseDeDonnees.NOM_TABLE, null, tuple);
        tuple.put(AccesBaseDeDonnees.CHAMP_NOM, "bleu vert");
        tuple.put(AccesBaseDeDonnees.CHAMP_VALEUR, 0xFF40E0D0);
        baseDeDonnees.insert(AccesBaseDeDonnees.NOM_TABLE, null, tuple);
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDonnees, int vieux, int nouveau) {
        baseDeDonnees.execSQL("drop table if exists " + AccesBaseDeDonnees.NOM_TABLE);
        this.onCreate(baseDeDonnees);
    }
}
