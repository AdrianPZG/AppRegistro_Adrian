package com.example.appregistro_adrianpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appregistro_adrianpg.JSON.MyInfo;

import java.util.ArrayList;
import java.util.List;

public class Usser extends AppCompatActivity {
    private android.widget.ListView listView;
    private List<String> list;
    String aux;
    private TextView user;
    public static MyInfo myInfo= null;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Object object= null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usser);
        user = findViewById(R.id.Jungle);
        Intent intent = getIntent();




                        if( intent != null){
                            aux = intent.getStringExtra("Usuario");
                            if(aux != null && aux.length()>0){
                                user.setText(aux);
                            }
                            if( intent.getExtras() != null){
                                object = intent.getExtras().get("MyInfo");
                                if(object != null){
                                    if(object instanceof MyInfo){
                                        myInfo = (MyInfo) object;
                                        user.setText("Bienvenido " + myInfo.getNombre());

                    }
                }
            }
        }
        listView = (ListView) findViewById(R.id.listViewId);
        list = new ArrayList<String>();
        for( int i = 0; i < 1; i++)
        {
            list.add( String.format( "Contraseña %d" , i + 1 ) );

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_list_view,R.id.editText2, list );
        listView.setAdapter(arrayAdapter);
    }
}