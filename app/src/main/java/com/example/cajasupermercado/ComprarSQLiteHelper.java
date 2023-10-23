package com.example.cajasupermercado;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cajasupermercado.utilidades.Utilidades;


public class ComprarSQLiteHelper extends SQLiteOpenHelper {


    public ComprarSQLiteHelper(Context context, String nombreTabla, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombreTabla, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                Utilidades.TABLA_PRODUCTO_COMPRAR + " (" +
                Utilidades.CAMPO_ID + " " + "INTEGER, " +
                Utilidades.CAMPO_NOMBRE + " TEXT," +
                Utilidades.CAMPO_CANTIDAD + " INTEGER," +
                Utilidades.CAMPO_CANTIDAD_ACTUAL + " INTEGER," +
                Utilidades.CAMPO_PRECIO + " REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PRODUCTO_COMPRAR);
        onCreate(db);
    }
}
