package com.erwin.sqlite.sqlitepracticas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {


    SQLiteDatabase db;
    ListView lista;
    List<Task> tareas;
    List<String> tareaStrings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listaTareas);
        CargarDatos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CargarDatos();
    }

    public void CargarDatos(){
        tareas = new ArrayList<Task>();
        tareaStrings =  new ArrayList<String>();
        TaskReaderDbHelper mDbHelper = new TaskReaderDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                TaskReaderContract.FeedEntry._ID,
                TaskReaderContract.FeedEntry.COLUMN_NAME_NAME,
                TaskReaderContract.FeedEntry.COLUMN_NAME_DESCRIPTION
        };

// Filter results WHERE "title" = 'My Title'
        String selection = "";
        String[] selectionArgs = { };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                TaskReaderContract.FeedEntry._ID + " DESC";

        Cursor c = db.query(
                TaskReaderContract.FeedEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        c.moveToFirst();


        while (!c.isAfterLast()) {

            String id = c.getInt(c.getColumnIndex("_id"))+"";
            String nombre = c.getString(c.getColumnIndex("name"));
            String descripcion = c.getString(c.getColumnIndex("description"));
            //String fecha = c.get(c.getColumnIndex("date"));
            Task tarea = new Task(id,nombre,descripcion,"");

            tareas.add(tarea);
            tareaStrings.add(tarea.nombre+" "+tarea.descripcion+" "+"");
            c.moveToNext();
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                tareaStrings );

        lista.setAdapter(arrayAdapter);
    }
    public void onClickAddTask(View view) {
        // Insert the new row, returning the primary key value of the new row
        // Create a new map of values, where column names are the keys
        Intent i = new Intent(this,SecondActivity.class);
        startActivity(i);
    }
}
