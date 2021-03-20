package com.gurzelai.cronometroDucha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdaptadorPais extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> paises;
    private ArrayList<String> paisesCopia;

    public AdaptadorPais(Context context, int layout, List<String> paises){
        this.context = context;
        this.layout = layout;
        this.paises = paises;
        paisesCopia = new ArrayList<String>();
        paisesCopia.addAll(paises);
    }

    @Override
    public int getCount() {
        return this.paises.size();
    }

    @Override
    public Object getItem(int position) {
        return this.paises.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v= layoutInflater.inflate(R.layout.item_pais_adapter, null);
        TextView tvPais = v.findViewById(R.id.tvPais);
        tvPais.setText(paises.get(position).toString());
        return v;
    }


    //Funcion filtrar
    public void filtrar(String pais){
        pais = pais.toLowerCase(Locale.getDefault());
        paises.clear();
        if(pais.length()==0){
            paises.addAll(paisesCopia);
        }   else{
            for(String s : paisesCopia){
                if(s.toLowerCase(Locale.getDefault()).contains(pais)){
                    paises.add(s);
                }
            }
        }
    }
}
