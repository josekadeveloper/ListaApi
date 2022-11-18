package com.jose.rosa.api.rest.lista.mapper;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.jose.rosa.api.rest.lista.exceptions.ListaExceptions;
import com.jose.rosa.api.rest.lista.persistence.entity.Lista;
import com.jose.rosa.api.rest.lista.service.dto.ListaInDTO;
import com.jose.rosa.api.rest.lista.util.ValidarLista;

@Component
public class ListaInDTOToLista implements IMapper<ListaInDTO, Lista>{

    private final ValidarLista validarLista;

    public ListaInDTOToLista(ValidarLista validarLista) {
        this.validarLista = validarLista;
    }
    
    @Override
    public Lista map(ListaInDTO in) {
        Lista lista = new Lista();

        ArrayList<Integer> a = in.getContenido();
        ArrayList<Integer> b = new ArrayList<Integer>();

        int sumaTotal = 0;
        boolean repetido = false;
        boolean fueraDeRango = false;

        if (a != null) {
            if (a.size() == 100) {
                lista = validarLista.comprobarRango(a, b, fueraDeRango, repetido, sumaTotal, lista, in);
            } else {
                throw new ListaExceptions("La lista debe ser de 100 números", HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new ListaExceptions("La lista no puede ser nula", HttpStatus.BAD_REQUEST);
        }
        return lista;
    }
}
