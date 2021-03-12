package com.gurzelai.cronometroDucha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MostrarEstadisticas extends AppCompatActivity {

    List<Fecha> listaDeFechas;
    TextView tvMensual, tvSemanal, tvDiario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_estadisticas);
        this.listaDeFechas = (List<Fecha>) getIntent().getSerializableExtra("lista de fechas");

        tvMensual = findViewById(R.id.tvMensual);
        tvMensual.setText(calcularGastos("mensual"));
    }

    private String calcularGastos(String mensual) {
        int total = calcularTotal();
        String gastosTotales = null;

        for(Fecha l : listaDeFechas){


        }


        return gastosTotales;
    }

    private int calcularTotal() {

        int total = 0;





        return total;
    }
}