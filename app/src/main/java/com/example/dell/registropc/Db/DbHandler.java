package com.example.dell.registropc.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.dell.registropc.Pojo.Registro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public class DbHandler {

    private DbHelper dbHelper;
    private static DbHandler instance = null;
    public String TAG = getClass().getName();

    protected DbHandler(Context context) {
        Log.e("DbHandler", "creo instancia handler");
        dbHelper = new DbHelper(context);
    }

    public static DbHandler getInstance(Context context) {
        if (instance == null) {
            instance = new DbHandler(context);
        }
        Log.e("DbHandler", "uso instancia handler");
        return instance;
    }


    public List<Registro> getRegistros() {
        ArrayList<Registro> list = new ArrayList<>();
        Cursor c = null;

        try {

            String query = "Select * from " + RegistroDb.TABLE + " order by " + RegistroDb.KEY_FECHA_INGRESO + " desc";


            c = dbHelper.execSql(query);

            if (c.moveToFirst()) {
                do {
                    String nombrePc="", serial="", fechaIngreso="", fechaSalida="";
                    int estado=-1, piso=0,idRegistro=-1;

                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_ID))) {
                        idRegistro = c.getInt(c.getColumnIndex(RegistroDb.KEY_ID));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_ESTADO))) {
                        estado = c.getInt(c.getColumnIndex(RegistroDb.KEY_ESTADO));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_PISO))) {
                        piso = c.getInt(c.getColumnIndex(RegistroDb.KEY_PISO));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_FECHA_INGRESO))) {
                        fechaIngreso = c.getString(c.getColumnIndex(RegistroDb.KEY_FECHA_INGRESO));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_FECHA_SALIDA))) {
                        fechaSalida = c.getString(c.getColumnIndex(RegistroDb.KEY_FECHA_SALIDA));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_NOMBRE))) {
                        nombrePc = c.getString(c.getColumnIndex(RegistroDb.KEY_NOMBRE));
                    }
                    if (!c.isNull(c.getColumnIndex(RegistroDb.KEY_SERIAL))) {
                        serial = c.getString(c.getColumnIndex(RegistroDb.KEY_SERIAL));
                    }

                    Registro registro = new Registro(idRegistro,nombrePc,serial,fechaIngreso,fechaSalida,estado,piso);
                    list.add(registro);

                } while (c.moveToNext());

            }


        } catch (Exception e) {
            if (c != null && !c.isClosed()) {
                c.close();
            }
            Log.e(TAG, "Error cargando registros: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }


    public long insertarregistro(ContentValues cv) {
        return dbHelper.insert(RegistroDb.TABLE, cv);
    }


}
