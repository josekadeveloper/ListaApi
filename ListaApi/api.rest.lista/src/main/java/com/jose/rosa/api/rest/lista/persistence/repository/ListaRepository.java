package com.jose.rosa.api.rest.lista.persistence.repository;

import com.jose.rosa.api.rest.lista.persistence.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long>{}
