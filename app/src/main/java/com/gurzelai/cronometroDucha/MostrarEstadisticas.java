package com.gurzelai.cronometroDucha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class MostrarEstadisticas extends AppCompatActivity {

    List<Fecha> listaDeFechas;
    TextView tvMensual, tvSemanal, tvDiario, tvAnual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_estadisticas);
        this.listaDeFechas = (List<Fecha>) getIntent().getSerializableExtra("lista");
        tvAnual = findViewById(R.id.tvAnual);
        tvMensual = findViewById(R.id.tvMensual);
        tvSemanal = findViewById(R.id.tvSemanal);
        tvDiario = findViewById(R.id.tvDiario);
        if (listaDeFechas.size() >= 1) {
            tvAnual.setText(calcularGastos("anual"));
            tvMensual.setText(calcularGastos("mensual"));
            tvSemanal.setText(calcularGastos("semanal"));
            tvDiario.setText(calcularGastos("diario"));
        }else{
            java.lang.String vacio = "No hay resultados";
            tvAnual.setTextSize(25);
            tvAnual.setText(vacio);
            tvMensual.setTextSize(25);
            tvMensual.setText(vacio);
            tvSemanal.setTextSize(25);
            tvSemanal.setText(vacio);
            tvDiario.setTextSize(25);
            tvDiario.setText(vacio);
        }
    }

    private java.lang.String calcularGastos(java.lang.String periodo) {
        int total = calcularTotal();

        Date fechaInicial = listaDeFechas.get(0).getDate();
        Date fechaFinal = listaDeFechas.get(listaDeFechas.size() - 1).getDate();
        int diasDeDiferencia = fechasDiferenciaEnDias(fechaInicial, fechaFinal);
        switch (periodo) {
            case "anual":
                if (diasDeDiferencia >= 365) {
                    int cantidadDeAnios = diasDeDiferencia / 365;
                    total = (total / cantidadDeAnios);
                } else {
                    total = (diasDeDiferencia == 0) ? total * 365 : total / diasDeDiferencia;
                }
                break;
            case "mensual":
                if (diasDeDiferencia >= 30) {
                    int cantidadDeMeses = diasDeDiferencia / 30;
                    total = (total / cantidadDeMeses);
                } else {
                    total = (diasDeDiferencia == 0) ? total * 30 : total / diasDeDiferencia;
                }
                break;
            case "semanal":
                if (diasDeDiferencia >= 7) {
                    int cantidadDeSemanas = diasDeDiferencia / 7;
                    total = (total / cantidadDeSemanas);
                } else {
                    total = (diasDeDiferencia == 0) ? total * 7 : total / diasDeDiferencia;
                }
                break;
            case "diario":
                total = (diasDeDiferencia == 0) ? total : total / diasDeDiferencia;
                break;
        }
        return java.lang.String.valueOf(total) + " €";

    }

    private int calcularTotal() {
        int total = 0;
        for (Fecha l : listaDeFechas) {
            for (Ducha d : l.getDuchas()) {
                total = total + d.getPrecio();
            }
        }
        return total;
    }

    public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        java.lang.String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        java.lang.String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }


}