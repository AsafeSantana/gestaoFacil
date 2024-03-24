package com.santana.asafe.controller;

import com.santana.asafe.model.Despesas;
import com.santana.asafe.service.DespesasService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class DespesasController {

    @Autowired
    private DespesasService despesasService;


    //cadastrar despesa
    @PostMapping("/cadastrar")
    public Despesas cadastrarDespesa(@RequestParam LocalDate dataDespesa, @RequestParam String nomeDespesa, BigDecimal valorDespesa){
        return despesasService.cadastrarDespesa(dataDespesa,nomeDespesa,valorDespesa);
    }

    //buscar despesas pela data
    @GetMapping("/buscar/{data}")
    public List<Despesas> buscarDespesasPelaData(@PathVariable LocalDate data) {
        return despesasService.buscarDespesasPelaData(data);
    }

    //exibir total mensal
    @GetMapping("/total/{mes}")
    public ResponseEntity<BigDecimal> calcularTotalMes(@PathVariable String mes){
        BigDecimal totalDespesas = despesasService.somarDespesasMensal(mes);
        return ResponseEntity.ok(totalDespesas);
    }



}
