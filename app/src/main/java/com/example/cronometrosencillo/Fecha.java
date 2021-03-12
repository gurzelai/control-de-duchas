package com.example.cronometrosencillo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fecha implements Serializable {

    String fecha;
    List<Ducha> duchas;

    public Fecha(Ducha d) {
        fecha = MetodosEstaticos.TomarFechaDeHoy();
        duchas = new ArrayList<>();
        add(d);
    }

    public void add(Ducha ducha) {
        duchas.add(ducha);
    }

    public String getFecha() {
        return this.toString();
    }

    @Override
    public String toString() {
        return  fecha;
    }

    public List<Ducha> getDuchas() {
        return duchas;
    }
}
