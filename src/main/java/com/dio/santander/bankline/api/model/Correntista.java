package com.dio.santander.bankline.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tab_correntista")
public class Correntista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String cpf;

    @Column(length = 60)
    private String nome;

    @Embedded
    private Conta conta;
}
