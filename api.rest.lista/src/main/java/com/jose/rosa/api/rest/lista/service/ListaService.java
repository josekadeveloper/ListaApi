package com.jose.rosa.api.rest.lista.service;

import org.springframework.stereotype.Service;

import com.jose.rosa.api.rest.lista.persistence.repository.ListaRepository;
import com.jose.rosa.api.rest.lista.service.dto.ListaInDTO;
import com.jose.rosa.api.rest.lista.mapper.ListaInDTOToLista;
import com.jose.rosa.api.rest.lista.persistence.entity.Lista;

@Service
public class ListaService {
    
    private final ListaRepository repository;
    private final ListaInDTOToLista mapper;

    public ListaService(ListaRepository repository, ListaInDTOToLista mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Lista createLista(ListaInDTO listaInDTO) {
        Lista lista = mapper.map(listaInDTO);
        return this.repository.save(lista);
    }
}
