package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Usser extends AppCompatActivity {

    TextView nombre, correo, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usser);

        nombre = findViewById(R.id.textito1);
        correo = findViewById(R.id.textito2);
        contra = findViewById(R.id.textito3);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        String username = intent.getStringExtra("username");

        correo.setText(email);
        contra.setText(password);
        nombre.setText(username);


    }
}