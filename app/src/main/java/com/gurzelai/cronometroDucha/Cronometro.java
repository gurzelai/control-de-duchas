package com.gurzelai.cronometroDucha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Cronometro extends AppCompatActivity {

    Chronometer cronometro;
    FloatingActionButton btnParar, btnTerminar;
    boolean activo;
    private long ultimoPause;
    int minutosParaPausar;
    long baseInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        pantallaCompleta();
        btnParar = (FloatingActionButton) findViewById(R.id.btnParar);
        btnTerminar = (FloatingActionButton) findViewById(R.id.btnTerminar);
        btnTerminar.setOnClickListener(view -> acabar());
        cronometro = (Chronometer) findViewById(R.id.viewCronometro);
        cronometro.setBase(SystemClock.elapsedRealtime());
        baseInicial = cronometro.getBase();
        cronometro.start();
        activo = true;
        btnParar.setOnClickListener(view -> cambiarEstado());
    }

    private void pantallaCompleta() {
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }


    private void cambiarEstado() {
        if (activo) {
            ultimoPause = SystemClock.elapsedRealtime();
            cronometro.stop();
            btnParar.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.materialcolorpicker__green)));
            activo = false;

        } else {
            cronometro.setBase(cronometro.getBase() + SystemClock.elapsedRealtime() - ultimoPause);
            cronometro.start();
            btnParar.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.materialcolorpicker__blue)));
            activo = true;
        }
    }

    private void acabar() {
        cronometro.stop();
        long time;
        long a = cronometro.getBase();
        if (!activo) cronometro.setBase(cronometro.getBase() + SystemClock.elapsedRealtime() - ultimoPause);
        time = SystemClock.elapsedRealtime() - cronometro.getBase();
        int m = (int) time / 60000;
        int s = (int) (time - m * 60000) / 1000;
        Intent resultIntent = getIntent();
        resultIntent.putExtra("tiempo", new Tiempo(m, s));
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public int getMinutos(){
        long time;
        long a = cronometro.getBase();
        if (!activo) cronometro.setBase(cronometro.getBase() + SystemClock.elapsedRealtime() - ultimoPause);
        time = SystemClock.elapsedRealtime() - cronometro.getBase();
        int m = (int) time / 60000;
        return m;
    }
}