package com.inova.api.service;

import com.inova.api.dto.FundosDTO;
import com.inova.api.model.Fundo;
import com.inova.api.repository.FundosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InovaService {

    @Autowired
    private FundosRepository repository;

    public List<FundosDTO> getFundosByPerfil(String perfil) {
        List<Fundo> result = repository.findAll();
        if (perfil.equals("0")) {
            result = result.subList(0, 3);
        } else if (perfil.equals("2")) {
            result = result.subList(result.size() - 3, result.size());
        } else if (perfil.equals("1")) {
            result = result.subList(result.size() / 2 - 1, result.size() / 2 + 2);
        } else {
            return null;
        }

        List<FundosDTO> lista = List.of(
                new FundosDTO(result.get(0).getCdFndo(), result.get(0).getNomeFndo(), result.get(0).getNomeRisco(), result.get(0).getDesvioPadrao()),
                new FundosDTO(result.get(1).getCdFndo(), result.get(1).getNomeFndo(), result.get(1).getNomeRisco(), result.get(1).getDesvioPadrao()),
                new FundosDTO(result.get(2).getCdFndo(), result.get(2).getNomeFndo(), result.get(2).getNomeRisco(), result.get(2).getDesvioPadrao())
        );

//        List<FundosDTO> result1 = result.stream().map(x -> new FundosDTO[](x)).collect(Collectors.toList());
//        List<FundosDTO> fundos;

        return lista;
    }
}
