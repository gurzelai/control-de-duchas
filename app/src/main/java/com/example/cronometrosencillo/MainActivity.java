package com.example.cronometrosencillo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final int CODE_TIEMPO = 1;

    ImageButton btnDucha;
    TextView tvDucha;
    Button btnCalendario;
    ListaDeFechas listaDeFechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MetodosEstaticos.pantallaCompleta(this);
        btnDucha = findViewById(R.id.btnDucha);
        tvDucha = findViewById(R.id.tvDucha);
        btnCalendario = findViewById(R.id.btnCalendario);
        btnDucha.setOnClickListener(view -> abrirIntent("cronometro"));
        btnCalendario.setOnClickListener(view -> abrirIntent("calendario"));

        listaDeFechas = new ListaDeFechas();
        listaDeFechas.add((new Ducha(new Tiempo(2, 30)))); //una fecha siempre tendra una fucha por lo menos
        listaDeFechas.add((new Ducha(new Tiempo(4, 26))));
        listaDeFechas.add((new Ducha(new Tiempo(7, 34))));
        listaDeFechas.add((new Ducha(new Tiempo(1, 23))));
        listaDeFechas.add((new Ducha(new Tiempo(4, 49))));
        listaDeFechas.add((new Ducha(new Tiempo(2, 45))));
        listaDeFechas.add((new Ducha(new Tiempo(8, 12))));
        Button btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(v->System.exit(0));
    }

    private void abrirIntent(String opcion) {
        Intent intent;
        switch (opcion) {
            case "calendario":
                intent = new Intent(getApplicationContext(), Calendario.class);
                intent.putExtra("lista de fechas", (Serializable) listaDeFechas.getFechas());
                startActivity(intent);
                break;
            case "cronometro":
                intent = new Intent(getApplicationContext(), Cronometro.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentResultado) {
        super.onActivityResult(requestCode, resultCode, intentResultado);

        switch (requestCode) {
            case (CODE_TIEMPO): {
                Tiempo t = (Tiempo) intentResultado.getSerializableExtra("tiempo");
                listaDeFechas.add(new Ducha(t)); // si es la primera se creará la fecha de hoy
                break;

            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void guardar() {
        try {
            FileOutputStream f = null;
            f = openFileOutput("data.dat", Context.MODE_PRIVATE); //MODE PRIVATE
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(listaDeFechas);

            f.close();
            o.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}