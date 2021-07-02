package com.example.eva1_12_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ClimaAdaptador extends ArrayAdapter<Clima> {
    private Context context;
    private int layout;
    private List<Clima> cCiudades;

    public ClimaAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.cCiudades = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Fila: No existe
        if(convertView == null){ //primera vez que se muestra, no exixte
            convertView = ((Activity) context).getLayoutInflater().inflate(layout, parent, false);
        } /*else{

        }*/

        ImageView imgVwClima;
        TextView txtVwCd, txtVwTemp, txtVwDesc;

        imgVwClima = convertView.findViewById(R.id.imgVwClima);
        txtVwCd = convertView.findViewById(R.id.txtVwCd);
        txtVwTemp = convertView.findViewById(R.id.txtVwTemp);
        txtVwDesc = convertView.findViewById(R.id.txtVwDesc);

        Clima climaCiudad = cCiudades.get(position);
        imgVwClima.setImageResource(climaCiudad.getImagen());
        txtVwCd.setText(climaCiudad.getCiudad());
        txtVwTemp.setText(climaCiudad.getTemp() + " °C");
        txtVwDesc.setText(climaCiudad.getDesc());

        /*imgVwClima.setImageResource(cCiudades[position].getImagen());
        txtVwCd.setText(cCiudades[position].getCiudad());
        txtVwTemp.setText(cCiudades[position].getTemp() + " °C");
        txtVwDesc.setText(cCiudades[position].getDesc());*/

        return convertView;
    }
}
