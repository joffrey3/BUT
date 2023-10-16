package fr.iut_fbleau.apl41.couleurs;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Liste extends Activity {
    private final static String[] CHAMPS = {AccesBaseDeDonnees.CHAMP_NOM, AccesBaseDeDonnees.CHAMP_VALEUR};
    private final static int[] VUES = {R.id.nom, R.id.couleur};
    private SimpleCursorAdapter adaptateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_liste);
        this.adaptateur = new SimpleCursorAdapter(this, R.layout.row_element, null, Liste.CHAMPS, Liste.VUES, 0);
        this.adaptateur.setViewBinder(new Lieur());
        ListView elements = (ListView) this.findViewById(R.id.elements);
        elements.setOnItemClickListener(new ControleClic(this));
        elements.setAdapter(this.adaptateur);
        this.remplirListe();
    }

    public void remplirListe() {
        AccesBaseDeDonnees acces = new AccesBaseDeDonnees(this);
        SQLiteDatabase baseDeDonnees = acces.getReadableDatabase();

        Cursor curseur = baseDeDonnees.query(AccesBaseDeDonnees.NOM_TABLE, null, null, null, null, null, null);
        if (curseur != null) {
            this.adaptateur.swapCursor(curseur);
        } else {
            Toast.makeText(this, "Erreur d'accès à la base de données", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_liste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_ajouter) {
            // TODO
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
