package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDto {
    private String descricao;
    private Double valor;
    private Integer idConta;
    private MovimentacaoTipo tipo;
}
