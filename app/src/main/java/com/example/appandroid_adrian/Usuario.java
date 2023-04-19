package com.example.appandroid_adrian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appandroid_adrian.MyAdapter.MyAdapter;
import com.example.appandroid_adrian.MyDesUtil.MyDesUtil;
import com.example.appandroid_adrian.json.MyData;
import com.example.appandroid_adrian.json.MyInfo;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends AppCompatActivity {

    private List<MyInfo> list;
    public MyDesUtil myDesUtil = new MyDesUtil().addStringKeyBase64(Registro.KEY);
    public static String TAG = "mensaje";
    public static String json = null;
    private ListView listView;
    private List<MyData> listo;
    String aux;
    public boolean bandera = false;
    public int pos = 0;
    public static MyInfo myInfo = null;
    EditText editText, editText1, editText2;
    Button button, button1, button2, button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Object object = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getExtras() != null) {
                object = intent.getExtras().get("Objeto");
                if (object != null) {
                    if (object instanceof MyInfo) {
                        myInfo = (MyInfo) object;
                    }
                }
            }
        }

        list = new ArrayList<>();
        list = Login.list;
        editText = findViewById(R.id.editTextUsser);
        editText1 = findViewById(R.id.editTextTextPass);
        button = findViewById(R.id.eliminar);
        button1 = findViewById(R.id.editar);
        button2 = findViewById(R.id.buttonAd);
        button3 = findViewById(R.id.options);
        listView = (ListView) findViewById(R.id.listViewId);
        listo = new ArrayList<MyData>();
        listo = myInfo.getContras();
        MyAdapter myAdapter = new MyAdapter(listo, getBaseContext());
        listView.setAdapter(myAdapter);
        button.setEnabled(false);
        button1.setEnabled(false);


        if (listo.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Para agregar una contraseña de clic en el menú o en el (+)", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Llene los campos", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(getApplicationContext(), "Da click en las contraseñas para editar o eliminar", Toast.LENGTH_LONG).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(listo.get(i).getUsuario());
                editText1.setText(listo.get(i).getContra());
                pos = i;
                button.setEnabled(true);
                button1.setEnabled(true);
                Toast.makeText(getApplicationContext(), "Para guardar los cambios de click en guardar cambios", Toast.LENGTH_LONG).show();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listo.remove(pos);
                myInfo.setContras(listo);
                MyAdapter myAdapter = new MyAdapter(listo, getBaseContext());
                listView.setAdapter(myAdapter);
                editText.setText("");
                editText1.setText("");
                Toast.makeText(getApplicationContext(), "Se eliminó la contraseña", Toast.LENGTH_LONG).show();
                button.setEnabled(false);
                button1.setEnabled(false);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = String.valueOf(editText.getText());
                String contra = String.valueOf(editText1.getText());
                if (usr.equals("") || contra.equals("")) {
                    Toast.makeText(getApplicationContext(), "Llene los campos", Toast.LENGTH_LONG).show();
                } else {
                    listo.get(pos).setUsuario(usr);
                    listo.get(pos).setContra(contra);
                    myInfo.setContras(listo);
                    MyAdapter myAdapter = new MyAdapter(listo, getBaseContext());
                    listView.setAdapter(myAdapter);
                    editText.setText("");
                    editText1.setText("");
                    Toast.makeText(getApplicationContext(), "Se editó la contraseña", Toast.LENGTH_LONG).show();
                    button.setEnabled(false);
                    button1.setEnabled(false);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = String.valueOf(editText.getText());
                String contra = String.valueOf(editText1.getText());
                if (usr.equals("") || contra.equals("")) {
                    Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
                } else {
                    MyData myData = new MyData();
                    myData.setContra(contra);
                    myData.setUsuario(usr);
                    listo.add(myData);
                    MyAdapter myAdapter = new MyAdapter(listo, getBaseContext());
                    listView.setAdapter(myAdapter);
                    editText.setText("");
                    editText1.setText("");
                    Toast.makeText(getApplicationContext(), "Se agregó la contraseña", Toast.LENGTH_LONG).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Usuario.this, Opciones.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu Principal) {
        getMenuInflater().inflate(R.menu.main_menu, Principal);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            String usr = String.valueOf(editText.getText());
            String contra = String.valueOf(editText1.getText());
            if (usr.equals("") || contra.equals("")) {
                Toast.makeText(getApplicationContext(), "Llene los campos", Toast.LENGTH_LONG).show();
            } else {
                MyData myData = new MyData();
                myData.setContra(contra);
                myData.setUsuario(usr);
                listo.add(myData);
                MyAdapter myAdapter = new MyAdapter(listo, getBaseContext());
                listView.setAdapter(myAdapter);
                editText.setText("");
                editText1.setText("");
                Toast.makeText(getApplicationContext(), "Se agregó la contraseña", Toast.LENGTH_LONG).show();
            }
            return true;
        }
        if (id == R.id.item2) {
            int i = 0;
            for (MyInfo inf : list) {
                if (myInfo.getUsuario().equals(inf.getUsuario())) {
                    list.get(i).setContras(listo);
                }
                i++;
            }
            List2Json(myInfo, list);
            return true;
        }
        if (id == R.id.item3) {
            Intent intent = new Intent(Usuario.this, Login.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void List2Json(MyInfo info, List<MyInfo> list) {
        Gson gson = null;
        String json = null;
        gson = new Gson();
        json = gson.toJson(list, ArrayList.class);
        if (json == null) {
            Log.d(TAG, "Error json");
        } else {
            Log.d(TAG, json);
            json = myDesUtil.cifrar(json);
            Log.d(TAG, json);
            writeFile(json);
        }
        Toast.makeText(getApplicationContext(), "Guardado", Toast.LENGTH_LONG).show();
    }


    private boolean writeFile(String text) {
        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            file = getFile();
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            Log.d(TAG, "Hola");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private File getFile() {
        return new File(getDataDir(), Registro.archivo);
    }



}