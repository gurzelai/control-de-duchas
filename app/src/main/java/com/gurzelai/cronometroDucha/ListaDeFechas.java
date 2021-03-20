package com.gurzelai.cronometroDucha;

import java.util.ArrayList;
import java.util.List;

public class ListaDeFechas {

    List<Fecha> listaDeFechas;

    public ListaDeFechas() {
        listaDeFechas = new ArrayList<>();
        //no inicializar aqui porque se guardarán las duchas en mismo dia pero aparecera en distintos items
    }

    public void add(Ducha ducha) {
        java.lang.String hoy = MetodosEstaticos.TomarFechaDeHoyString();
        if (listaDeFechas.size() == 0 || !listaDeFechas.get(listaDeFechas.size() - 1).getFechaString().equals(hoy)) {
            listaDeFechas.add(new Fecha(ducha));
        } else {
            listaDeFechas.get(listaDeFechas.size() - 1).add(ducha);
        }
    }

    public List<Fecha> getFechas() {
        return listaDeFechas;
    }

}
