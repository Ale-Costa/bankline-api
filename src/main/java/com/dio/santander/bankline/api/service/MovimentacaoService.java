package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.MovimentacaoDto;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(MovimentacaoDto movimentacaoDto){
        Movimentacao movimentacao = new Movimentacao();
        Double valor = movimentacaoDto.getTipo() == MovimentacaoTipo.RECEITA ? movimentacaoDto.getValor() : movimentacaoDto.getValor() * -1;
        Double valorFormatado = BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_UP).doubleValue();
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(movimentacaoDto.getDescricao());
        movimentacao.setIdConta(movimentacaoDto.getIdConta());
        movimentacao.setTipo(movimentacaoDto.getTipo());
        movimentacao.setValor(valorFormatado);

        Correntista correntista = correntistaRepository.findById(movimentacaoDto.getIdConta()).orElse(null);

        if (correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valorFormatado);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);

    }
}
