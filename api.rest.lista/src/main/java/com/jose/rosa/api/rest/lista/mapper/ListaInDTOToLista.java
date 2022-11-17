package com.jose.rosa.api.rest.lista.mapper;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.jose.rosa.api.rest.lista.exceptions.ListaExceptions;
import com.jose.rosa.api.rest.lista.persistence.entity.Lista;
import com.jose.rosa.api.rest.lista.service.dto.ListaInDTO;

@Component
public class ListaInDTOToLista implements IMapper<ListaInDTO, Lista>{
    
    @Override
    public Lista map(ListaInDTO in) {
        Lista lista = new Lista();

        ArrayList<Integer> a = in.getContenido();
        ArrayList<Integer> b = new ArrayList<Integer>();

        int sumaTotal = 0;
        boolean repetido = false;
        boolean fueraDeRango = false;

        if (a.size() == 100) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) >= 1 && a.get(i) <= 100 && fueraDeRango == false) {
                    int contador = 0;
                    b.add(a.get(i));
                    sumaTotal += a.get(i);
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
                } else {
                    fueraDeRango = true;
                    sumaTotal = 0;
                    throw new ListaExceptions("Los números de la lista deben estar en el rango (1-100) ambos inclusive", HttpStatus.BAD_REQUEST);
                }  
            }
        } else {
            throw new ListaExceptions("La lista debe ser de 100 números", HttpStatus.BAD_REQUEST);
        }
        return lista;
    }
}
