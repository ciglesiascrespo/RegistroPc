package com.example.dell.registropc.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data";
    private final String TAG = getClass().getName();

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e(TAG, "Creo DbHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(RegistroDb.getCreateTable());

        insertData(db);
    }

    private void insertData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(RegistroDb.KEY_ID, 1);
        cv.put(RegistroDb.KEY_ESTADO, 1);
        cv.put(RegistroDb.KEY_FECHA_INGRESO, "2018-08-09 08:00:54");
        cv.put(RegistroDb.KEY_FECHA_SALIDA, "2018-08-09 16:00:00");
        cv.put(RegistroDb.KEY_NOMBRE, "DELL");
        cv.put(RegistroDb.KEY_PISO, 30);
        cv.put(RegistroDb.KEY_SERIAL, "5421");
        db.insert(RegistroDb.TABLE, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + RegistroDb.TABLE);

        onCreate(db);
    }

    public long insert(String tableName, ContentValues cv) {
        long i =0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
          i=  db.insert(tableName, null, cv);
            //if (db.isOpen()) db.close();
        } catch (Exception e) {
            //db.close();
            Log.e(TAG, "Error insertando en la base de datos: " + e.getMessage());
            e.printStackTrace();

        }
        return  i;

    }

    public Cursor execSql(String query) {
        Cursor c = null;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            c = db.rawQuery(query, null);
            // db.close();
        } catch (Exception e) {
            //if (db.isOpen()) db.close();
            Log.e(TAG, "Error ejecutando sql: " + query + " " + e.getMessage());
            e.printStackTrace();
        }

        return c;
    }

    public void update(String tableName, ContentValues cv, String condition) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.update(tableName, cv, condition, null);
            //  db.close();
        } catch (Exception e) {
            // if (db.isOpen()) db.close();
            Log.e(TAG, "Error update: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(String tableName, String condition) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            db.delete(tableName, condition, null);
            //  db.close();
        } catch (Exception e) {
            //  if (db.isOpen()) db.close();
            Log.e(TAG, "Error delete: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
