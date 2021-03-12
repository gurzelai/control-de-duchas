package com.example.cronometrosencillo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class AdaptadorFecha extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Fecha> fechas;
    public AdaptadorFecha(Context context, int layout, ArrayList<Fecha> fechas){
        this.context = context;
        this.layout = layout;
        this.fechas = fechas;
    }

    @Override
    public int getCount() {
        return this.fechas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.fechas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.item_fecha_adapter, null);
        // Valor actual según la posición

        String dia  = fechas.get(position).getFecha();

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView tvFecha = (TextView) v.findViewById(R.id.tvFecha);
        tvFecha.setText(dia);
        TextView tvCantidad = (TextView) v.findViewById(R.id.tvCantidad);
        int cantidadDeDuchasDeEsteDia = fechas.get(position).getDuchas().size();
        tvCantidad.setText(String.valueOf(cantidadDeDuchasDeEsteDia));
        //Devolvemos la vista inflada
        return v;
    }
}
