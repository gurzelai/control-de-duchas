package com.gurzelai.cronometroDucha;

import java.util.Calendar;

public class MetodosEstaticos {

    public static String TomarFechaDeHoyString() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anio = c.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + anio;
    }


}
