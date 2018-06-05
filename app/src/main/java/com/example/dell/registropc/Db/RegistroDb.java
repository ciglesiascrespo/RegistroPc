package com.example.dell.registropc.Db;

/**
 * Created by dell on 05/06/2018.
 */

public class RegistroDb {
    public static final String TABLE = "registros";

    public static final String KEY_ID = "id_registro";
    public static final String KEY_NOMBRE = "nombre";
    public static final String KEY_SERIAL = "serial";
    public static final String KEY_FECHA_INGRESO = "fecha_ingreso";
    public static final String KEY_FECHA_SALIDA = "fecha_salida";
    public static final String KEY_ESTADO = "estado";
    public static final String KEY_PISO = "nombre";


    public static String getCreateTable() {
        String query = "CREATE TABLE `" + TABLE + "` ( `" + KEY_ID + "` INTEGER, `" + KEY_NOMBRE + "` TEXT, `" +
                KEY_SERIAL + "` TEXT, `" + KEY_FECHA_INGRESO + "` TEXT, `" + KEY_FECHA_SALIDA + "` TEXT, `" + KEY_ESTADO + "` INTEGER, `" +
                KEY_PISO + "` INTEGER, " +
                "PRIMARY KEY(`" + KEY_ID + "`) )";

        return query;
    }
}
