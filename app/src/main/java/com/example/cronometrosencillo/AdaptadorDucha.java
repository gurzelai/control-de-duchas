package com.example.cronometrosencillo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorDucha extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Ducha> duchas;
    int color;
    int cantidad;

    public AdaptadorDucha(Context context, int layout, ArrayList<Ducha> duchas) {
        this.context = context;
        this.layout = layout;
        this.duchas = duchas;
        cantidad = -1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.item_ducha_adapter, null);

        Ducha d = duchas.get(position);
        TextView tvMomento = (TextView) v.findViewById(R.id.tvMomento);
        TextView tvDuracion = (TextView) v.findViewById(R.id.tvDuracion);
        tvMomento.setText(d.getMomento());
        tvDuracion.setText(d.getDuracion().toString());
        if(d.getDuracion().getMinutos() == cantidad){
            v.setBackgroundColor(color);
        }
        else{
            v.setBackgroundColor(Color.BLACK);
            tvMomento.setTextColor(Color.WHITE);
            tvDuracion.setTextColor(Color.WHITE);
        }
        v.getBackground().setAlpha(60);

        return v;
    }

    public void setColor(int color) {
        this.color = color;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int getCount() {
        return this.duchas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.duchas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


}
