package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Login extends AppCompatActivity {

    Button botoncito3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botoncito3=(Button)findViewById(R.id.botoncito3);

        botoncito3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);

            }
        });
    }
}
