package com.jose.rosa.api.rest.lista.util;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.jose.rosa.api.rest.lista.exceptions.ListaExceptions;
import com.jose.rosa.api.rest.lista.persistence.entity.Lista;
import com.jose.rosa.api.rest.lista.service.dto.ListaInDTO;

@Component
public class ValidarLista {
    
    public Lista comprobarRango(ArrayList<Integer> a, ArrayList<Integer> b,
                        boolean fueraDeRango, boolean repetido, int sumaTotal, Lista lista,
                        ListaInDTO in) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 1 && a.get(i) <= 100 && fueraDeRango == false) {
                int contador = 0;
                b.add(a.get(i));
                sumaTotal += a.get(i);
                lista = comprobarRepetidos(a, b, contador, repetido, i, sumaTotal, lista, in);
            } else {
                fueraDeRango = true;
                sumaTotal = 0;
                throw new ListaExceptions("Los números de la lista deben estar en el rango (1-100) ambos inclusive", HttpStatus.BAD_REQUEST);
            }
        }
        return lista;
    }

    public Lista comprobarRepetidos(ArrayList<Integer> a, ArrayList<Integer> b,
                            int contador, boolean repetido, int i, int sumaTotal, Lista lista,
                            ListaInDTO in) {
        for (int j = 0; j < b.size(); j++) {
            if (contador == 1) repetido = true;
            if (repetido == false) {
                if (a.get(i) == b.get(j)) {
                    contador++;
                    if (j == a.size()-1) {
                        lista.setContenido(in.getContenido());
                        lista.setSumatorio(sumaTotal);
                    }
                }
            } else {
                sumaTotal = 0;
                throw new ListaExceptions("La lista no puede contener números repetidos", HttpStatus.BAD_REQUEST);
            }
        }
        return lista;
    }
}
