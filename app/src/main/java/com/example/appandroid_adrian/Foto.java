package com.example.appandroid_adrian;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Foto extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private Button button, regresar;
    protected ActivityResultLauncher<Intent> someActivityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        imageView = findViewById( R.id.imageViewId );
        button = findViewById( R.id.click );
        regresar = findViewById( R.id.regresar );
        takePhotoRegister( );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
                someActivityResultLauncher.launch( cameraIntent );
            }
        });



        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Foto.this, Opciones.class);
                startActivity(intent);
            }
        });
    }

    public void takePhotoRegister( )
    {
        someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if (result.getResultCode() == Activity.RESULT_OK)
                        {
                            Intent data = result.getData();
                            if( data != null && data.getExtras() != null)
                            {
                                Bitmap photo = (Bitmap) data.getExtras().get( "data" );
                                imageView.setImageBitmap(photo);
                            }
                        }
                    }
                });
    }


}