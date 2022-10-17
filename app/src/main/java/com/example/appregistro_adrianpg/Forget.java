package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appregistro_adrianpg.JSON.MyInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Forget extends AppCompatActivity {
    private List<MyInfo> list;
    public static String TAG = "mensaje";
    String json = null;
    public static String correoForgot,passForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        EditText emailcito = findViewById(R.id.forgetEmail);
        EditText  pswd = findViewById(R.id.forgetPass);
        EditText confirm = findViewById(R.id.confirmPass);
        Button restablecer = findViewById(R.id.change);
        Button volver = findViewById(R.id.back);
        Read();
        json2List(json);

        restablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correoForgot = String.valueOf(emailcito.getText());
                passForgot = String.valueOf(pswd.getText());
                Change();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Forget.this, Login.class);
                startActivity(i);
            }
        });
    }

    public boolean Read(){
        if(!isFileExists()){
            return false;
        }
        File file = getFile();
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        bytes = new byte[(int)file.length()];
        try{
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes);
            json = new String(bytes);
            Log.d(TAG, json);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public void json2List(String json){
        Gson gson = null;
        String mensaje = null;
        if(json == null || json.length() == 0){
            Toast.makeText(getApplicationContext(), "Error json null or empty", Toast.LENGTH_SHORT).show();
            return;
        }
        gson = new Gson();
        Type listType = new TypeToken<ArrayList<MyInfo>>(){}.getType();
        list = gson.fromJson(json, listType);
        if(list == null || list.size() == 0){
            Toast.makeText(getApplicationContext(), "Error list is null or empty", Toast.LENGTH_LONG).show();
            return;
        }
    }
    private File getFile(){
        return new File(getDataDir() , Registro.archivo);
    }

    private boolean isFileExists(){
        File file = getFile();
        if(file == null){
            return false;
        }
        return file.isFile() && file.exists();
    }
    public void Change(){
        int i = 0;
        for(MyInfo myInfo : list){
            if (myInfo.getCorreo().equals(correoForgot)){
                Intent intent = new Intent(Forget.this, Usser.class);
                startActivity(intent);
                i = 1;

            }
        }
        if (i == 0){
            Toast.makeText(getApplicationContext(), "El correo ingresado no existe o es incorrecto ",Toast.LENGTH_LONG).show();
        }
    }

}