package com.gurzelai.cronometroDucha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ElegirPais extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView  sv;
    ListView lvPaises;
    List<String> paises;
    AdaptadorPais adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_pais);

        sv = findViewById(R.id.svPais);
        sv.setOnQueryTextListener(this);
        lvPaises = findViewById(R.id.lvPaises);
        inicializar();
        lvPaises.setAdapter(adapter = new AdaptadorPais(getApplicationContext(), R.layout.item_pais_adapter, paises));
    }

    private void inicializar() {
        paises = new ArrayList<>();
        paises.add("España");
        paises.add("EEUU");
        paises.add("China");
        paises.add("Canadá");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filtrar(text);
        return false;
    }
}