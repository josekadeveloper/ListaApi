package com.jose.rosa.api.rest.lista.controller;

import com.jose.rosa.api.rest.lista.service.ListaService;
import com.jose.rosa.api.rest.lista.service.dto.ListaInDTO;
import com.jose.rosa.api.rest.lista.persistence.entity.Lista;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listas")
public class ListaController {
    
    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @PostMapping
    public Lista createLista(ListaInDTO listaInDTO) {
        return this.listaService.createLista(listaInDTO);
    }
}
