package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int PERMISO_LLAMAR = 100;
    EditText edtTextTel;
    Intent intent;
    Button btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = findViewById(R.id.btnLlamar);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "NO TIENES PERMISOS", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, PERMISO_LLAMAR);
            btnLlamar.setEnabled(false);
        } else {
            Toast.makeText(this, "TIENES PERMISOS", Toast.LENGTH_SHORT).show();
            btnLlamar.setEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTextTel = findViewById(R.id.edtTxtTel);
    }

    public void onClick(View v){
        String sTel = "tel:" + edtTextTel.getText().toString();
        intent = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISO_LLAMAR:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnLlamar.setEnabled(true);
                    Toast.makeText(this, "PERMISO CONCEDIDO", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "PERMISO DENEGADO", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}