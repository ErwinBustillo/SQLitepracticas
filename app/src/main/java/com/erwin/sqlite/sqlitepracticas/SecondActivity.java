package com.erwin.sqlite.sqlitepracticas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText textoNombre;
    EditText textoDescripcion;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TaskReaderDbHelper mDbHelper = new TaskReaderDbHelper(this);
        // Gets the data repository in write mode
        db = mDbHelper.getWritableDatabase();
        textoNombre = (EditText) findViewById(R.id.campoNombre);
        textoDescripcion = (EditText) findViewById(R.id.campoDescripcion);
    }

    public void onClickSave(View view) {
        ContentValues values = new ContentValues();
        values.put(TaskReaderContract.FeedEntry.COLUMN_NAME_NAME, textoNombre.getText().toString());
        values.put(TaskReaderContract.FeedEntry.COLUMN_NAME_DESCRIPTION, textoDescripcion.getText().toString());
        values.put(TaskReaderContract.FeedEntry.COLUMN_NAME_DATE, "datetime()");
        long newRowId = db.insert(TaskReaderContract.FeedEntry.TABLE_NAME, null, values);
        finish();
    }
}
