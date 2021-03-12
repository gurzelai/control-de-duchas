package com.example.cronometrosencillo;

import java.util.Calendar;

public class MetodosEstaticos {

    public static String TomarFechaDeHoy() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anio = c.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + anio;
    }
}
