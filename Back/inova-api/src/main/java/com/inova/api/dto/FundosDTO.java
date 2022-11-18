package com.inova.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FundosDTO {

    private Long cdFndo;
    private String nomeFndo;
    private String nomeRisco;
    private Double desvioPadrao;

    public FundosDTO(Long cod, String nome, String risco, Double desvioPadrao) {
        this.cdFndo = cod;
        this.nomeFndo = nome;
        this.nomeRisco = risco;
        this.desvioPadrao = desvioPadrao;
    }
}
