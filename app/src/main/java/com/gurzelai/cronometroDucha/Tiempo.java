package com.gurzelai.cronometroDucha;

import java.io.Serializable;

public class Tiempo implements Serializable {

    int minutos;
    int segundos;

    public Tiempo(int minutos, int segundos) {
        this.minutos = minutos;
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        // return  (minutos < 10 ? "0"+minutos: minutos)+":"+ (segundos < 10 ? "0"+segundos: segundos);
        return minutos + ":" + (segundos < 10 ? "0" + segundos : segundos) + " min";
    }

    public int getMinutos() {
        return minutos;
    }
}


