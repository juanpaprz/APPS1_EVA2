package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtVwDatos;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        String sNom = intent.getStringExtra("NOMBRE");
        String sApe = intent.getStringExtra("APELLIDO");
        int iEdad = intent.getIntExtra("EDAD", 0);
        String sSexo = intent.getStringExtra("SEXO");
        txtVwDatos = findViewById(R.id.txtVwDatos);
        txtVwDatos.append("Nombre:\n");
        txtVwDatos.append(sNom + "\n");
        txtVwDatos.append("Apellido:\n");
        txtVwDatos.append(sApe + "\n");
        txtVwDatos.append("Edad:\n");
        txtVwDatos.append(iEdad + "\n");
        txtVwDatos.append("Seco:\n");
        txtVwDatos.append(sSexo + "\n");
    }


    public void onClickSal(View v){
        finish();
    }

}