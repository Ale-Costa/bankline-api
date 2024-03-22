package com.dio.santander.bankline.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_movimentacao")
@Data
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;
    private String descricao;
    private Double valor;
    private Integer idConta;

    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;

}
