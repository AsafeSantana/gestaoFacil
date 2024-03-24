package com.santana.asafe.service;

import com.santana.asafe.model.Despesas;
import com.santana.asafe.repository.DespesasRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DespesasService {
    private DespesasRepository despesasRepository;

    //cadastrar despesas
    public Despesas cadastrarDespesa(LocalDate dataDespesa, String nomeDespesa, BigDecimal valorDespesa){
      Despesas despesas = new Despesas();
      despesas.setDataDespesa(dataDespesa);
      despesas.setNomeDespesa(nomeDespesa);
      despesas.setValorDespesa(valorDespesa);
      return despesasRepository.save(despesas);
    }


    //buscar despesas pela data
    public List<Despesas> buscarDespesasPelaData(LocalDate data) {
        return despesasRepository.findByDataDespesa(data);
    }

    //somar despesas do mes
    public  BigDecimal somarDespesasMensal(String mes){
        List<Despesas> despesasMes = despesasRepository.findByMes(mes);
        BigDecimal total = BigDecimal.ZERO;
        for (Despesas despesa : despesasMes){
            total = total.add(despesa.getValorDespesa());
        }
        return total;
    }
}
