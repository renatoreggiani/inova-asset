package com.inova.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fundo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdFndo;
    private String nomeFndo;
    private String nomeRisco;
    private Double desvioPadrao;

    public String getNomeFndo() {
        return nomeFndo;
    }

    public Long getCdFndo() {
        return cdFndo;
    }

    public String getNomeRisco() {
        return nomeRisco;
    }

    public Double getDesvioPadrao() {
        return desvioPadrao;
    }


}


