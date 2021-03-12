package com.gurzelai.cronometroDucha;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class MetodosEstaticos {

    public static String TomarFechaDeHoyString() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anio = c.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + anio;


    }


}
