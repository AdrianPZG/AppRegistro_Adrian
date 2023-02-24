package com.example.appandroid_adrian.contract;

import static com.example.appandroid_adrian.BD.UsuariosDBService.TABLE_PASS;
import static com.example.appandroid_adrian.BD.UsuariosDBService.TABLE_USRS;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.example.appandroid_adrian.json.MyInfo;
import com.example.appandroid_adrian.json.MyData;
import com.example.appandroid_adrian.json.MyInfo;

import java.io.Serializable;

public class UsuariosContract implements Serializable {
    public static final String TAG = "UsuariosContract";

    public static abstract class UsuarioEntry implements BaseColumns{
        public static final String USUARIO = "usuario";

        public static final String getCreateTable( ){
            String table = "CREATE TABLE " + TABLE_USRS + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "usuario TEXT NOT NULL UNIQUE," +
                    "psswd TEXT NOT NULL," +
                    "email TEXT NOT NULL," +
                    ")";
            return table;
        }
        public static ContentValues toContentValues(MyInfo info){
            ContentValues values = new ContentValues();
            values.put("usuario", info.getUsuario());
            values.put("psswd", info.getPassword());
            values.put("email", info.getCorreo());
            return values;
        }
    }

    public abstract static class MyDataEntry implements BaseColumns{
        public static final String getCreateTable( )
        {
            String table ="CREATE TABLE "+TABLE_PASS+"(" +
                    "id_pass INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "pass TEXT NOT NULL," +
                    "user_p TEXT NOT NULL," +
                    "id INTEGER NOT NULL)";
            return table;
        }
        public static ContentValues toContentValues(MyData myData)
        {
            ContentValues values = new ContentValues();
            values.put("pass", myData.getContra());
            values.put("user_p", myData.getUsuario());

            return values;
        }
    }
}
