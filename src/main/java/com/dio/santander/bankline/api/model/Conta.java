package com.dio.santander.bankline.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private Long numero;

    @Column(name = "conta_saldo")
    private Double saldo;
}
