package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appregistro_adrianpg.JSON.MyInfo;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {
    private Button registrarse;
    private static final String TAG = "MainActivity";
    public static final String archivo = "archivo.json";
    String json = null;
    String email = null;
    String password=null;
    String username = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        List<MyInfo> list = new ArrayList<MyInfo>();
        registrarse = findViewById(R.id.registrarse);
        Button registrarse = findViewById(R.id.registrarse);
        Button logearse = findViewById(R.id.logearse);
        EditText correo = findViewById(R.id.email2);
        EditText pass = findViewById(R.id.password2);
        EditText name = findViewById(R.id.username2);

        logearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Login.class);
                startActivity(intent);
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyInfo info = new MyInfo();
                info.setCorreo(String.valueOf(correo.getText()));
                info.setContraseña(String.valueOf(pass.getText()));
                info.setNombre(String.valueOf(name.getText()));

                email = String.valueOf(name.getText());
                password = String.valueOf(pass.getText());
                username = String.valueOf(correo.getText());


                //Validaciones
                if (correo.equals("") || pass.equals("") || name.equals("")) {
                    Log.d(TAG, "vacio");
                    Log.d(TAG, email);
                    Log.d(TAG, password);
                    Log.d(TAG, username);
                    Toast.makeText(getApplicationContext(), "LLena los campos", Toast.LENGTH_LONG).show();
                } else {
                    if (validarEmail(email)) {
                        if (list.isEmpty()) {
                            Log.d(TAG, "lleno");
                            info.setNombre(username);
                            info.setContraseña(Metodos.bytesToHex(Metodos.createSha1(String.valueOf(pass.getText()))));
                            info.setCorreo(String.valueOf(correo.getText()));
                            List2Json(info, list);
                        } else {
                            if (usuarios(list, username)) {
                                Log.d(TAG, "esta ocupado mano");
                                Toast.makeText(getApplicationContext(), "El nombre de usuario está ocupado, cambialo", Toast.LENGTH_LONG).show();
                            } else {
                                info.setNombre(username);
                                info.setContraseña(Metodos.bytesToHex(Metodos.createSha1(String.valueOf(pass.getText()))));
                                info.setCorreo(String.valueOf(correo.getText()));
                                List2Json(info, list);
                            }
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Introduzca un correo válido", Toast.LENGTH_LONG).show();
                    }
                }

                List2Json(info,list);
                if (name.length() == 0){
                    Toast.makeText(getApplicationContext(), "Debes poner un nombre valido", Toast.LENGTH_SHORT).show();
                }
                if (pass.length() == 0){
                    Toast.makeText(getApplicationContext(), "Debes poner una contraseña valida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validarEmail(String email2){
        boolean bandera;
        if(email2.isEmpty()){
            bandera=false;
        }else{
            if(PatternsCompat.EMAIL_ADDRESS.matcher(email2).matches()){
                bandera=true;
            }else{
                bandera=false;
            }
        }
        return bandera;
    }
    public boolean usuarios(List<MyInfo> list,String username){
        boolean bandera = false;
        for(MyInfo informacion : list){
            if(informacion.getNombre().equals(username)){
                bandera=true;
            }
        }
        return bandera;
    }


    public void Objet2Json(MyInfo info){
        Gson gson = null;
        String json = null;
        String mensaje = null;
        gson = new Gson();
        json = gson.toJson(info);
        if(json != null){
            Log.d(TAG, json);
            mensaje ="object2Json OK";
        }
        else{
            mensaje = "Error object2Json";
        }
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }
    public void List2Json(MyInfo info, List<MyInfo> list){
        Gson gson = null;
        String json = null;
        gson = new Gson();
        list.add(info);
        json = gson.toJson(list, ArrayList.class);
        if(json == null){
            Log.d(TAG, "Error json");
        }
        else{
            Log.d(TAG, json);
            writeFile(json);
        }
        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
    }
    private boolean writeFile(String text){
        File file = null;
        FileOutputStream fileOutputStream = null;
        try{
            file = getFile();
            fileOutputStream = new FileOutputStream( file );
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            Log.d(TAG, "Listo");
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    private File getFile(){
        return new File(getDataDir(),archivo);
    }
}

