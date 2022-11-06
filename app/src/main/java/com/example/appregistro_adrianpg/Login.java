package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


import com.example.appregistro_adrianpg.JSON.MyInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private List<MyInfo> list;
    public static String TAG = "mensaje";
    String json = null;
    public static String usr, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button1 = findViewById(R.id.button1);
        Button olvidar = findViewById(R.id.forget);
        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.pass);
        Read();
        json2List(json);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr = String.valueOf(email.getText());
                passw = String.valueOf(pass.getText());
                acceso();
            }
        });

        olvidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Forget.class);
                startActivity(i);
            }
        });
    }

    public boolean Read() {
        if (!isFileExits()) {
            return false;
        }
        File file = getFile();
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        bytes = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes);
            json = new String(bytes);
            Log.d(TAG, json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void json2List(String json) {
        Gson gson = null;
        String mensaje = null;
        if (json == null || json.length() == 0) {
            Toast.makeText(getApplicationContext(), "Error json null or empty", Toast.LENGTH_SHORT).show();
            return;
        }
        gson = new Gson();
        Type listType = new TypeToken<ArrayList<MyInfo>>() {
        }.getType();
        list = gson.fromJson(json, listType);
        if (list == null || list.size() == 0) {
            Toast.makeText(getApplicationContext(), "Error list is null or empty", Toast.LENGTH_LONG).show();
            return;
        }
    }

    private File getFile() {
        return new File(getDataDir(), Registro.archivo);
    }

    private boolean isFileExits() {
        File file = getFile();
        if (file == null) {
            return false;
        }
        return file.isFile() && file.exists();
    }

    public void acceso(){
        int i=0;
        if (usr.equals("") || passw.equals("")){
            Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
        }
        for(MyInfo myInfo : list){
            if(myInfo.getCorreo().equals(usr) && myInfo.getContraseña().equals(passw)){
                Intent intent = new Intent(Login.this, Usser.class);
                intent.putExtra( "MyInfo" , myInfo );
                startActivity(intent);
                i=1;
            }
        }
        if(i==0){
            Toast.makeText(getApplicationContext(), "El usuario o contraseña son incorrectos", Toast.LENGTH_LONG).show();
            Log.d(TAG, passw);
        }
    }
}






