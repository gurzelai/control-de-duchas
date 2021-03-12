package com.example.cronometrosencillo;

import java.io.Serializable;
import java.util.Calendar;

public class Ducha implements Serializable {

    int anio, mes, dia, hora, minutos;
    Tiempo duracion;

    public Ducha(Tiempo duracion){
        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH);
        anio = c.get(Calendar.YEAR);
        hora = c.get(Calendar.HOUR_OF_DAY);
        minutos = c.get(Calendar.MINUTE);
        this.duracion = duracion;
    }


    public String getMomento(){
        return hora+":"+minutos;
    }

    public Tiempo getDuracion(){
        return duracion;
    }
}
