package fr.iut_fbleau.apl41.couleurs;

import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;

public class Lieur implements SimpleCursorAdapter.ViewBinder {
    @Override
    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
        if(view.getId() == R.id.couleur) {
            if (view instanceof Cercle){
                ((Cercle) view).setBackgroundColor(0xFF000000);
                ((Cercle) view).setColor(cursor.getInt(columnIndex));
            }
            return true;
        }
        return false;
    }
}
