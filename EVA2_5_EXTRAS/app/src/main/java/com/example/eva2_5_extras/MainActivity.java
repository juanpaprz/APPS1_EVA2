package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtNom, edtTxtApe, edtTxtEdad;
    RadioGroup rdGrpSexo;
    RadioButton rdBtnSelect;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTxtNom = findViewById(R.id.edtTxtNom);
        edtTxtApe = findViewById(R.id.edtTxtApe);
        edtTxtEdad = findViewById(R.id.edtTxtEdad);
        rdGrpSexo = findViewById(R.id.rdGrpSexo);
    }

    public void onClick(View v){
        intent.putExtra("NOMBRE", edtTxtNom.getText().toString());
        intent.putExtra("APELLIDO", edtTxtApe.getText().toString());
        intent.putExtra("EDAD", Integer.parseInt(edtTxtEdad.getText().toString()));
        rdBtnSelect = findViewById(rdGrpSexo.getCheckedRadioButtonId());
        intent.putExtra("SEXO", rdBtnSelect.getText());
        startActivity(intent);
    }

}