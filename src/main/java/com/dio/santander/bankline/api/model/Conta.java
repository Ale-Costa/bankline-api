package com.dio.santander.bankline.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private Long numero;

    @Column(name = "conta_saldo")
    private Double saldo;
}
