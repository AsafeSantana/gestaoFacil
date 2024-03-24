package com.santana.asafe.repository;

import com.santana.asafe.model.Despesas;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesasRepository extends JpaRepository <Despesas, Id>{
    List<Despesas> findByMes(String mes);

    List<Despesas> findByDataDespesa(LocalDate data);
}
