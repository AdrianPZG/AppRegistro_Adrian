package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botoncito;
    Button botoncito4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppRegistro_AdrianPG);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoncito=(Button)findViewById(R.id.botoncito);

        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);

            }
        });

        botoncito4=(Button)findViewById(R.id.botoncito4);

        botoncito4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(MainActivity.this, Login.class);
                startActivity(n);

            }
        });


    }
}


