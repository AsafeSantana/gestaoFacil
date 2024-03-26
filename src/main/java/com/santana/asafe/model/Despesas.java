package com.santana.asafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dataDespesa;
    private String nomeDespesa;
    private BigDecimal valorDespesa;
    private String mes;
}
