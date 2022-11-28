package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appregistro_adrianpg.JSON.MyInfo;
import com.example.appregistro_adrianpg.JSON.MyInfo2;

import java.util.ArrayList;
import java.util.List;

public class Usser extends AppCompatActivity {
    private TextView usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usser);
        String aux = null;
        MyInfo info = null;
        Object object = null;
        usuario = findViewById(R.id.Jungle);
        Intent intent = getIntent();
        if( intent != null)
        {
            aux = intent.getStringExtra("Nombre" );
            if( aux != null && aux.length()> 0 )
            {
                usuario.setText(aux);
            }
            if( intent.getExtras() != null ) {
                object = intent.getExtras().get("MyInfo");
                if (object != null) {
                    if (object instanceof MyInfo) {
                        info = (MyInfo) object;
                        usuario.setText(info.getNombre());
                    }
                }
            }
        }






    }
}