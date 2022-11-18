package com.inova.api.repository;

import com.inova.api.model.Fundo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FundosRepository extends JpaRepository<Fundo, List> {

    @Query(value = "SELECT f.CD_FNDO , f.NOME_FNDO, r.NOME_RISCO, stdev(c.COT_FNDO) DESVIO_PADRAO FROM INOVA.dbo.FUNDO f \n" +
            "INNER JOIN INOVA.dbo.COTA c \n" +
            "ON f.CD_FNDO = c.CD_FNDO \n" +
            "INNER JOIN INOVA.dbo.RISCO r \n" +
            "ON f.ID_RISCO = r.ID_RISCO\n" +
            "WHERE f.DT_ENCERRAMENTO_FNDO = '1900-01-01'\n" +
            "GROUP BY f.CD_FNDO , f.NOME_FNDO, r.NOME_RISCO, r.ID_RISCO \n" +
            "ORDER BY r.ID_RISCO, stdev(c.COT_FNDO)", nativeQuery = true)
    public List<Fundo> findAll();
}
