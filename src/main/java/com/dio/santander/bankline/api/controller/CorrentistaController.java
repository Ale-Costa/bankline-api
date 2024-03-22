package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return correntistaRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody CorrentistaDTO correntistaDTO){
        service.save(correntistaDTO);
    }
}
