package com.gurzelai.cronometroDucha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fecha implements Serializable {

    String fecha;
    List<Ducha> duchas;
    Date date;

    public Fecha(Ducha d) {
        date = new Date();
        fecha = MetodosEstaticos.TomarFechaDeHoyString();
        duchas = new ArrayList<>();
        add(d);
    }

    public void add(Ducha ducha) {
        duchas.add(ducha);
    }

    public String getFechaString() {
        return this.toString();
    }

    public Date getDate(){
        return date;
    }

    @Override
    public String toString() {
        return  fecha;
    }

    public List<Ducha> getDuchas() {
        return duchas;
    }
}
