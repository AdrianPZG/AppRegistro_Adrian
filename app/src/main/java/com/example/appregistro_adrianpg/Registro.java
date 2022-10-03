package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Registro extends AppCompatActivity {

    Button botoncito2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        botoncito2=(Button)findViewById(R.id.botoncito2);

        botoncito2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registro.this, Login.class);
                startActivity(i);

            }
        });
    }
}