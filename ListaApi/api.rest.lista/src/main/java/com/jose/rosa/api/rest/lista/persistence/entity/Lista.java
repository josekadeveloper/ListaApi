package com.jose.rosa.api.rest.lista.persistence.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ArrayList<Integer> contenido;
    private int sumatorio;
}
