package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int CODIGO_SEGUN = 1000;
    final static int CODIGO_CONTACTOS = 2000;
    final static int CODIGO_FOTOS = 3000;

    Intent intent, intentCont, intentFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentFoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public void onClick(View v){
        intent.putExtra("DATOS", "información enviada desde principal");
        startActivityForResult(intent, CODIGO_SEGUN);
    }

    public void onClickCont(View v){
        startActivityForResult(intentCont, CODIGO_CONTACTOS);
    }

    public void onClickFoto(View v){
        startActivityForResult(intentFoto, CODIGO_FOTOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CODIGO_SEGUN:
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this,data.getStringExtra("VALOR"),Toast.LENGTH_SHORT).show();
                }
                break;
            case CODIGO_CONTACTOS:
            case CODIGO_FOTOS:
                if (resultCode == Activity.RESULT_OK) {
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}