package com.inova.api.controller;

import com.inova.api.service.InovaService;
import com.inova.api.dto.FundosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/fundo")
public class InovaController {

    @Autowired
    private InovaService inovaService;

    @GetMapping(path = "/{perfil}")
    public List<FundosDTO> getFundosByPerfil(@PathVariable String perfil) {
        return  inovaService.getFundosByPerfil(perfil);
    }
}
