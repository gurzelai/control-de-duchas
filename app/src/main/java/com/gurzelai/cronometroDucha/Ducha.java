package com.gurzelai.cronometroDucha;

import java.io.Serializable;
import java.util.Calendar;

public class Ducha implements Serializable {

    final int PRECIO_MINUTO_DE_AGUA = 1;

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

    public int getPrecio(){
        return (((duracion.getMinutos()*60)+duracion.getSegundos())/60) * PRECIO_MINUTO_DE_AGUA;
    }
    public String getMomento(){
        return hora+":"+minutos;
    }

    public Tiempo getDuracion(){
        return duracion;
    }
}
