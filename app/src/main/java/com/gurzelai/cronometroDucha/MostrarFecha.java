package com.gurzelai.cronometroDucha;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MostrarFecha extends AppCompatActivity {

    final int CODE_COLORES = 1;

    ListView lvDuchas;
    Fecha f;
    AdaptadorDucha adapter;
    FloatingActionButton btnColoresDuchas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_fecha);
        f = (Fecha) getIntent().getSerializableExtra("fecha");
        getSupportActionBar().setTitle("Duchas del dia "+f.getFechaString());
        lvDuchas = (ListView) findViewById(R.id.lvDuchas);
        lvDuchas.setAdapter(adapter = new AdaptadorDucha(getApplicationContext(), R.layout.item_ducha_adapter, (ArrayList<Ducha>) f.getDuchas()));
        btnColoresDuchas = (FloatingActionButton) findViewById(R.id.btnColoresDuchas);
        btnColoresDuchas.setOnClickListener(view -> abrirIntent("opciones"));
    }

    private void abrirIntent(java.lang.String optcionIntent) {
        Intent intent;
        switch (optcionIntent){
            case "opciones":
                intent = new Intent(getApplicationContext(), OpcionesColoresDuchas.class);
                startActivityForResult(intent, CODE_COLORES);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CODE_COLORES:
                if(resultCode== RESULT_OK){
                    int color = Integer.valueOf(data.getStringExtra("color"));
                    int cantidad = Integer.valueOf(data.getStringExtra("cantidad"));
                    adapter.setColor(color);
                    adapter.setCantidad(cantidad);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}