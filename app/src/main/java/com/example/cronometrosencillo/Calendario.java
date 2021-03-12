package com.example.cronometrosencillo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Calendario extends AppCompatActivity {

    List<Fecha> listaDeFechas;
    ListView lvCalendario;
    AdaptadorFecha adaptadorFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        setTitle(R.string.calendario);
        this.listaDeFechas = (List<Fecha>) getIntent().getSerializableExtra("lista de fechas");
        lvCalendario = findViewById(R.id.lvCalendario);
        adaptadorFecha = new AdaptadorFecha(this, R.layout.item_fecha_adapter, (ArrayList<Fecha>) listaDeFechas);
        lvCalendario.setAdapter(adaptadorFecha);
        lvCalendario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MostrarFecha.class);
                intent.putExtra("fecha", listaDeFechas.get(position));
                startActivity(intent);
            }
        });
    }
}
