package com.gurzelai.cronometroDucha;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MetodosEstaticos {

    public static String TomarFechaDeHoy() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anio = c.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + anio;
    }

    public static void pantallaCompleta(AppCompatActivity v) {
        View decorView = v.getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
